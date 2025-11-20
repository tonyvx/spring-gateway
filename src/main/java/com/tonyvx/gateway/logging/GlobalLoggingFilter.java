package com.tonyvx.gateway.logging;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class GlobalLoggingFilter implements GlobalFilter {
    Log log = LogFactory.getLog(getClass());

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        var req = exchange.getRequest();
        Route route = exchange.getAttribute(ServerWebExchangeUtils.GATEWAY_ROUTE_ATTR);

        String token = req.getHeaders().getFirst(HttpHeaders.AUTHORIZATION);
        String masked = token != null ? token.substring(0, 20) + "..." : "none";

        long start = System.currentTimeMillis();
        return chain.filter(exchange).then(Mono.fromRunnable(() -> {
            long time = System.currentTimeMillis() - start;
            var requestUrl = req.getURI();
            String serviceId = route != null ? route.getId() : "none";
            var serviceUrl = route != null ? route.getUri() : "none";
            HttpStatusCode statusCode = exchange.getResponse().getStatusCode();
            log.info(String.format("\nREQUEST %s\n→ Routed to:\n  ID: %s\n  URI: %s\nToken: %s\nRESPONSE %s in %s ms",
                    requestUrl, serviceId, serviceUrl, token, statusCode, time));
        }));
    }
}

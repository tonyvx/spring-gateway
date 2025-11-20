package com.tonyvx.gateway.security;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.autoconfigure.metrics.MetricsProperties.Web.Client;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("keycloak")
public class KeycloakClientConfig {
    
    private Client client;
    
    @Value("${spring.security.oauth2.client.registration.keycloak.authorization-url}")
    private String authorizationUrl;
    
    @Value("${spring.security.oauth2.client.registration.keycloak.token-url}")
    private String tokenUrl;
    
    public Client getClient() {
        return client;
    }
    
    public void setClient(Client client) {
        this.client = client;
    }
}

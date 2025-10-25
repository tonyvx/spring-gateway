# Spring Gateway Project

This project is a Spring Cloud Gateway application that serves as a gateway for routing requests to various microservices. It is built using Spring Boot and leverages the capabilities of Spring Cloud to provide a robust and flexible gateway solution.

## Project Structure

The project is organized as follows:

```
spring-gateway
├── gradlew                  # Shell script for running Gradle commands
├── gradlew.bat              # Batch file for running Gradle commands on Windows
├── build.gradle             # Gradle configuration file
├── settings.gradle          # Gradle settings file
├── gradle.properties        # Gradle properties file
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── .gitignore               # Git ignore file
├── README.md                # Project documentation
└── src
    ├── main
    │   ├── java
    │   │   └── com
    │   │       └── tonyvx
    │   │           └── springgateway
    │   │               ├── SpringGatewayApplication.java  # Main application entry point
    │   │               └── config
    │   │                   └── GatewayConfig.java        # Gateway configuration
    │   └── resources
    │       ├── application.yml                             # Main application configuration
    │       └── bootstrap.yml                               # Bootstrap configuration
    └── test
        └── java
            └── com
                └── tonyvx
                    └── springgateway
                        └── SpringGatewayApplicationTests.java  # Test cases for the application
```

## Getting Started

To run the application, you can use the provided `gradlew` or `gradlew.bat` scripts. Ensure you have Java installed on your machine.

1. Clone the repository:
   ```
   git clone <repository-url>
   cd spring-gateway
   ```

2. Build the application:
   ```
   ./gradlew build   # On Unix-based systems
   gradlew.bat build # On Windows
   ```

3. Run the application:
   ```
   ./gradlew bootRun   # On Unix-based systems
   gradlew.bat bootRun # On Windows
   ```

## Configuration

The application configuration can be found in the `src/main/resources/application.yml` and `src/main/resources/bootstrap.yml` files. You can customize the gateway routes and filters in the `GatewayConfig.java` file.

## Testing

To run the tests, use the following command:
```
./gradlew test   # On Unix-based systems
gradlew.bat test # On Windows
```

## Data
```sh
curl -X POST \
  http://localhost:8080/certifications/api/certificates \
  -H 'Content-Type: application/json' \
  -d '{"title": "AWS Developer - Associate", "description": "AWS Certified Developer - Associate validates technical expertise in developing and maintaining applications on the AWS platform.", "notes": "", "certificateUrl": "", "dateOfCertification": "", "status": "in-progress"}'

```

## Actuator Endpoints

The application exposes actuator endpoints, including `/actuator/info` and `/actuator/gateway`. The `/actuator/info` endpoint includes build, git, Java, Spring Boot, and Spring Gateway version information.

## License

This project is licensed under the MIT License. See the LICENSE file for more details.
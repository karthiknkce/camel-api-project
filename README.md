# camel-api-project
# Camel API Service

A simple Spring Boot + Apache Camel project that calls an external REST API.

## Features
- Calls external REST API on a schedule
- Manual trigger via REST endpoint
- XML-based Camel routes
- YAML configuration
- Docker support
- Health checks and monitoring

## Quick Start

### Prerequisites
- Java 17
- Maven 3.6+
- Docker (optional)

### Build and Run
```bash
# Clone the project
git clone <repository-url>
cd camel-api-project

# Build the project
mvn clean package

# Run the application
java -jar target/camel-api-service-1.0.0.jar




camel-api-project.zip
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── camel/
│   │   │           └── api/
│   │   │               ├── Application.java
│   │   │               ├── config/
│   │   │               │   └── CamelConfiguration.java
│   │   │               ├── processor/
│   │   │               │   └── ApiResponseProcessor.java
│   │   │               └── service/
│   │   │                   └── ApiService.java
│   │   └── resources/
│   │       ├── application.yml
│   │       └── camel-routes.xml
│   └── test/
│       └── java/
│           └── com/
│               └── camel/
│                   └── api/
│                       └── ApplicationTest.java
├── pom.xml
├── Dockerfile
├── docker-compose.yml
├── README.md
└── .gitignore

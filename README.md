Shopping Cart Full Stack is a microservices-based e-commerce application built with Spring Boot,Angular, MongoDB, MySQL, Kafka, Keycloak, and Grafana. The system includes multiple services such as API Gateway, Product Service, Order Service, Inventory Service, and Notification Service.

Technologies Used

Backend: Spring Boot, Spring Cloud, JPA, Hibernate, MySQL, MongoDB

Frontend: Angular, Tailwind CSS

Security: Keycloak for authentication and authorization

Event-Driven Architecture: Apache Kafka

Monitoring & Logging: Prometheus, Grafana, Loki, Tempo

Containerization: Docker, Docker Compose

Architecture

The system follows a microservices architecture where each service runs independently and communicates through REST APIs or event-driven Kafka topics.

🚀 Features
✅ API Gateway - Routes requests and manages authentication.
✅ Product Service - Handles product management.
✅ Inventory Service - Tracks stock availability.
✅ Order Service - Manages order creation and processing.
✅ Notification Service - Sends order confirmation notifications via Kafka.
✅ Event-Driven Architecture - Uses Kafka for inter-service communication.
✅ Containerization - Dockerized microservices using docker-compose.

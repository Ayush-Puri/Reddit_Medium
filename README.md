Reddit-Medium Hybrid Platform (Microservices Architecture)

Overview

This project is a Reddit + Medium-inspired platform that enables users to submit projects, post discussions, comment, and interact with other users in a microservices architecture. The platform is built using Spring Boot, Spring WebFlux, and Microservices, ensuring scalability, performance, and efficiency.

Key Features

Modular Microservices Architecture: The platform is designed with separate services for:

User Authentication & Subscriptions

Project Submissions & Discussions

Reactive Read Service for high-volume, non-blocking data retrieval

Asynchronous & Non-Blocking Reads: Implemented Spring WebFlux to handle a 1000:1 read-to-write ratio, improving responsiveness and concurrency.

Search Optimization: Integrated Elasticsearch to enable fast search by title, description, and metadata, enhancing content discoverability.

Scalability with Spring Cloud: Used Netflix Eureka for service discovery, allowing horizontal scalability across multiple instances.

Spring Security Integration: Ensuring secure user authentication and API access control.

Technology Stack

Backend: Java, Spring Boot, Spring WebFlux, Spring Security, Spring Data JPA, Hibernate

Microservices: Spring Cloud, Netflix Eureka

Database: PostgreSQL (Primary Database), Elasticsearch (Search Optimization)

API Gateway: Spring Cloud Gateway (for request routing and load balancing)

Authentication: JWT-based authentication with Spring Security

Infrastructure & Deployment: Docker, Kubernetes (future scope)

Microservices Breakdown

Service Name

Description

User Service

Handles authentication, subscriptions, and user management

Post Service

Manages project submissions, discussions, and comments

Read Service

Optimized for high-volume, non-blocking reads using WebFlux

Search Service

Enables fast search and indexing with Elasticsearch

API Gateway

Routes requests to appropriate services & provides load balancing

Service Discovery

Netflix Eureka enables seamless service registration and discovery

Installation & Running Locally

To run this project locally, follow these steps:

Prerequisites

Ensure you have the following installed:

Java 17+

Gradle

PostgreSQL

Docker (optional, for containerized deployment)

Clone the Repository

git clone https://github.com/your-username/reddit-medium-platform.git
cd reddit-medium-platform

Configure Database

Update application.properties or environment variables for PostgreSQL configuration:

spring.datasource.url=jdbc:postgresql://localhost:5432/reddit_medium
spring.datasource.username=your_username
spring.datasource.password=your_password

Build & Run the Application

./gradlew build
./gradlew bootRun

Alternatively, to run with Docker:

docker-compose up --build

API Endpoints

Endpoint

Method

Description

/api/auth/register

POST

Register a new user

/api/auth/login

POST

Authenticate and get JWT token

/api/posts

GET

Fetch all posts

/api/posts/{id}

GET

Fetch post by ID

/api/comments/{postId}

GET

Fetch comments for a post

/api/search?query=xyz

GET

Search for projects and discussions

Future Enhancements

Implement Kubernetes for better orchestration

Add GraphQL support for optimized data fetching

Introduce Kafka for real-time event streaming

Enhance CI/CD pipeline for automated deployment

Contributing

Contributions are welcome! If you'd like to contribute, follow these steps:

Fork the repository

Create a new branch (feature-xyz)

Commit your changes

Push the branch and create a PR

License

This project is licensed under the MIT License. Feel free to modify and distribute.

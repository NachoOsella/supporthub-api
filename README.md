# SupportHub API

> A clean, modular Spring Boot backend for a support and ticketing platform.

![Java](https://img.shields.io/badge/Java-21-E76F00?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![Maven](https://img.shields.io/badge/Maven-Build-C71A36?style=for-the-badge&logo=apachemaven&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-Database-336791?style=for-the-badge&logo=postgresql&logoColor=white)
![Docker](https://img.shields.io/badge/Docker-Compose-2496ED?style=for-the-badge&logo=docker&logoColor=white)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI-85EA2D?style=for-the-badge&logo=swagger&logoColor=black)
![Spring Security](https://img.shields.io/badge/Spring%20Security-Enabled-2A7A2E?style=for-the-badge&logo=springsecurity&logoColor=white)

SupportHub API is a portfolio-ready backend project built to model a real help desk workflow: users create tickets, teams manage ticket lifecycles, and the platform evolves toward comments, attachments, notifications, and audit history.

It is designed to showcase practical backend engineering decisions recruiters care about: layered architecture, DTO-based APIs, validation, persistence, OpenAPI documentation, and a clear domain model that can scale into a production-grade support system.

## Why This Project Stands Out

- Built with **Java 21** and **Spring Boot 3**
- Uses a **modular package structure** by business domain
- Separates **controller, service, repository, DTO, entity, and mapper** responsibilities
- Includes **Spring Data JPA**, **Bean Validation**, and **Swagger / OpenAPI**
- Runs with **PostgreSQL** locally and **H2** for tests
- Prepared for feature growth across support operations and internal tooling

## Tech Stack

- Java 21
- Spring Boot 3.5
- Spring Web
- Spring Data JPA
- Spring Validation
- Spring Security
- PostgreSQL
- H2
- MapStruct
- Lombok
- Springdoc OpenAPI
- Maven
- Docker Compose

## Architecture

The codebase is organized by domain, which keeps features isolated and easy to extend:

```text
src/main/java/com/supporthub/api
├── attachments
├── auditlog
├── comments
├── config
├── exception
├── notifications
├── tickets
└── users
```

Each module follows a familiar backend structure:

- `controller` for HTTP endpoints
- `service` for business logic
- `repository` for persistence
- `dto` for request / response contracts
- `entity` for JPA models
- `mapper` where object mapping is needed

This makes the project easy to review technically and easy to maintain as more workflows are introduced.

## Domain Overview

SupportHub is modeled around the core entities of a customer support platform:

- `User`
- `Ticket`
- `Comment`
- `Attachment`
- `Notification`
- `AuditLog`

Target relationship design:

```text
User 1 --- * Ticket        (customer)
User 1 --- * Ticket        (assignedAgent, optional)
Ticket 1 --- * Comment
User 1 --- * Comment       (author)
Ticket 1 --- * Attachment
User 1 --- * Attachment    (uploadedBy)
User 1 --- * Notification
Ticket 1 --- * AuditLog    (optional)
User 1 --- * AuditLog      (actor, optional)
```

## Current API Surface

Implemented and working:

- `GET /users`
- `GET /users/{id}`
- `POST /users`
- `GET /tickets`
- `GET /tickets/{id}`
- `POST /tickets`
- `GET /tickets/{ticketId}/comments`
- `POST /tickets/{ticketId}/comments`

Present as domain scaffolding and ready for expansion:

- `/attachments`
- `/notifications`
- `/audit-log`

Interactive API docs are available through Swagger UI:

- `http://127.0.0.1:8080/api`

## Local Development

### 1. Start PostgreSQL

```bash
docker compose up -d
```

### 2. Run the application

```bash
mvn spring-boot:run
```

### 3. Run tests

```bash
mvn test
```

## Configuration

The application reads its main settings from environment variables with sensible local defaults:

| Variable | Default |
| --- | --- |
| `HOST` | `127.0.0.1` |
| `PORT` | `8080` |
| `DATABASE_URL` | `jdbc:postgresql://localhost:5432/supporthub` |
| `DATABASE_USER` | `postgres` |
| `DATABASE_PASSWORD` | `postgres` |

Swagger UI path:

- `/api`

## Security Status

Spring Security is already wired into the project, but the current configuration allows all requests and disables CSRF to keep development friction low while the API surface is being built.

That means the codebase already has the right foundation for future hardening, but authentication and authorization are still part of the next implementation phase.

## What This Project Demonstrates

For recruiters and technical reviewers, this repository highlights:

- Strong Spring Boot project structure
- Clean separation of concerns
- Thoughtful domain modeling for a real business problem
- Use of DTOs and validation instead of exposing entities directly
- Readiness for iterative product growth
- Practical backend tooling, including database containers and API documentation

## Roadmap

Planned next steps include:

- Ticket assignment workflows
- Status transition rules
- Role-based access control
- Attachment upload flow
- Notification delivery logic
- Audit trail coverage for key actions
- More complete integration and security testing

## Repository Snapshot

This project is intentionally positioned as more than a tutorial scaffold. It is a backend foundation for a realistic support platform and a strong base for demonstrating backend engineering skills in interviews, portfolio reviews, and technical screenings.

# Enlace - Microservices API Documentation

Enlace is a modular social platform designed to manage small groups (called "cells") and communities. This repository contains the **User API** and **Group API**, which are key microservices in the Enlace ecosystem.

## 🧩 Microservices Overview

- **Group API**: Handles group creation, membership, roles, and group-related configurations.

---

## 📦 Technologies

- Java 17+
- Quarkus (Reactive Stack)
- PostgreSQL 14
- Hibernate Reactive & Panache
- Flyway (Database migrations)
- Docker & Docker Compose
- Maven

---

## 📁 Project Structure

```bash
enlace/
├── user-api/         # User microservice
├── group-api/        # Group microservice
└── docker-compose.yml
```

---

## ▶️ Getting Started

### Prerequisites

- Docker & Docker Compose
- JDK 17+
- Maven 3.9+

### Running with Docker Compose

```bash
docker-compose up --build
```

This will start PostgreSQL and both services (if Dockerfiles are provided).

---

## 👥 Group API

### Base URL

```
http://localhost:8282/api/groups
```

### Endpoints

| Method | Path                    | Description                         |
|--------|-------------------------|-------------------------------------|
| GET    | `/`                     | List all groups                     |
| GET    | `/{groupId}`            | Get group details by ID             |
| POST   | `/`                     | Create a new group                  |
| PUT    | `/{groupId}`            | Update group details                |
| DELETE | `/{groupId}`            | Delete a group                      |
| POST   | `/{groupId}/members`    | Add member(s) to group              |
| DELETE | `/{groupId}/members`    | Remove member(s) from group         |

---

## 🔧 Configuration

All service configuration can be managed via `application.yml`:

```yaml
quarkus:
  datasource:
    db-kind: postgresql
    username: enlace
    password: 3nl4c3
    jdbc:
      url: jdbc:postgresql://localhost:5433/user
  flyway:
    migrate-at-start: true
    locations: db/migration
```

---

## 📌 Notes

- Database scripts are located in `/db/migration`.
- The project uses **Flyway** to manage schema evolution.
- Both APIs follow RESTful principles and use JSON for communication.

---

## 📫 Contact

For questions or contributions, please contact the Enlace development team or open an issue.

---

## License

This project is licensed under the MIT License.

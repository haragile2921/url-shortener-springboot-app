# URL Shortener – Spring Boot + H2
A simple URL shortener application built with **Java 17**, **Spring Boot**, and **H2 in-memory database**.
## Features
- Shorten any long URL
- Redirect from short URL to the original
- Uses H2 for quick testing (no external DB needed)
- REST API endpoints for frontend integration
## Tech Stack
- Java 17
- Spring Boot 3.x
- Spring Data JPA
- H2 Database
## Endpoints
### 1. Shorten URL
**POST** `/shorten`  
Request Body: (raw text or JSON string)

### 2. Redirect
**GET** `/{shortCode}`  
Redirects to the original URL.
## Running the App
### 1. Prerequisites
- Java 17+
- Maven 3.x
### 2. Build & Run
```bash
mvn spring-boot:run

curl -X POST http://localhost:8080/shorten -d "https://example.com"
 

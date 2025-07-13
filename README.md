# DSPosts
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://github.com/Luis-Parente/DSPosts/blob/main/LICENSE)

## Description
This is a simple RESTful API built with Java Spring Boot and MongoDB for study purposes. The project demonstrates how to perform CRUD operations on blog posts and users.

## 📋 Features
- User and post management
- MongoDB integration with Spring Data
- RESTful API with CRUD operations
- DTO pattern for data transfer and encapsulation
- Basic one-to-many relationship (User ↔ Posts)
- Data validation with Jakarta Bean Validation
- Swagger UI for interactive API documentation
- Postman collection for API testing
- Dockerized MongoDB instance
- Layered architecture (Controller, Service, Repository)

## ✅ Requirements
- Java 21+
- Docker
- Git

## 🛠️ Installation & Execution

### Clone the Repository
```bash
git clone https://github.com/Luis-Parente/DSPosts
cd dsposts
````

### Start MongoDB with Docker
```bash
docker run --name dsmongo -p 27017:27017 -d mongo
````
MongoDB will be accessible on http://localhost:27017

### Build the project:
```bash
./mvnw clean install
````
### Start the Application
```bash
./mvnw spring-boot:run
````

### The application will start on http://localhost:8080

## 🔍 Testing the API
You can test the API in two ways:

### Swagger UI
Accessible at http://localhost:8080/swagger-ui/index.html. It provides a full list of available endpoints with detailed request/response schemas and example payloads.

### Postman
Use Postman for a more flexible API testing experience.

The repository includes a Postman collection (DSPosts.postman_collection.json)

- Go to File > Import
- Select the .json files from the repository
- You can then send requests directly using the pre-configured endpoints and data.

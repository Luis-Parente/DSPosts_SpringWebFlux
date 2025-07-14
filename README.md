# DSPosts_SpringWebFlux
[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg?style=for-the-badge)](https://github.com/Luis-Parente/DSPosts_SpringWebFlux/blob/main/LICENSE)

## Description
This project is an adaptation of the DSPosts project, featuring a transition to Spring WebFlux and Reactive MongoDB. It was created for study purposes and demonstrates how to perform CRUD operations on blog posts and users.

## 📋 Features
- User and post management
- Reactive integration with MongoDB using Spring Data Reactive
- RESTful API with asynchronous and non-blocking operations
- DTO pattern for data encapsulation
- Validation using Jakarta Bean Validation
- Interactive API documentation with Swagger UI
- Postman collection for API testing
- MongoDB instance via Docker
- Layered architecture (Controller, Service, Repository)

## ✅ Requirements
- Java 21+
- Docker
- Git

## 🛠️ Installation & Execution

### Clone the Repository
```bash
git clone https://github.com/Luis-Parente/DSPosts_SpringWebFlux
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

The repository includes a Postman collection (DSPosts_WebFlux.postman_collection)

- Go to File > Import
- Select the .json files from the repository
- You can then send requests directly using the pre-configured endpoints and data.

## 🧰 Tech Stack
- Java 21
- Spring WebFlux
- Spring Data Reactive MongoDB
- MongoDB
- Docker
- Swagger / OpenAPI
- Maven

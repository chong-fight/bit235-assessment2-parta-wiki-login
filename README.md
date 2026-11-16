# The Commons

The Commons is a small Wiki-style web application created for the BIT235 Object
Oriented Programming preparation homework.

## Features

- Spring Boot web application
- Thymeleaf server-rendered pages
- Responsive home and about pages
- Embedded CSS with no external frontend dependencies
- Spring Boot DevTools for local development

## Requirements

- Java 21
- A web browser

## Run locally

Open a terminal in this project directory and run:

```powershell
.\mvnw.cmd spring-boot:run
```

Then visit:

- Home: http://127.0.0.1:8080/
- About: http://127.0.0.1:8080/about

## Run tests

```powershell
.\mvnw.cmd test
```

## Project structure

```text
src/main/java/com/example/testwikiapp/
├── controller/HomeController.java
└── TestwikiappApplication.java

src/main/resources/templates/
├── index.html
└── about.html
```

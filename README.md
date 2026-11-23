# The Commons

The Commons is a small Wiki-style web application created for the BIT235 Object
Oriented Programming preparation homework.

**Student:** He Yichong (s1580500)

## Assessment 2 Part A

The application now includes an administrator login flow built with Spring MVC:

1. The browser requests `GET /login`.
2. The administrator submits the form to `POST /login`.
3. `LoginController` passes the form data to `AuthenticationService`.
4. `AdminUserRepository` supplies the hard-coded administrator account.
5. Valid credentials create a session and open the welcome page.
6. Invalid credentials open the error page.

Demonstration credentials:

- Username: `he`
- Password: `123`

These credentials are intentionally hard-coded for Part A and are not suitable
for production use.

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

- Login: http://127.0.0.1:8080/login
- Home: http://127.0.0.1:8080/home
- About: http://127.0.0.1:8080/about

## Run tests

```powershell
.\mvnw.cmd test
```

## Project structure

```text
src/main/java/com/example/testwikiapp/
├── controller/HomeController.java
├── controller/LoginController.java
├── model/AdminUser.java
├── model/LoginForm.java
├── repository/AdminUserRepository.java
├── service/AuthenticationService.java
└── TestwikiappApplication.java

src/main/resources/templates/
├── index.html
├── about.html
├── login.html
├── login-error.html
└── welcome.html

src/main/resources/static/css/
└── auth.css

docs/architecture/
├── login-flow.md
├── login-flow.svg
└── project-structure.md
```

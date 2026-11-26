# BIT235 Assessment 2 - Part A

Simple Spring Boot administrator login application.

## Student

- Name: He Yichong
- Student ID: s1580500

## Login

- Username: `he`
- Password: `123`

## Run

```powershell
.\mvnw.cmd spring-boot:run
```

Open:

```text
http://127.0.0.1:8080/login
```

## MVC structure

- `controller/LoginController.java` handles requests and the session.
- `controller/HomeController.java` displays the protected home page.
- `service/AuthService.java` checks the submitted credentials.
- `repository/UserRepository.java` provides the hard-coded account.
- `model/User.java` stores the submitted username and password.
- `templates/` contains the login, error and home pages.

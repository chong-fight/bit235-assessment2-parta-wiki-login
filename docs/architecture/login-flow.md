# Administrator Login Architecture

This diagram shows how administrator credentials travel through the MVC
application for Assessment 2 Part A.

> Name: He Yichong | Student ID: s1580500  
> Generated from the Part A source code on 23 November 2026

```mermaid
flowchart LR
    Browser[Browser]
    Controller[LoginController<br/>@Controller]
    Service[AuthenticationService<br/>@Service]
    Repository[AdminUserRepository<br/>@Repository]
    Model[AdminUser / LoginForm<br/>Model]
    LoginView[login.html<br/>Thymeleaf View]
    WelcomeView[welcome.html<br/>Thymeleaf View]
    ErrorView[login-error.html<br/>Thymeleaf View]

    Browser -->|"GET /login"| Controller
    Controller --> LoginView
    Browser -->|"POST username + password"| Controller
    Controller --> Service
    Service --> Repository
    Repository --> Model
    Service -->|"valid credentials"| Controller
    Controller -->|"create session"| WelcomeView
    Service -->|"invalid credentials"| Controller
    Controller --> ErrorView
```

## Layer Responsibilities

- **Controller:** receives HTTP requests and chooses the response view.
- **Service:** checks the submitted password against the repository record.
- **Repository:** provides the hard-coded administrator account.
- **Model:** carries form input and the authenticated administrator.
- **View:** renders the login, success, and error pages with Thymeleaf.

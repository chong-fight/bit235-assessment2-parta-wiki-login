# Wiki Application Structure

```text
testwikiapp/
├── src/main/java/com/example/testwikiapp/
│   ├── controller/
│   │   ├── HomeController.java
│   │   └── LoginController.java
│   ├── model/
│   │   ├── AdminUser.java
│   │   └── LoginForm.java
│   ├── repository/
│   │   └── AdminUserRepository.java
│   ├── service/
│   │   └── AuthenticationService.java
│   └── TestwikiappApplication.java
├── src/main/resources/
│   ├── static/css/auth.css
│   ├── templates/
│   │   ├── login.html
│   │   ├── login-error.html
│   │   ├── welcome.html
│   │   ├── index.html
│   │   └── about.html
│   └── application.properties
└── pom.xml
```

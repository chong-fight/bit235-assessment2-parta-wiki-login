/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.controller;

import com.example.testwikiapp.model.AdminUser;
import com.example.testwikiapp.model.LoginForm;
import com.example.testwikiapp.service.AuthenticationService;
import jakarta.servlet.http.HttpSession;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.Optional;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles administrator login, welcome, error, and logout requests.
 */
@Controller
public class LoginController {

    private static final String ADMIN_NAME_SESSION_KEY = "adminName";
    private static final String STUDENT_ID_SESSION_KEY = "studentId";

    private final AuthenticationService authenticationService;

    public LoginController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    /**
     * Sends visitors to the administrator sign-in page.
     */
    @GetMapping("/")
    public String root() {
        return "redirect:/login";
    }

    /**
     * Displays an empty login form.
     */
    @GetMapping("/login")
    public String showLoginPage(Model model) {
        model.addAttribute("loginForm", new LoginForm());
        return "login";
    }

    /**
     * Receives the login form and delegates validation to the service layer.
     */
    @PostMapping("/login")
    public String submitLogin(
            @ModelAttribute LoginForm loginForm,
            HttpSession session
    ) {
        Optional<AdminUser> authenticatedUser = authenticationService.authenticate(
                loginForm.getUsername(),
                loginForm.getPassword()
        );

        if (authenticatedUser.isEmpty()) {
            return "redirect:/login-error";
        }

        AdminUser admin = authenticatedUser.get();
        session.setAttribute(ADMIN_NAME_SESSION_KEY, admin.displayName());
        session.setAttribute(STUDENT_ID_SESSION_KEY, admin.studentId());
        return "redirect:/welcome";
    }

    /**
     * Shows the welcome page only when an administrator is signed in.
     */
    @GetMapping("/welcome")
    public String showWelcomePage(HttpSession session, Model model) {
        Object adminName = session.getAttribute(ADMIN_NAME_SESSION_KEY);
        if (adminName == null) {
            return "redirect:/login";
        }

        model.addAttribute("adminName", adminName);
        model.addAttribute("studentId", session.getAttribute(STUDENT_ID_SESSION_KEY));
        model.addAttribute(
                "signedInAt",
                LocalDateTime.now().format(
                        DateTimeFormatter.ofPattern("dd MMM yyyy, HH:mm", Locale.ENGLISH)
                )
        );
        return "welcome";
    }

    /**
     * Displays the dedicated error page for rejected credentials.
     */
    @GetMapping("/login-error")
    public String showLoginErrorPage() {
        return "login-error";
    }

    /**
     * Ends the session and returns the administrator to the login page.
     */
    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "redirect:/login";
    }
}

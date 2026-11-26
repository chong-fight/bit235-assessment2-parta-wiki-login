/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.controller;

import com.example.testwikiapp.model.User;
import com.example.testwikiapp.service.AuthService;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

/**
 * Handles the login page, authentication result, home page and logout.
 */
@Controller
public class LoginController {

    private final AuthService authService;

    public LoginController(AuthService authService) {
        this.authService = authService;
    }

    @GetMapping("/")
    public String redirectToLogin() {
        // The login page is the entry point of the application.
        return "redirect:/login";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        // Bind an empty User object to the login form.
        model.addAttribute("user", new User());
        return "login";
    }

    @PostMapping("/login")
    public String login(
            @ModelAttribute User user,
            HttpSession session
    ) {
        if (authService.authenticate(user.getUsername(), user.getPassword())) {
            // Save the username so the home page can check the session.
            session.setAttribute("username", user.getUsername());
            return "redirect:/home";
        }
        // Invalid credentials are handled by the dedicated error page.
        return "redirect:/login-error";
    }

    @GetMapping("/login-error")
    public String loginError() {
        return "login-error";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        // Remove the login state before returning to the login page.
        session.invalidate();
        return "redirect:/login";
    }
}

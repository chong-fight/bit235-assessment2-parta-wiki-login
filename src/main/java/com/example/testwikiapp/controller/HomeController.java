/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.controller;

import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Displays the protected home page after a successful login.
 */
@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(HttpSession session, Model model) {
        // The home page cannot be opened without a valid login session.
        Object username = session.getAttribute("username");
        if (username == null) {
            return "redirect:/login";
        }

        // Send the logged-in username to the Thymeleaf page.
        model.addAttribute("username", username);
        return "home";
    }
}

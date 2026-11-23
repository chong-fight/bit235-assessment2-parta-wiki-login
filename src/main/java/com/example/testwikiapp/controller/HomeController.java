/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute(
                "intro",
                "A shared place for ideas, notes, and the knowledge we build together."
        );
        return "index";
    }

    @GetMapping("/about")
    public String about() {
        return "about";
    }
}

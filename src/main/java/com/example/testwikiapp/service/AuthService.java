/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.service;

import com.example.testwikiapp.repository.UserRepository;
import org.springframework.stereotype.Service;

/**
 * Contains the login validation logic.
 */
@Service
public class AuthService {

    private final UserRepository userRepository;

    public AuthService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean authenticate(String username, String password) {
        // Missing form values cannot be authenticated.
        if (username == null || password == null) {
            return false;
        }

        // Find the user first, then compare the submitted password.
        return userRepository.findByUsername(username.trim())
                .map(user -> user.getPassword().equals(password))
                .orElse(false);
    }
}

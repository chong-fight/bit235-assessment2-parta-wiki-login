/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.service;

import com.example.testwikiapp.model.AdminUser;
import com.example.testwikiapp.repository.AdminUserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

/**
 * Contains the administrator credential validation rules.
 */
@Service
public class AuthenticationService {

    private final AdminUserRepository adminUserRepository;

    public AuthenticationService(AdminUserRepository adminUserRepository) {
        this.adminUserRepository = adminUserRepository;
    }

    /**
     * Validates the submitted username and password.
     *
     * @return the authenticated administrator when both values match
     */
    public Optional<AdminUser> authenticate(String username, String password) {
        if (username == null || password == null) {
            return Optional.empty();
        }

        return adminUserRepository.findByUsername(username.trim())
                .filter(user -> user.password().equals(password));
    }
}

/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.repository;

import com.example.testwikiapp.model.User;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * Provides the single hard-coded administrator account required for Part A.
 */
@Repository
public class UserRepository {

    private static final User ADMIN = new User("he", "123");

    public Optional<User> findByUsername(String username) {
        // Part A uses one hard-coded administrator account.
        if (ADMIN.getUsername().equals(username)) {
            return Optional.of(ADMIN);
        }
        return Optional.empty();
    }
}

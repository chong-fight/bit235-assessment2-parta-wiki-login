/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.repository;

import com.example.testwikiapp.model.AdminUser;
import java.util.Optional;
import org.springframework.stereotype.Repository;

/**
 * Supplies the hard-coded administrator account required by Part A.
 *
 * <p>A database is intentionally not used at this stage. The repository layer
 * keeps this storage detail separate from the controller and service layers.</p>
 */
@Repository
public class AdminUserRepository {

    private static final AdminUser ADMIN_USER = new AdminUser(
            "he",
            "123",
            "He Yichong",
            "s1580500"
    );

    /**
     * Finds an administrator by username.
     *
     * @param username username entered on the login form
     * @return the matching administrator, or an empty result
     */
    public Optional<AdminUser> findByUsername(String username) {
        if (ADMIN_USER.username().equals(username)) {
            return Optional.of(ADMIN_USER);
        }
        return Optional.empty();
    }
}

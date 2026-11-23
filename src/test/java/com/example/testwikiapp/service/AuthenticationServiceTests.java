/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.testwikiapp.repository.AdminUserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthenticationServiceTests {

    private AuthenticationService authenticationService;

    @BeforeEach
    void setUp() {
        authenticationService = new AuthenticationService(new AdminUserRepository());
    }

    @Test
    void acceptsTheAssignedAdministratorCredentials() {
        var result = authenticationService.authenticate("he", "123");

        assertTrue(result.isPresent());
        assertEquals("He Yichong", result.get().displayName());
    }

    @Test
    void rejectsAnIncorrectUsername() {
        assertTrue(authenticationService.authenticate("admin", "123").isEmpty());
    }

    @Test
    void rejectsAnIncorrectPassword() {
        assertTrue(authenticationService.authenticate("he", "wrong").isEmpty());
    }
}

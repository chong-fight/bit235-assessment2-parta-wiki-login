/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.service;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.testwikiapp.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AuthServiceTests {

    private AuthService authService;

    @BeforeEach
    void setUp() {
        authService = new AuthService(new UserRepository());
    }

    @Test
    void correctCredentialsAreAccepted() {
        assertTrue(authService.authenticate("he", "123"));
    }

    @Test
    void wrongUsernameIsRejected() {
        assertFalse(authService.authenticate("admin", "123"));
    }

    @Test
    void wrongPasswordIsRejected() {
        assertFalse(authService.authenticate("he", "wrong"));
    }
}

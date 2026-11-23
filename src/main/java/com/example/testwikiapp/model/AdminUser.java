/*
 * Name: He Yichong
 * Student ID: s1580500
 */
package com.example.testwikiapp.model;

/**
 * Represents the administrator account used by this assessment.
 */
public record AdminUser(
        String username,
        String password,
        String displayName,
        String studentId
) {
}

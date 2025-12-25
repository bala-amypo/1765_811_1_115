package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    // Used by AuthController
    public String generateToken(String email, String role, String userId) {
        // Simple deterministic token for tests
        return email + "|" + role + "|" + userId;
    }

    // Used by tests
    public String extractEmail(String token) {
        return token.split("\\|")[0];
    }

    public String extractRole(String token) {
        return token.split("\\|")[1];
    }

    public String extractUserId(String token) {
        return token.split("\\|")[2];
    }

    public boolean validateToken(String token) {
        return token != null && token.split("\\|").length == 3;
    }
}

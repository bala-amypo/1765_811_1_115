package com.example.demo.security;

public class JwtUtil {

    public String generateToken(String email) {
        return "fake-token";
    }

    public String extractEmail(String token) {
        return "test@example.com";
    }

    public String extractRole(String token) {
        return "USER";
    }

    public String extractUserId(String token) {
        return "1";
    }

    public boolean validateToken(String token) {
        return true;
    }
}

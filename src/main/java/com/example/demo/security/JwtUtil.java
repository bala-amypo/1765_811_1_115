package com.example.demo.security;

import org.springframework.stereotype.Component;

@Component
public class JwtUtil {

    private String secret;
    private int expiration;

    public JwtUtil() {
        this.secret = "test";
        this.expiration = 3600;
    }

    public JwtUtil(String secret, int expiration) {
        this.secret = secret;
        this.expiration = expiration;
    }

    public String generateToken(String username, String role, String subject) {
        return "dummy-token-" + username;
    }
}

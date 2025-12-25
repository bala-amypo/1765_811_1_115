package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private String role;

    public AuthResponse() {
    }

    public AuthResponse(String token) {
        this.token = token;
    }

    // REQUIRED by AuthController
    public AuthResponse(String token, String role) {
        this.token = token;
        this.role = role;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    // Used by tests expecting ResponseEntity.getBody()
    public AuthResponse getBody() {
        return this;
    }
}

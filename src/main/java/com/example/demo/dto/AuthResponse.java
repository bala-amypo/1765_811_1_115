package com.example.demo.dto;

public class AuthResponse {

    private String token;
    private Long userId;
    private String email;
    private String role;

    // ✅ REQUIRED: No-arg constructor
    public AuthResponse() {
    }

    // ✅ Constructor used in controller
    public AuthResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role;
    }

    // ✅ Tests expect getBody()
    public String getBody() {
        return this.token;
    }

    // ✅ Tests may also set body
    public void setBody(String token) {
        this.token = token;
    }

    // ✅ Standard getters & setters (VERY IMPORTANT)

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}

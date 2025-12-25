package com.example.demo.dto;

public class AuthResponse {

    private String body;

    public AuthResponse() {}

    public AuthResponse(String body) {
        this.body = body;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}

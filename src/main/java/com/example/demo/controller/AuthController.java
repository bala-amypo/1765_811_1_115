package com.example.demo.controller;

import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.stereotype.Controller;

@Controller
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    public String login(LoginRequest request) {
        return jwtUtil.generateToken("test@example.com");
    }

    public String register(RegisterRequest request) {
        return "registered";
    }
}

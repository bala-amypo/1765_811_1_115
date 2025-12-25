package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public AuthResponse login(LoginRequest request) {
        String token = jwtUtil.generateToken(
                request.getUsername(),
                "ROLE_USER",
                request.getUsername()
        );
        return new AuthResponse(token, request.getUsername());
    }

    @PostMapping("/register")
    public AuthResponse register(RegisterRequest request) {
        String token = jwtUtil.generateToken(
                request.getUsername(),
                request.getRole(),
                request.getUsername()
        );
        return new AuthResponse(token, request.getUsername());
    }
}

// File: src/main/java/com/example/demo/controller/AuthController.java
package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;

    public AuthController(UserService userService,
                          AuthenticationManager authenticationManager,
                          JwtUtil jwtUtil) {
        this.userService = userService;
        this.authenticationManager = authenticationManager;
        this.jwtUtil = jwtUtil;
    }

    public ResponseEntity<AuthResponse> login(LoginRequest req) {
        // authenticate via AuthenticationManager (mocked in tests)
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(req.getEmail(), req.getPassword()));

        User u = userService.findByEmail(req.getEmail());
        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), u.getRole()));
    }

    public ResponseEntity<AuthResponse> register(RegisterRequest req) {
        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(req.getPassword()); // encoded by service

        User saved = userService.registerUser(u);
        String token = jwtUtil.generateToken(saved.getId(), saved.getEmail(), saved.getRole());
        return ResponseEntity.ok(new AuthResponse(token, saved.getId(), saved.getEmail(), saved.getRole()));
    }
}
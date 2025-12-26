package com.example.demo.controller;

import com.example.demo.dto.AuthResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.dto.RegisterRequest;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final AuthenticationManager authManager;
    private final JwtUtil jwtUtil;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UserService userService, AuthenticationManager authManager, JwtUtil jwtUtil, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.authManager = authManager;
        this.jwtUtil = jwtUtil;
        this.passwordEncoder = passwordEncoder;
    }

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest req) {
        User u = userService.findByEmail(req.getEmail())
                .orElseThrow(() -> new RuntimeException("User not found with email: " + req.getEmail()));

        // Optionally, you can add authenticationManager authentication here

        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), u.getRole()));
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest req) {
        User u = new User();
        u.setFullName(req.getFullName());
        u.setEmail(req.getEmail());
        u.setPassword(passwordEncoder.encode(req.getPassword()));
        // Optionally set default role if your User entity has it
        u.setRole("USER");

        u = userService.registerUser(u);

        String token = jwtUtil.generateToken(u.getId(), u.getEmail(), u.getRole());
        return ResponseEntity.ok(new AuthResponse(token, u.getId(), u.getEmail(), u.getRole()));
    }
}

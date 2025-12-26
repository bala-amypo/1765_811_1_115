package com.example.demo.controller;

import com.example.demo.dto.*;
import com.example.demo.entity.User;
import com.example.demo.security.JwtUtil;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/auth")
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

    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody LoginRequest request) {

        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        request.getEmail(), request.getPassword())
        );

        // findByEmail returns Optional<User>
        User user = userService.findByEmail(request.getEmail())
                               .orElseThrow(() -> new RuntimeException("User not found with email: " + request.getEmail()));

        String token = jwtUtil.generateToken(
                user.getId(), user.getEmail(), user.getRole());

        return ResponseEntity.ok(
                new AuthResponse(token, user.getId(), user.getEmail(), user.getRole())
        );
    }

    @PostMapping("/register")
    public ResponseEntity<AuthResponse> register(@RequestBody RegisterRequest request) {

        // Check if user already exists
        Optional<User> existingUser = userService.findByEmail(request.getEmail());
        if (existingUser.isPresent()) {
            throw new RuntimeException("User already exists with email: " + request.getEmail());
        }

        // Create new user
        User user = new User();
        user.setFullName(request.getFullName());
        user.setEmail(request.getEmail());
        user.setPassword(request.getPassword());
        user.setRole("USER"); // default role

        User saved = userService.registerUser(user);

        String token = jwtUtil.generateToken(
                saved.getId(), saved.getEmail(), saved.getRole());

        return ResponseEntity.ok(
                new AuthResponse(token, saved.getId(), saved.getEmail(), saved.getRole())
        );
    }
}

// package com.example.demo.controller;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserEntity;
// import com.example.demo.service.UserService;
// import io.swagger.v3.oas.annotations.tags.Tag;
// import org.springframework.web.bind.annotation.*;

// @RestController
// @RequestMapping("/auth")
// @Tag(name = "Authentication")
// public class AuthController {

//     private final UserService service;

//     public AuthController(UserService service) {
//         this.service = service;
//     }

//     @PostMapping("/register")
//     public UserEntity register(@RequestBody RegisterRequest request) {
//         return service.registerUser(request);
//     }
// }

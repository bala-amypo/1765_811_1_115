// package com.example.demo.service.impl;

// import com.example.demo.dto.RegisterRequest;
// import com.example.demo.entity.UserEntity;
// import com.example.demo.repository.UserRepository;
// import com.example.demo.service.UserService;
// import org.springframework.security.crypto.password.PasswordEncoder;
// import org.springframework.stereotype.Service;

// @Service
// public class UserServiceImpl implements UserService {

//     private final UserRepository repository;
//     private final PasswordEncoder passwordEncoder;

//     public UserServiceImpl(UserRepository repository, PasswordEncoder passwordEncoder) {
//         this.repository = repository;
//         this.passwordEncoder = passwordEncoder;
//     }

//     public UserEntity registerUser(RegisterRequest request) {
//         UserEntity user = new UserEntity();
//         user.setEmail(request.getEmail());
//         user.setPassword(passwordEncoder.encode(request.getPassword()));
//         return repository.save(user);
//     }

//     public UserEntity findByEmail(String email) {
//         return repository.findByEmail(email).orElse(null);
//     }
// }

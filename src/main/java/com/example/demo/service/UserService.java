package com.example.demo.service;

import com.example.demo.entity.User;
import java.util.Optional;

public interface UserService {
    User registerUser(User user);
    Optional<User> findByEmail(String email);
    boolean existsByEmail(String email);
    Optional<User> getUserById(Long id);
}

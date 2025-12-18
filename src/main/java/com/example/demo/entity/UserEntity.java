package com.example.demo.entity;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    @Column(unique = true)
    private String email;

    private String password;
    private String role;
    private LocalDateTime createdAt;

    public UserEntity() {}

    public UserEntity(String fullName, String email,
                      String password, String role) {
        this.fullName = fullName;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    @PrePersist
    public void onCreate() {
        createdAt = LocalDateTime.now();
        if (role == null) role = "MONITOR";
    }

    // Getters & Setters
    public Long getId() { return id; }
    public String getEmail() { return email; }
    public void setPassword(String password) { this.password = password; }
}

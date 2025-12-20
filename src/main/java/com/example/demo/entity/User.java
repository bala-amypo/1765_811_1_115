// package com.example.demo.entity;

// import jakarta.persistence.*;
// import java.time.LocalDateTime;

// @Entity
// @Table(name = "users", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
// public class UserEntity {

//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private Long id;

//     private String fullName;
//     private String email;
//     private String password;
//     private String role;
//     private LocalDateTime createdAt;

//     public UserEntity() {}

//     @PrePersist
//     public void prePersist() {
//         this.createdAt = LocalDateTime.now();
//         this.role = "MONITOR";
//     }

//     // Getters & Setters
//     public Long getId() { return id; }
//     public String getEmail() { return email; }
//     public void setEmail(String email) { this.email = email; }

//     public String getPassword() { return password; }
//     public void setPassword(String password) { this.password = password; }
// }

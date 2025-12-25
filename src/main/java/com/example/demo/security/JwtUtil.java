// package com.example.demo.security;

// import java.util.Date;
// import io.jsonwebtoken.Claims;
// import io.jsonwebtoken.Jwts;
// import io.jsonwebtoken.SignatureAlgorithm;
// import org.springframework.stereotype.Component;

// @Component
// public class JwtUtil {

//     private final String SECRET_KEY = "your_secret_key_here";

//     // Generate token
//     public String generateToken(String email) {
//         return Jwts.builder()
//                 .setSubject(email)
//                 .setIssuedAt(new Date())
//                 .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10)) // 10 hours
//                 .signWith(SignatureAlgorithm.HS256, SECRET_KEY)
//                 .compact();
//     }

//     // Extract email (subject)
//     public String extractEmail(String token) {
//         return extractAllClaims(token).getSubject();
//     }

//     // Extract role (assuming role stored as claim "role")
//     public String extractRole(String token) {
//         return extractAllClaims(token).get("role", String.class);
//     }

//     // Extract user id (assuming userId stored as claim "userId")
//     public String extractUserId(String token) {
//         return extractAllClaims(token).get("userId", String.class);
//     }

//     // Validate token (checks expiration)
//     public boolean validateToken(String token) {
//         return !isTokenExpired(token);
//     }

//     // Check if token is expired
//     private boolean isTokenExpired(String token) {
//         return extractAllClaims(token).getExpiration().before(new Date());
//     }

//     // Extract all claims
//     private Claims extractAllClaims(String token) {
//         return Jwts.parser()
//                 .setSigningKey(SECRET_KEY)
//                 .parseClaimsJws(token)
//                 .getBody();
//     }
// }

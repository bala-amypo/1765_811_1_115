// File: src/main/java/com/example/demo/security/JwtUtil.java
package com.example.demo.security;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.time.Instant;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

public class JwtUtil {

    private final String secret;
    private final long validityInMs;

    // Constructor signature required by the tests
    public JwtUtil(String secret, long validityInMs) {
        this.secret = secret;
        this.validityInMs = validityInMs;
    }

    // Public API required by tests
    public String generateToken(Long userId, String email, String role) {
        long exp = Instant.now().toEpochMilli() + validityInMs;
        String header = base64Url("{\"alg\":\"HS256\",\"typ\":\"JWT\"}");
        String payloadJson = String.format("{\"userId\":%d,\"email\":\"%s\",\"role\":\"%s\",\"exp\":%d}",
                userId, email, role, exp);
        String payload = base64Url(payloadJson);
        String signature = sign(header + "." + payload);
        return header + "." + payload + "." + signature;
    }

    public boolean validateToken(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) return false;
            String unsigned = parts[0] + "." + parts[1];
            String expectedSig = sign(unsigned);
            if (!constantTimeEquals(expectedSig, parts[2])) return false;

            Map<String, String> claims = parseClaims(parts[1]);
            long exp = Long.parseLong(claims.getOrDefault("exp", "0"));
            return exp > Instant.now().toEpochMilli();
        } catch (Exception e) {
            return false;
        }
    }

    public String extractEmail(String token) {
        Map<String, String> claims = safeClaims(token);
        return claims.getOrDefault("email", null);
    }

    public Long extractUserId(String token) {
        Map<String, String> claims = safeClaims(token);
        try {
            return Long.parseLong(claims.getOrDefault("userId", "0"));
        } catch (Exception e) { return null; }
    }

    public String extractRole(String token) {
        Map<String, String> claims = safeClaims(token);
        return claims.getOrDefault("role", null);
    }

    // Helpers
    private String base64Url(String s) {
        return Base64.getUrlEncoder().withoutPadding()
                .encodeToString(s.getBytes(StandardCharsets.UTF_8));
    }

    private String sign(String data) {
        try {
            Mac mac = Mac.getInstance("HmacSHA256");
            mac.init(new SecretKeySpec(secret.getBytes(StandardCharsets.UTF_8), "HmacSHA256"));
            byte[] sig = mac.doFinal(data.getBytes(StandardCharsets.UTF_8));
            return Base64.getUrlEncoder().withoutPadding().encodeToString(sig);
        } catch (Exception e) {
            throw new RuntimeException("JWT signing failed", e);
        }
    }

    private boolean constantTimeEquals(String a, String b) {
        if (a == null || b == null) return false;
        if (a.length() != b.length()) return false;
        int result = 0;
        for (int i = 0; i < a.length(); i++) {
            result |= a.charAt(i) ^ b.charAt(i);
        }
        return result == 0;
    }

    private Map<String, String> parseClaims(String payloadB64) {
        String json = new String(Base64.getUrlDecoder().decode(payloadB64), StandardCharsets.UTF_8).trim();
        Map<String, String> m = new HashMap<>();
        // Very small JSON parser for known fields: "key":"value" or key:number
        json = json.replaceAll("[{}\"]", "");
        String[] parts = json.split(",");
        for (String part : parts) {
            String[] kv = part.split(":", 2);
            if (kv.length == 2) {
                m.put(kv[0].trim(), kv[1].trim());
            }
        }
        return m;
    }

    private Map<String, String> safeClaims(String token) {
        try {
            String[] parts = token.split("\\.");
            if (parts.length != 3) return new HashMap<>();
            return parseClaims(parts[1]);
        } catch (Exception e) {
            return new HashMap<>();
        }
    }
}
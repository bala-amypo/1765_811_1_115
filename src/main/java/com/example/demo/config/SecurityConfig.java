package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import java.util.List;

@Configuration
public class SecurityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("12345678901234567890123456789012", 3600000L); // 1 hour validity
    }

    // ----- FINAL CHANGE: enable CORS, permit preflight, disable form/basic login -----
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // ✅ Permit CORS preflight requests
                .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                // ✅ Public endpoints
                .requestMatchers("/auth/**", "/swagger-ui/**", "/v3/api-docs/**", "/simple-status").permitAll()
                // 🔒 Protect API (use JWT); change to .permitAll() if you want it open temporarily
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )
            .formLogin(form -> form.disable())     // ⛔ Disable default login page
            .httpBasic(basic -> basic.disable());  // ⛔ Disable browser basic-auth popup

        return http.build();
    }

    // ✅ Global CORS config: allow your deployment domain + local dev, methods & headers
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // Use explicit origins to avoid wildcard+credentials issues
        config.setAllowedOriginPatterns(List.of(
            "https://9336.pro604cr.amypo.ai",
            "http://localhost:*",
            "http://127.0.0.1:*"
        ));
        config.setAllowCredentials(true);
        config.setAllowedMethods(List.of("GET","POST","PUT","PATCH","DELETE","OPTIONS"));
        config.setAllowedHeaders(List.of("Authorization","Content-Type","Accept","Origin","Cache-Control","X-Requested-With"));
        config.setExposedHeaders(List.of("Authorization","Content-Type"));
        config.setMaxAge(3600L);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
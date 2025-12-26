package com.example.demo.config;

import com.example.demo.security.JwtUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

    // Keep these beans (you already added them)
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtUtil jwtUtil() {
        return new JwtUtil("12345678901234567890123456789012", 3600000L); // 1h validity
    }

    // ✅ FINAL CHANGE: disable the login page and allow your endpoints
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Public endpoints (no login page)
                .requestMatchers(
                    "/auth/**",            // your JWT login/register
                    "/swagger-ui/**",      // Swagger UI
                    "/v3/api-docs/**",     // OpenAPI docs
                    "/simple-status"       // required servlet
                ).permitAll()
                // Secure your API if you want JWT only (no form)
                .requestMatchers("/api/**").authenticated()
                // Everything else can be open (adjust as needed)
                .anyRequest().permitAll()
            )
            // ⛔ Turn off default Spring Security form login page
            .formLogin(form -> form.disable())
            // Also disable basic auth prompts
            .httpBasic(basic -> basic.disable());

        return http.build();
    }
}
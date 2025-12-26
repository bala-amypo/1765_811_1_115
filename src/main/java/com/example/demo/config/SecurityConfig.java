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

import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

@Configuration
public class SecurityConfig {

    // ---- Existing beans (keep these) ----
    @Bean
    public PasswordEncoder passwordEncoder() { return new BCryptPasswordEncoder(); }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    public JwtUtil jwtUtil() {
        // Same secret/validity used in tests
        return new JwtUtil("12345678901234567890123456789012", 3600000L); // 1 hour
    }

    // ---- ✅ FINAL CHANGE: Security filter chain with CORS enabled and form login disabled ----
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
            .csrf(csrf -> csrf.disable())
            // Enable CORS so Swagger UI can call your APIs from the browser
            .cors(cors -> cors.configurationSource(corsConfigurationSource()))
            .sessionManagement(sm -> sm.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> auth
                // Public endpoints
                .requestMatchers(
                    "/auth/**",          // JWT login/register
                    "/swagger-ui/**",    // Swagger UI
                    "/v3/api-docs/**",   // OpenAPI docs
                    "/simple-status"     // status servlet
                ).permitAll()
                // Protect API if you intend to use JWT; change to .permitAll() if needed
                .requestMatchers("/api/**").authenticated()
                .anyRequest().permitAll()
            )
            // Turn off default login and basic-auth UI/prompts
            .formLogin(form -> form.disable())
            .httpBasic(basic -> basic.disable());

        return http.build();
    }

    // ---- ✅ Global CORS configuration ----
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();
        // Allow all origins. If you want to restrict, replace with your domain:
        // config.setAllowedOrigins(List.of("https://9336.pro604cr.amypo.ai"));
        config.addAllowedOriginPattern("*");
        config.addAllowedMethod("*");   // GET, POST, PUT, DELETE, etc.
        config.addAllowedHeader("*");   // Authorization, Content-Type, etc.
        config.setAllowCredentials(true);

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", config);
        return source;
    }
}
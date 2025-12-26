package com.example.demo.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.servers.Server;
import io.swagger.v3.oas.models.security.SecurityScheme;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI customOpenAPI() {

        // 🔹 Change this URL whenever you deploy
        Server server = new Server();
        server.setUrl("http://localhost:8080");
        server.setDescription("Local Development Server");

        return new OpenAPI()
                .info(new Info()
                        .title("Cold Chain Temperature Monitoring API")
                        .version("1.0.0")
                        .description("API documentation for Cold Chain Monitoring System")
                )
                .servers(List.of(server))

                // 🔐 JWT Security Scheme
                .components(new Components()
                        .addSecuritySchemes("BearerAuth",
                                new SecurityScheme()
                                        .type(SecurityScheme.Type.HTTP)
                                        .scheme("bearer")
                                        .bearerFormat("JWT")
                        )
                )

                // 🔐 Apply JWT Security Globally
                .addSecurityItem(
                        new SecurityRequirement().addList("BearerAuth")
                );
    }
}

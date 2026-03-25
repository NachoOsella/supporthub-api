package com.supporthub.api.config;

import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    OpenAPI supportHubOpenApi() {
        return new OpenAPI().info(new Info()
                .title("SupportHub API")
                .description("API de soporte y tickets")
                .version("1.0"));
    }
}

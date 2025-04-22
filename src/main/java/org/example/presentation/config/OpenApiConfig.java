package org.example.presentation.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenApiConfig {

    @Bean
    public OpenAPI zooOpenAPI() {
        return new OpenAPI()
                .info(new Info()
                        .title("Zoo Management API")
                        .description("API for managing zoo operations")
                        .version("1.0"));
    }
}

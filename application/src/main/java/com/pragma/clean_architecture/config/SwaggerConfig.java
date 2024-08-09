package com.pragma.clean_architecture.config;

import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Contact;
import io.swagger.v3.oas.models.info.Info;
import org.springdoc.core.customizers.OpenApiCustomizer;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwaggerConfig {

    @Bean
    public GroupedOpenApi userApi() {
        final String[] packagesToScan = {"com.pragma.clean_architecture.entry_points.rest.controller"};
        return GroupedOpenApi
                .builder()
                .group("Test Pragma Clean Architecture Api")
                .packagesToScan(packagesToScan)
                .pathsToMatch("/**")
                .addOpenApiCustomizer(statusApiCostumizer())
                .build();
    }

    private OpenApiCustomizer statusApiCostumizer() {
        return openAPI -> openAPI
                .info(new Info()
                        .title("Springboot & OpenAPI")
                        .description("This is a sample SpringBoot Clean Archiecture Archetype")
                        .version("3.0.0")
                        .contact(new Contact()
                                .name("Pragma SA")
                                .url("https://github.com/somospragma")
                                .email("cristian.munoza@pragma.com.co")));
    }

    @Bean
    public OpenAPI customOpenAPI() {
        return new OpenAPI()
                .components(new Components())
                .info(new Info().title("Contact Application API").description(
                        "This is a sample SpringBoot Clean Archiecture Archetype"));
    }

}
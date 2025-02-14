package com.project.shoppingcart.inventory.service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI inventoryServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("inventory Service API")
                        .description("This is reset API for inventory service")
                        .version("v0.0.1")).externalDocs(new ExternalDocumentation().description("You can refer to the inventory service wiki").url("https://inventory-dummy"));
    }
}

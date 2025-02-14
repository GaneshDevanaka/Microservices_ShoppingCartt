package com.project_Spring_Boot.product_service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI productServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Product Service API")
                        .description("This is reset API for Product service")
                        .version("v0.0.1")).externalDocs(new ExternalDocumentation().description("You can refer to the product service wiki").url("https://product-dummy"));
    }

}

package com.project.shoppingcart.order.service.config;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OpenAPIConfig {
    @Bean
    public OpenAPI orderServiceAPI(){
        return new OpenAPI()
                .info(new Info().title("Order Service API")
                        .description("This is rest API for Order service")
                        .version("v0.0.1")).externalDocs(new ExternalDocumentation().description("You can refer to the Order service wiki").url("https://order-dummy"));
    }
}

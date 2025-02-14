package com.project.shoppingcart.order.service.config;

import com.project.shoppingcart.order.service.client.InventoryClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestClient;
import org.springframework.web.client.support.RestClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class RestClientConfig {

    @Value("${inventory.url}")
    private String inventoryServiceUrl;

    @Bean
    public InventoryClient inventoryClient() {
        // Create the RestClient with base URL
        RestClient restClient = RestClient.builder()
                .baseUrl(inventoryServiceUrl)
                .build();

        // Create the RestClient adapter and HttpServiceProxyFactory
        var restClientAdapter = RestClientAdapter.create(restClient);
        var httpServiceProxyFactory = HttpServiceProxyFactory.builderFor(restClientAdapter).build();

        // Return the proxy client
        return httpServiceProxyFactory.createClient(InventoryClient.class);
    }
}

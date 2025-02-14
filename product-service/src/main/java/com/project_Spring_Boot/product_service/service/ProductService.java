package com.project_Spring_Boot.product_service.service;

import com.project_Spring_Boot.product_service.dto.ProductRequest;
import com.project_Spring_Boot.product_service.dto.ProductResponse;
import com.project_Spring_Boot.product_service.model.Product;
import com.project_Spring_Boot.product_service.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
@Slf4j
@Service

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public ProductResponse createProduct(ProductRequest productRequest){
        Product product=Product.builder()
                .name(productRequest.name())
                .description(productRequest.description())
                .price(productRequest.price()).build();
        productRepository.save(product);
        log.info("Product Successfully Created");
        return new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice());
    }


    public List<ProductResponse> getAllProducts() {
         return  productRepository.findAll().stream().
                 map(product -> new ProductResponse(product.getId(), product.getName(), product.getDescription(), product.getPrice())).toList();
    }
}

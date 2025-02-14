package com.project_Spring_Boot.product_service.dto;

import java.math.BigDecimal;

public record ProductRequest( String name, String description, BigDecimal price) {
}

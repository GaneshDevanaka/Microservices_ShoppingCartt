package com.project.shoppingcart.inventory.service.service;

import com.project.shoppingcart.inventory.service.dto.InventoryResponse;
import com.project.shoppingcart.inventory.service.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository inventoryRepository;

    public InventoryService(InventoryRepository inventoryRepository) {
        this.inventoryRepository = inventoryRepository;
    }

    public List<InventoryResponse> findInStock(String skuCode, Integer quantity){
        return inventoryRepository.findBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity)
                .stream()
                .map(inventory -> new InventoryResponse(inventory.getId(), inventory.getSkuCode(), inventory.getQuantity()))
                .toList();

    }

    public boolean isInStock(String skuCode, Integer quantity) {
        return inventoryRepository.existsBySkuCodeAndQuantityIsGreaterThanEqual(skuCode,quantity);

    }


}

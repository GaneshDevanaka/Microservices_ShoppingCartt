package com.project.shoppingcart.inventory.service.repository;

import com.project.shoppingcart.inventory.service.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    List<Inventory> findBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);

    boolean existsBySkuCodeAndQuantityIsGreaterThanEqual(String skuCode, Integer quantity);
}

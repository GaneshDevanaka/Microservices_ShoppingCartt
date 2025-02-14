package com.project.shoppingcart.inventory.service.controller;

import com.project.shoppingcart.inventory.service.dto.InventoryResponse;
import com.project.shoppingcart.inventory.service.service.InventoryService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/api/inventory")
@RestController
public class InventoryController {
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }
    @GetMapping("skuCode/quantity")
    @ResponseStatus(HttpStatus.OK)
    public List<InventoryResponse> findInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.findInStock(skuCode,quantity);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public boolean isInStock(@RequestParam String skuCode, @RequestParam Integer quantity){
        return inventoryService.isInStock(skuCode,quantity);
    }


}

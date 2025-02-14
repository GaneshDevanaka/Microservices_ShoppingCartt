package com.project.shoppingcart.order.service.controller;
import com.project.shoppingcart.order.service.dto.OrderRequest;
import com.project.shoppingcart.order.service.dto.OrderResponse;
import com.project.shoppingcart.order.service.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/order")
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public OrderResponse createOrder(@RequestBody OrderRequest orderRequest){
        return orderService.createOrder(orderRequest);
    }
    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<OrderResponse> findAllOrder(){
        return orderService.findAllOrder();
    }
}


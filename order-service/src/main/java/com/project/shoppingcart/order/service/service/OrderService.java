package com.project.shoppingcart.order.service.service;

import com.project.shoppingcart.order.service.client.InventoryClient;
import com.project.shoppingcart.order.service.dto.OrderRequest;
import com.project.shoppingcart.order.service.dto.OrderResponse;
import com.project.shoppingcart.order.service.event.OrderPlacedEvent;
import com.project.shoppingcart.order.service.model.Order;
import com.project.shoppingcart.order.service.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final InventoryClient inventoryClient;
    private final KafkaTemplate<String,OrderPlacedEvent> kafkaTemplate;
    private static final Logger log = LoggerFactory.getLogger(OrderService.class);
    private  String gettingemail="gd@gmail.com";


    public OrderService(OrderRepository orderRepository, InventoryClient inventoryClient,  KafkaTemplate<String, OrderPlacedEvent> kafkaTemplate) {
        this.orderRepository = orderRepository;
        this.inventoryClient = inventoryClient;

        this.kafkaTemplate = kafkaTemplate;
    }

    public OrderResponse createOrder( OrderRequest orderRequest){
        boolean isProductInStock=inventoryClient.isInStock(orderRequest.skuCode(),orderRequest.quantity());
        if(isProductInStock) {
            Order order = new Order();
            order.setOrderNumber(UUID.randomUUID().toString());
            order.setPrice(orderRequest.price());
            order.setSkuCode(orderRequest.skuCode());
            order.setQuantity(orderRequest.quantity());
            orderRepository.save(order);
            OrderPlacedEvent orderPlacedEvent=new OrderPlacedEvent(order.getOrderNumber(),gettingemail);
             log.info("Start-Sending ");
            kafkaTemplate.send("order-placed",orderPlacedEvent);
            return new OrderResponse(order.getId(), order.getOrderNumber(), order.getSkuCode(), order.getPrice(), order.getQuantity());

        }else{
            throw new RuntimeException("Product with skuCode "+orderRequest.skuCode() +"is not in stock");
        }

    }

    public List<OrderResponse> findAllOrder() {
        return orderRepository.findAll().stream().
                map(order -> new OrderResponse(order.getId(),
                        order.getOrderNumber(),order.getSkuCode(),
                        order.getPrice(),order.getQuantity())).toList();
    }
}

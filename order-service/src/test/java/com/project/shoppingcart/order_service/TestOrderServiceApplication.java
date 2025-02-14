package com.project.shoppingcart.order_service;

import com.project.shoppingcart.order.service.OrderServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestOrderServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(OrderServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

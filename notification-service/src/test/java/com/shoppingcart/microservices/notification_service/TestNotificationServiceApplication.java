package com.shoppingcart.microservices.notification_service;

import com.shoppingcart.microservices.service.NotificationServiceApplication;
import org.springframework.boot.SpringApplication;

public class TestNotificationServiceApplication {

	public static void main(String[] args) {
		SpringApplication.from(NotificationServiceApplication::main).with(TestcontainersConfiguration.class).run(args);
	}

}

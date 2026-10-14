package com.example.playlist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

// Load Spring IoC container
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

// Get FoodOrder bean
        FoodOrder order = context.getBean("foodOrder", FoodOrder.class);
        
// Print order and injected delivery address
        System.out.println("===== Food Order Details =====");
        System.out.println("Order ID: " + order.getOrderId());
        System.out.println("Delivery Address: " + order.getDeliveryDetails().getAddress());

        context.close();
    }
}

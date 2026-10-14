package com.example.pay;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("beans.xml");

        OrderService service =
                context.getBean("orderService", OrderService.class);

        service.placeOrder();

        context.close();
    }
}
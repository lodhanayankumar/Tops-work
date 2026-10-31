package com.example.foodmenu;

import java.math.BigDecimal;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.example.foodmenu.model.Order;
import com.example.foodmenu.repository.OrderRepository;

@SpringBootApplication
public class FoodMenuApiApplication {

    public static void main(String[] args) {

        SpringApplication.run(FoodMenuApiApplication.class, args);
    }

    @Bean
    CommandLineRunner run(OrderRepository orderRepository) {

        return args -> {

            Order order1 = new Order(
                    "Nayan", "Paneer Tikka", 2,
                    new BigDecimal("440.00"));

            Order order2 = new Order(
                    "Rahul","Veg Biryani",3,
                    new BigDecimal("540.00"));

            orderRepository.save(order1);
            orderRepository.save(order2);

            System.out.println("--ALL ORDERS--");

            orderRepository.findAll().forEach(System.out::println);

            System.out.println("--ORDERS BY CUSTOMER NAME--");

            orderRepository.findByCustomerName("Nayan").forEach(System.out::println);
        };
    }
}
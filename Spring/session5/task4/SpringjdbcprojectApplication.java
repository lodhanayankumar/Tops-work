package com.example.springjdbcproject;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjdbcprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringjdbcprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner testRestaurantDao(RestaurantDao dao) {
        return args -> {
        
        
        	System.out.println("\n===== Restaurants with Rating Above 4.0 =====");

        List<Restaurant> restaurants = dao.getRestaurantsAboveFour();

        for (Restaurant r : restaurants) {
            System.out.println( "Name: " + r.getName()
                    + ", Cuisine: " + r.getCuisine()); }
        };   
        }
}
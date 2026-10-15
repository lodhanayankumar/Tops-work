
package com.example.springjdbcproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjdbcprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(
            SpringjdbcprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner run(RestaurantDao dao) {
        return args -> {

            System.out.println("\nALL Resturants");

            for (Restaurant r : dao.getAllRestaurants()) {
                System.out.println(r);
            }

            System.out.println("\nResturants above 4 rating");

            for (Restaurant r : dao.getRestaurantsAboveFour()) {
                System.out.println(r);
            }

            System.out.println("\nRestaurants id 1");
            System.out.println(dao.getRestaurantById(1));
        };
    }
}

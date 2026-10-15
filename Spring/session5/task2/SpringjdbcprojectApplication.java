package com.example.springjdbcproject;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringjdbcprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringjdbcprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner showRestaurants(JdbcTemplate jdbcTemplate) {
        return args -> {

            String sql = "SELECT id, name, cuisine, rating FROM restaurants";

            List<Restaurant> restaurants = jdbcTemplate.query(
                    sql,
                    (rs, rowNum) -> new Restaurant(rs.getInt("id"), rs.getString("name"),rs.getString("cuisine"),
                            rs.getDouble("rating")));

            for (Restaurant restaurant : restaurants) {
                System.out.println(
                        restaurant.getId() + " | " + restaurant.getName() + " | " +
                        restaurant.getCuisine() + " | " + restaurant.getRating());
            }
        };
    }
}

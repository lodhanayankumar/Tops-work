package com.example.springjdbcproject;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringjdbcprojectApplication {

    public static void main(String[] args) {
        SpringApplication.run(
                SpringjdbcprojectApplication.class, args);
    }

    @Bean
    CommandLineRunner testDatabaseConnection(JdbcTemplate jdbcTemplate) {
        return args -> {
            Integer result = jdbcTemplate.queryForObject(
                    "SELECT 1", Integer.class);

            System.out.println("MySQL connection successful!");
            System.out.println("Test query result: " + result);
        };
    }
}
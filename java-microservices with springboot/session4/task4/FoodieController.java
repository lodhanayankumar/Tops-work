package com.example.foodieservice.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodieController {

    @Value("${server.port}")
    private String port;

    @GetMapping("/foodie")
    public String getFoodie() {

        System.out.println(
            "Request handled by FoodieService on port: " + port
        );

        return "Welcome to FoodieService! Instance running on port: "
                + port;
    }
}
package com.example.foodieservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FoodieController {

    @GetMapping("/")
    public String home() {
        return "FoodieService is Running!";
    }

    @GetMapping("/foodie")
    public String foodie() {
        return "Welcome to FoodieService! Find your favorite food here.";
    }
}
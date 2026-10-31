package com.example.smartfooddelivery.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.smartfooddelivery.model.MenuItem;

@RestController
@RequestMapping("/menu")
public class MenuController {

    @GetMapping
    public List<MenuItem> getAllMenuItems() {

        return Arrays.asList(
            new MenuItem(1, "Paneer Tikka", 220.0),
            new MenuItem(2, "Veg Biryani", 180.0),
            new MenuItem(3, "Masala Dosa", 120.0));
    }
}

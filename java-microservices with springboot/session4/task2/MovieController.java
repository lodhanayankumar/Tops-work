package com.example.movieservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovieController {

    @GetMapping("/")
    public String home() {
        return "MovieService is Running!";
    }

    @GetMapping("/movies")
    public String movies() {
        return "Welcome to MovieService! Discover your favorite movies here.";
    }
}
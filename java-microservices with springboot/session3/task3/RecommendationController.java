package com.example.recommendationservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.recommendationservice.model.Recommendation;

@RestController
public class RecommendationController {

    @GetMapping("/")
    public String home() {
        return "service is running!";
    }

    @GetMapping("/recommendations")
    public List<Recommendation> getRecommendations() {

        return Arrays.asList(
            new Recommendation(1,"Nayan","popular songs", Arrays.asList("perfect","believer",
            		"blinding lights")),
            new Recommendation(2,"Nayan","relaxing music", Arrays.asList("photograph",
            		"night changes","memories")));
    }

    @GetMapping("/recommendations/{username}")
    public List<Recommendation> getRecommendationsByUser( @PathVariable String username) {

        return Arrays.asList(
            new Recommendation(1,username,"recommended for you",
                Arrays.asList("perfect","believer","blinding lights")));
    }
}
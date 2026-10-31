package com.example.aimeal.controller;

import java.util.Map;

import jakarta.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.aimeal.dto.RecommendationRequest;
import com.example.aimeal.service.AIRecommendationService;

@RestController
@RequestMapping("/recommend")
public class RecommendationController {

    private final AIRecommendationService aiService;

    public RecommendationController(AIRecommendationService aiService) {
        this.aiService = aiService;
    }
    @PostMapping
    public ResponseEntity<Map<String, String>> recommendMeal(
            @Valid @RequestBody RecommendationRequest request) {

        try {
            String recommendation = aiService.getRecommendation(request.getPreference());

            return ResponseEntity.ok( Map.of("recommendation", recommendation));

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body(Map.of("error","Meal recommendation service failed: " + e.getMessage()));
        }
    }
}

package com.example.smartfooddelivery.controller;

import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

import com.example.smartfooddelivery.dto.RecommendationRequest;
import com.example.smartfooddelivery.service.AIRecommendationService;

@RestController
public class RecommendationController {

    private final AIRecommendationService aiService;

    public RecommendationController(AIRecommendationService aiService) {
        this.aiService = aiService;
    }

    @PostMapping("/recommend")
    public ResponseEntity<?> recommendMeal( @Valid @RequestBody RecommendationRequest request) {

        try {

            String recommendation =aiService.getRecommendation(request.getPreference());

            return ResponseEntity.ok(Map.of("recommendation", recommendation));

        } catch (Exception e) {

            return ResponseEntity
                    .status(HttpStatus.BAD_GATEWAY)
                    .body(Map.of("error", "Unable to get meal recommendation: "+ e.getMessage()));
        }
    }
}

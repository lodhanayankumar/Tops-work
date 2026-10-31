package com.example.aimeal.dto;

import jakarta.validation.constraints.NotBlank;

public class RecommendationRequest {

    @NotBlank(message = "Preference cannot be empty")
    private String preference;

    public RecommendationRequest() {
    }

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}
package com.example.smartfooddelivery.dto;

import jakarta.validation.constraints.NotBlank;

public class RecommendationRequest {

    @NotBlank(message = "Dietary preference is required")
    private String preference;

    public String getPreference() {
        return preference;
    }

    public void setPreference(String preference) {
        this.preference = preference;
    }
}

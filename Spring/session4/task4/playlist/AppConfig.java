package com.example.playlist;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.playlist")
public class AppConfig {

    @Bean
    public RecommendationService recommendationService() {
        return new RecommendationService();
    }
}

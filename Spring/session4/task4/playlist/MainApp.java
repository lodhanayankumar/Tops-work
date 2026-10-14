package com.example.playlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

// Start without XML
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

// Get PS bean
        PlaylistService playlistService = context.getBean(PlaylistService.class);

// Test autowired 
        playlistService.showPlaylist();

// Get RSbean
        RecommendationService recommendationService =context.getBean(RecommendationService.class);
// Test @Bean 
        recommendationService.showRecommendations();
        context.close();
    }
}

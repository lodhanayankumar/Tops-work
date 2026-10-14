package com.example.playlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        // Start Spring without XML
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        // Get PlaylistService bean
        PlaylistService playlistService =
                context.getBean(PlaylistService.class);

        // Test autowired dependency
        playlistService.showPlaylist();

        // Get RecommendationService bean
        RecommendationService recommendationService =
                context.getBean(RecommendationService.class);

        // Test @Bean configuration
        recommendationService.showRecommendations();

        // Close Spring container
        context.close();
    }
}

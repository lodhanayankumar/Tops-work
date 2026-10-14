package com.example.playlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

//AppConfig
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

// Retrieve from bean
        RecommendationService service = context.getBean("recommendationService", RecommendationService.class);

// Call method
        service.showRecommendations();

        context.close();
    }
}

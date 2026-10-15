package com.example.playlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        Playlist playlist = context.getBean(Playlist.class);

        playlist.showDetails();

        context.close();
    }
}

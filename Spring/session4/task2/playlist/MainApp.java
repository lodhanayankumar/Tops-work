package com.example.playlist;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.example.playlist")
public class MainApp {

    public static void main(String[] args) {

        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(MainApp.class);

        PlaylistService playlistService =
                context.getBean(PlaylistService.class);

        playlistService.showPlaylist();

        context.close();
    }
}

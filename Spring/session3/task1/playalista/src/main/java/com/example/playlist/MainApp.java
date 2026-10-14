package com.example.playlist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        Playlist playlist = context.getBean("playlist", Playlist.class);

        Song song = context.getBean("song", Song.class);

        System.out.println("===== Playlist Details =====");
        System.out.println("Playlist Name: " + playlist.getName());

        System.out.println("\n===== Song Details =====");
        System.out.println("Song Title: " + song.getTitle());
        System.out.println("Artist: " + song.getArtist());

        context.close();
    }
}
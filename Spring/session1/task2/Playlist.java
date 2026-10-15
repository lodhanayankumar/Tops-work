package com.example.playlistmanager;

import org.springframework.stereotype.Component;

@Component
public class Playlist {

    public void showPlaylist() {
        System.out.println("My Favorite Songs");
        System.out.println("Bollywood Hits");
        System.out.println("English Pop");
    }
}

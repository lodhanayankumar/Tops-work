
package com.example.playlist;

import org.springframework.stereotype.Component;

@Component
public class Playlist {

    private String name = "My Favorite Songs";
    private String genre = "Bollywood";
    private int songCount = 25;

    public void showDetails() {
        System.out.println("Playlist Name: " + name);
        System.out.println("Genre: " + genre);
        System.out.println("Number of Songs: " + songCount);
    }
}

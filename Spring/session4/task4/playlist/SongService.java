package com.example.playlist;

import org.springframework.stereotype.Component;

@Component
public class SongService {

    public SongService() {
        System.out.println("SongService initialized");
    }

    public void playSong() {
        System.out.println("SongService is active.");
    }
}

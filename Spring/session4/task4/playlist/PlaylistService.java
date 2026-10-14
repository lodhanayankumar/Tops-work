package com.example.playlist;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlaylistService {

    private SongService songService;

    @Autowired
    public void setSongService(SongService songService) {
        this.songService = songService;
    }

    public void showPlaylist() {
        System.out.println("PlaylistService is active.");
        songService.playSong();
    }
}

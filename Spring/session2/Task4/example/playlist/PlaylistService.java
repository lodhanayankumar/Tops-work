package com.example.playlist;

import java.util.List;

public class PlaylistService {

    private SongRepository songRepository;

    // Constructor injection
    public PlaylistService(SongRepository songRepository) {
        this.songRepository = songRepository;
    }

    // Display all songs
    public void displayPlaylist() {

        List<Song> songs = songRepository.getSong();

        System.out.println("===== My Spotify Playlist =====");

        for (Song song : songs) {
            System.out.println(song);
        }
    }
}
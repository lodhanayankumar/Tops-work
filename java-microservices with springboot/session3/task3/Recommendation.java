package com.example.recommendationservice.model;

import java.util.List;

public class Recommendation {

    private int id;
    private String username;
    private String playlistName;
    private List<String> songs;

    public Recommendation() {
    }

    public Recommendation(
            int id,
            String username,
            String playlistName,
            List<String> songs) {

        this.id = id;
        this.username = username;
        this.playlistName = playlistName;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPlaylistName() {
        return playlistName;
    }

    public void setPlaylistName(String playlistName) {
        this.playlistName = playlistName;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}
package com.example.playlistservice;

import java.util.List;

public class Playlist {

    private int id;
    private String name;
    private List<String> songs;

    public Playlist() {
    }

    public Playlist(int id, String name, List<String> songs) {
        this.id = id;
        this.name = name;
        this.songs = songs;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs;
    }
}

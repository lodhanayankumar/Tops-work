package com.example.playlistservice;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private int id;
    private String name;
    private String creator;
    private List<String> songs = new ArrayList<>();

    public Playlist() {
    }

    public Playlist(int id, String name, String creator,
                    List<String> songs) {
        this.id = id;
        this.name = name;
        this.creator = creator;
        this.songs = songs == null
                ? new ArrayList<>()
                : new ArrayList<>(songs);
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

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public List<String> getSongs() {
        return songs;
    }

    public void setSongs(List<String> songs) {
        this.songs = songs == null
                ? new ArrayList<>()
                : new ArrayList<>(songs);
    }
}

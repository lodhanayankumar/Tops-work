package com.example.userprofileservice;

public class Playlist {

    private int id;
    private String name;
    private String creator;

    public Playlist() {
    }

    public Playlist(int id, String name, String creator) {
        this.id = id;
        this.name = name;
        this.creator = creator;
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
}
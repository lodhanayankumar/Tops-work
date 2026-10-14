package com.example.playlist;

public class Song {
     
	private String artist;
	private String title;
	
	
	public Song(String title,String artist) {
		this.artist = artist;
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public Song() {
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	@Override
	public String toString() {
		return title + "-"+ artist;
	}
}

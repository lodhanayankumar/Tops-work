package com.example.playlist;

import java.util.List;
import java.util.ArrayList;

public class SongRepository {
	public List<Song> getSong(){
		
		List<Song> songs =new ArrayList<>();
//add song in arrylist		
		songs.add(new Song("Perfect", "Ed Sheeran"));
		songs.add(new Song("Shape of You", "Ed Sheeran"));
		songs.add(new Song("Beliver", "Imagine Dragons"));
		songs.add(new Song("Kesariya", "Arajitsingh"));
		return songs;
		
	}

}

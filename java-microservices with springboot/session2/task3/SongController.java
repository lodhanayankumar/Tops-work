
package com.example.songservice;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SongController {

    private final List<Song> songs = new ArrayList<>();

    public SongController() {
        songs.add(new Song(1, "Perfect", "Ed Sheeran", 263));
        songs.add(new Song(2, "Believer", "Imagine Dragons", 204));
        songs.add(new Song(3, "Shape of You", "Ed Sheeran", 234));
        songs.add(new Song(4, "Kesariya", "Arijit Singh", 268));
    }
    @GetMapping("/songs")
    public List<Song> getAllSongs() {
        return songs;
    }
}

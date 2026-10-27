package com.example.song.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.song.model.Song;

@RestController
public class SongController {

    @GetMapping("/songs")
    public List<Song> getAllSongs() {

        return Arrays.asList(
            new Song(1, "Perfect", "Ed Sheeran", 4.23),
            new Song(2, "Shape of You", "Ed Sheeran", 3.53),
            new Song(3, "Believer", "Imagine Dragons", 3.24)
        );
    }
}
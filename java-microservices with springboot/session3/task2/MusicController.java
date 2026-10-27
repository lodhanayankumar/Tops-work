package com.example.musicservice.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.musicservice.model.Music;

@RestController
public class MusicController {

    @GetMapping("/music")
    public List<Music> getAllMusic() {

        return Arrays.asList(
            new Music(1,"perfect","ed sheeran","divide"),
            new Music(2,"believer","imagine dragons","evolve"),
            new Music(3,"blinding lights","the weeknd","after hours")
        );
    }

    @GetMapping("/")
    public String home() {
        return "progrmam is Running!";
    }
}
package com.example.playlist.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.playlist.model.Song;

@Service
public class SongClientService {

    private final RestTemplate restTemplate;

    public SongClientService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public List<Song> getAllSongs() {

        String url = "http://localhost:8082/songs";

        ResponseEntity<List<Song>> response =
            restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Song>>() {}
            );

        List<Song> songs = response.getBody();

        return songs != null ? songs : List.of();
    }
}
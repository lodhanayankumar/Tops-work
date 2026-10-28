package com.example.playlistservice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final Map<Integer, Playlist> playlists =
            new ConcurrentHashMap<>();

    private final AtomicInteger idGenerator =
            new AtomicInteger(0);

    private final RestTemplate restTemplate;

public PlaylistController(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }
//add a new playlist
    @PostMapping
    public ResponseEntity<Playlist> addPlaylist( @RequestBody Playlist playlist) {

        int id = idGenerator.incrementAndGet();

        playlist.setId(id);

        if (playlist.getSongs() == null) {
            playlist.setSongs(new ArrayList<>());
        }

        playlists.put(id, playlist);

        return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
    }

//fetch all playlists
    @GetMapping
    public List<Playlist> getAllPlaylists() {

        return new ArrayList<>(playlists.values());
    }

//fetch a playlist by id
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById( @PathVariable int id) {

        Playlist playlist = playlists.get(id);

        if (playlist == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(playlist);
    }

//delete a playlist by id
    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, String>> deletePlaylist(@PathVariable int id) {

        Playlist removed = playlists.remove(id);

        if (removed == null) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message", "playlist not found"));
        }

        return ResponseEntity.ok(Map.of("message", "playlist deleted successful"));
    }

//fetch playlist
    @GetMapping("/{playlistId}/tracks")
    public ResponseEntity<List<Track>> getTracksForPlaylist(@PathVariable int playlistId) {
//check playlist exists
        if (!playlists.containsKey(playlistId)) {
            return ResponseEntity.notFound().build();
        }
//call trackService by eu
        String url ="http://TRACKSERVICE/tracks/playlist/{playlistId}";

        Track[] tracks = restTemplate.getForObject(url,Track[].class,playlistId);

        if (tracks == null) {
            return ResponseEntity.ok(new ArrayList<>());
        }

        return ResponseEntity.ok(Arrays.asList(tracks));
    }
}

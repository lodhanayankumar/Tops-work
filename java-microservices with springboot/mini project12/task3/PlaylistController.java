package com.example.playlistservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final Map<Integer, Playlist> playlists =
            new ConcurrentHashMap<>();

    private final AtomicInteger idGenerator =
            new AtomicInteger(0);

//add a new playlist
    @PostMapping
    public ResponseEntity<Playlist> addPlaylist(
            @RequestBody Playlist playlist) {

        int id = idGenerator.incrementAndGet();

        playlist.setId(id);

        if (playlist.getSongs() == null) {
            playlist.setSongs(new ArrayList<>());
        }

        playlists.put(id, playlist);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(playlist);
    }

//view all playlists
    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return new ArrayList<>(playlists.values());
    }

//view by id
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(
            @PathVariable int id) {

        Playlist playlist = playlists.get(id);

        if (playlist == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(playlist);
    }

//delete by id
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePlaylist(
            @PathVariable int id) {

        Playlist removed = playlists.remove(id);

        if (removed == null) {
            return ResponseEntity
                    .status(HttpStatus.NOT_FOUND)
                    .body(Map.of("message","playlist not found"));
        }
        return ResponseEntity.ok( Map.of("message", "playlist deleted successful"));
    }
}

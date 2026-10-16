package com.example.playlistservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    private final Map<Integer, Playlist> playlists =
            new ConcurrentHashMap<>();

//creat a playlist
    @PostMapping
    public ResponseEntity<Playlist> createPlaylist(
            @RequestBody Playlist playlist) {

        if (playlists.containsKey(playlist.getId())) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        if (playlist.getSongs() == null) {
            playlist.setSongs(new ArrayList<>());
        }

        playlists.put(playlist.getId(), playlist);

        return ResponseEntity.status(HttpStatus.CREATED).body(playlist);
    }

//all playlists
    @GetMapping
    public List<Playlist> getAllPlaylists() {
        return new ArrayList<>(playlists.values());
    }

//feathch one playlist by id
    @GetMapping("/{id}")
    public ResponseEntity<Playlist> getPlaylistById(
            @PathVariable int id) {

        Playlist playlist = playlists.get(id);

        if (playlist == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(playlist);
    }

//update
    @PutMapping("/{id}")
    public ResponseEntity<Playlist> updatePlaylist(
            @PathVariable int id,
            @RequestBody Playlist updatedPlaylist) {

        if (!playlists.containsKey(id)) {
            return ResponseEntity.notFound().build();
        }

        updatedPlaylist.setId(id);

        if (updatedPlaylist.getSongs() == null) {
            updatedPlaylist.setSongs(new ArrayList<>());
        }

        playlists.put(id, updatedPlaylist);

        return ResponseEntity.ok(updatedPlaylist);
    }

//delete
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePlaylist(
            @PathVariable int id) {

        Playlist removed = playlists.remove(id);

        if (removed == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.noContent().build();
    }
}

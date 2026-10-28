package com.example.trackservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final Map<Integer, Track> tracks =
            new ConcurrentHashMap<>();

    private final AtomicInteger idGenerator = new AtomicInteger(0);

//add a track
    @PostMapping
    public ResponseEntity<Track> addTrack(
            @RequestBody Track track) {

        int id = idGenerator.incrementAndGet();
        track.setId(id);

        tracks.put(id, track);

        return ResponseEntity
                .status(HttpStatus.CREATED).body(track);
    }
//fetch all tracks
    @GetMapping
    public List<Track> getAllTracks() {
        return new ArrayList<>(tracks.values());
    }
//fetch a track by id
    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable int id) {

        Track track = tracks.get(id);

        if (track == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(track);
    }

//fetch all tracks from playlist
    @GetMapping("/playlist/{playlistId}")
    public List<Track> getTracksByPlaylistId(@PathVariable int playlistId) {

        return tracks.values().stream()
                .filter(track -> track.getPlaylistId() == playlistId)
                .collect(Collectors.toList());
    }
}

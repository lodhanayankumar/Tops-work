package com.example.trackservice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tracks")
public class TrackController {

    private final Map<Integer, Track> tracks = new ConcurrentHashMap<>();

    private final AtomicInteger idGenerator = new AtomicInteger(0);

    // Add a new track
    @PostMapping
    public ResponseEntity<Track> addTrack(@RequestBody Track track) {

        int id = idGenerator.incrementAndGet();

        track.setId(id);

        tracks.put(id, track);

        return ResponseEntity.status(HttpStatus.CREATED).body(track);
    }

    // Fetch all tracks
    @GetMapping
    public List<Track> getAllTracks() {

        return new ArrayList<>(tracks.values());
    }

    // Fetch a track by ID
    @GetMapping("/{id}")
    public ResponseEntity<Track> getTrackById(@PathVariable int id) {

        Track track = tracks.get(id);

        if (track == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(track);
    }
}

package com.example.playlistservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable int id) {

        return new Playlist(
                id,
                "My Favorite Songs",
                "Nayan"
        );
    }
}
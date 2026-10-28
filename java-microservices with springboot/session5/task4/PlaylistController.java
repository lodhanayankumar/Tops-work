package com.example.playlistservice;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/playlists")
public class PlaylistController {

    @GetMapping("/{id}")
    public Playlist getPlaylist(@PathVariable int id) {

        if (id != 1) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Playlist not found");
        }

        return new Playlist(1,"favorite songs","Nayan");
    }
}
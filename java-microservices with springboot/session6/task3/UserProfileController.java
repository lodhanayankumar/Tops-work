package com.example.userprofileservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user-profiles")
public class UserProfileController {

    private final PlaylistClient playlistClient;

    public UserProfileController(PlaylistClient playlistClient) {
        this.playlistClient = playlistClient;
    }

    @GetMapping("/playlists/{id}")
    public Playlist getPlaylist(@PathVariable("id") int id) {
        return playlistClient.getPlaylistById(id);
    }
}
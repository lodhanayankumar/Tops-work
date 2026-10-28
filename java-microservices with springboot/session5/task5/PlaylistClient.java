package com.example.userprofileservice;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(
    name = "playlist-service-client",
    url = "${playlist.service.url}",
    fallback = PlaylistFallback.class
)
public interface PlaylistClient {

    @GetMapping("/playlists/{id}")
    Playlist getPlaylistById(@PathVariable("id") int id);
}

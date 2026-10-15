
package com.example.playlistmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PlaylistController {

    @Autowired
    private Playlist playlist;

    @RequestMapping("/showPlaylist")
    public String showPlaylist(Model model) {
        model.addAttribute("playlistName", "My Favorite Songs");
        playlist.showPlaylist();
        return "playlists";
    }
}

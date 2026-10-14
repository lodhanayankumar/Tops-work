/*1. Create a class called PlaylistService that manages a list of songs for a Spotify-style app. Use Spring XML 
 * configuration to inject a SongRepository dependency into PlaylistService using setter injection.
 */

package com.example.playlist;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

    public static void main(String[] args) {

        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");

        PlaylistService service = context.getBean("playlistService", PlaylistService.class);

        service.displayPlaylist();

        context.close();
    }
}

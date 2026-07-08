/*
 * 1. Create a Java class called Song with fields:
 * title, artist, and duration.
 * Store 5 Song objects in an ArrayList
 * and print the details of each song.
 */

import java.util.ArrayList;

// Song Class
class Song {

    // Data Members
    String title;
    String artist;
    double duration;

    // Constructor
    Song(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
    }

    // Method to display song details
    public void display() {
        System.out.println("Title    : " + title);
        System.out.println("Artist   : " + artist);
        System.out.println("Duration : " + duration + " min");
        System.out.println();
    }
}

// Main Class
public class song_with_field {

    public static void main(String[] args) {

        // Create an ArrayList to store Song objects
        ArrayList<Song> songs = new ArrayList<>();

        // Add 5 Song objects
        songs.add(new Song("Kesariya", "Arijit Singh", 4.50));
        songs.add(new Song("Lag Ja Gale", "Lata Mangeshkar", 4.09));
        songs.add(new Song("Dil De Diya Hai", "Anand Raj Anand", 6.14));
        songs.add(new Song("Believer", "Imagine Dragons", 3.50));
        songs.add(new Song("Perfect", "Ed Sheeran", 4.23));

        // Display all song details
        for (Song s : songs) {
            s.display();
        }
    }
}
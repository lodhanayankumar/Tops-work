/*5.Refactor a given controller class that directly handles both business logic and data access for a Playlist feature 
 * (like Spotify) by separating the data access code into a PlaylistDAO class. Show before and after code snippets and 
 * explain the benefit in 2-3 lines
 */

package task3;

public class PlaylistDAO105 {

    public void getPlaylistFromDatabase() {

        System.out.println("Connecting to database...");

        System.out.println("Fetching playlist from database...");

        System.out.println("Playlist data fetched successfully.");
    }
}
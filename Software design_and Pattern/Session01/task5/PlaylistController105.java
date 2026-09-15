/*5.Refactor a given controller class that directly handles both business logic and data access for a Playlist 
 * feature (like Spotify) by separating the data access code into a PlaylistDAO class. Show before and after 
 * code snippets and explain the benefit in 2-3 lines.
 */

package task3;

public class PlaylistController105 {

    public void getPlaylist() {

        System.out.println("Connecting to database...");
        System.out.println("Fetching playlist from database...");

        System.out.println("Playlist: My Favorite Songs");
        System.out.println("Song 1: Believer");
        System.out.println("Song 2: Perfect");
        System.out.println("Song 3: Shape of You");
    }

    public static void main(String[] args) {

        PlaylistController105 controller = new PlaylistController105();

        controller.getPlaylist();
    }
}

//Separating data access into PlaylistDAO105 keeps the Controller focused on business logic.
//It makes the code easier to maintain, test, and modify when database operations change.
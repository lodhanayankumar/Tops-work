/*5.Explain in 4-5 lines how a 2D array in Java can be used to model 
 *  a database table, such as a Spotify playlist table with columns for
 *  song name, artist, and duration.
 */

/*A 2D array in Java stores data in rows and columns, similar to a database table. 
 *Each row represents one record, such as a song in a Spotify playlist. 
 *Each column stores a specific field, like the song name, artist, and duration. 
 *Elements are accessed using row and column indices, 
 *for example playlist[0][1] gives the artist of the first song. 
 *This makes organizing and retrieving tabular data simple.
 */
public class spotify_playlist {
    public static void main(String[] args) {

        String[][] playlist = {
            {"Shape of You", "Ed Sheeran", "3:53"},
            {"Blinding Lights", "The Weeknd", "3:20"},
            {"Perfect", "Ed Sheeran", "4:23"}
        };

        for (int i = 0; i < playlist.length; i++) {
            System.out.println("Song: " + playlist[i][0]);
            System.out.println("Artist: " + playlist[i][1]);
            System.out.println("Duration: " + playlist[i][2]);
            System.out.println();
        }
    }
}
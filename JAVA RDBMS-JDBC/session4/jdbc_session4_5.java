/*5.Suppose you want to display a user's playlist from a 'playlists' table like Spotify does. Use ChatGPT or 
 * Copilot to generate a JDBC SELECT query and Java code snippet that fetches all songs for a given playlist_id, 
 * then adapt the generated code to display song titles and artists in your console output.
 */
package jdbc_session4;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class jdbc_session4_5 {

    static final String URL = "jdbc:mysql://localhost:3306/spotify_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Playlist ID: ");
        int playlistId = sc.nextInt();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            String sql = "SELECT song_title, artist FROM playlists WHERE playlist_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, playlistId);

            ResultSet rs = ps.executeQuery();

            System.out.println("\nSongs in Playlist");
            System.out.println("------------------------------------------");
            System.out.printf("%-25s %-20s%n", "Song Title", "Artist");
            System.out.println("------------------------------------------");

            boolean found = false;

            while (rs.next()) {
                found = true;

                System.out.printf("%-25s %-20s%n",
                        rs.getString("song_title"),
                        rs.getString("artist"));
            }

            if (!found) {
                System.out.println("No songs found for this playlist.");
            }

            rs.close();
            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
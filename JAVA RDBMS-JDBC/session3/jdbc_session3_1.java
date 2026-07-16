/*1.Create a Java class AddSongToPlaylist that connects to a MySQL database and 
 *uses PreparedStatement to insert a new song (song_id, title, artist) into a 
 *playlist_songs table.
 */
package jdbc_session3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc_session3_1 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spotify_clone";
        String username = "root";
        String password = "Nayan@2001";

        String sql = "INSERT INTO playlist_songs(song_id, title, artist) VALUES (?, ?, ?)";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(sql);

            // Set Values
            ps.setInt(1, 101);
            ps.setString(2, "Perfect");
            ps.setString(3, "Ed Sheeran");

            // Execute Query
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Song added successfully.");
            } else {
                System.out.println("Song could not be added.");
            }

            // Close Resources
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
        } catch (SQLException e) {
            System.out.println("Database Error!");
            System.out.println(e.getMessage());
        }
    }
}
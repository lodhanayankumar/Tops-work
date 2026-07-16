/*1.Write a Java program named PlaylistFetcher.java that connects to a MySQL database and retrieves all playlist 
 * names from a 'playlists' table using JDBC, ensuring all resources are closed safely with try-with-resources.
 */
package jdbc_session6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class jdbc_session6_1  {

    static final String URL = "jdbc:mysql://localhost:3306/spotify_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        String sql = "SELECT playlist_name FROM playlists";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Try-with-resources automatically closes Connection,
            // PreparedStatement, and ResultSet.
            try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()
            ) {

                System.out.println("Playlist Names");
                System.out.println("-----------------------");

                while (rs.next()) {
                    System.out.println(rs.getString("playlist_name"));
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
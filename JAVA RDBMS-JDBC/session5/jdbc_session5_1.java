/*1.Create a Java program that connects to a MySQL database using JDBC, inserts a single new record into a 
 * 'playlist' table (id, song_name, artist) for a Spotify-style music app, and commits the transaction.
 */
package jdbc_session5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class jdbc_session5_1  {

    static final String URL = "jdbc:mysql://localhost:3306/spotify_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Playlist ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Song Name: ");
        String songName = sc.nextLine();

        System.out.print("Enter Artist Name: ");
        String artist = sc.nextLine();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Start Transaction
            con.setAutoCommit(false);

            String sql = "INSERT INTO playlist(id, song_name, artist) VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ps.setString(2, songName);
            ps.setString(3, artist);

            int rows = ps.executeUpdate();

            con.commit();   // Commit Transaction

            if (rows > 0) {
                System.out.println("Song added successfully.");
            } else {
                System.out.println("Song not added.");
            }

            ps.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
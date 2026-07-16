/*5.Use GitHub Copilot (or another AI code assistant) to generate a JDBC template for inserting a new record into a 
 * 'movies' table (fields: id, title, genre), then customize the generated code to include exception handling using 
 * try-with-resources.<br><br><em><strong>Hint:</strong> Paste your Copilot prompt and the final customized code as 
 * part of your submission.</em>
 */
// copilot promt : Generate a Java JDBC program that inserts a new record into a MySQL movies table (id, title, genre) 
//using PreparedStatement and try-with-resources.
package jdbc_session6;
 
import java.sql.*;

public class jdbc_session6_5 {

    // Database Connection
    private static final String DB_URL = "jdbc:mysql://localhost:3306/movies_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "Nayan@2001";   // Change if your password is different

    public static void main(String[] args) {

        // Insert One Movie
        insertMovie(1, "Pushpa 2", "Action");

        // Insert Multiple Movies
        Movie[] movies = {
                new Movie(2, "Kalki 2898 AD", "Sci-Fi"),
                new Movie(3, "Stree 2", "Horror"),
                new Movie(4, "War 2", "Action")
        };

        insertMultipleMovies(movies);
    }

    // Insert Single Movie
    public static void insertMovie(int id, String title, String genre) {

        String sql = "INSERT INTO movies(id, title, genre) VALUES (?, ?, ?)";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, id);
            pstmt.setString(2, title);
            pstmt.setString(3, genre);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("Movie Inserted Successfully.");
            }

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }
    }

    // Insert Multiple Movies using Batch Processing
    public static void insertMultipleMovies(Movie[] movies) {

        String sql = "INSERT INTO movies(id, title, genre) VALUES (?, ?, ?)";

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                PreparedStatement pstmt = conn.prepareStatement(sql)) {

            conn.setAutoCommit(false);

            for (Movie movie : movies) {

                pstmt.setInt(1, movie.getId());
                pstmt.setString(2, movie.getTitle());
                pstmt.setString(3, movie.getGenre());

                pstmt.addBatch();
            }

            pstmt.executeBatch();

            conn.commit();

            System.out.println("All Movies Inserted Successfully.");

        } catch (SQLException e) {

            System.out.println("Database Error : " + e.getMessage());
        }
    }

    // Movie Class
    static class Movie {

        private int id;
        private String title;
        private String genre;

        public Movie(int id, String title, String genre) {
            this.id = id;
            this.title = title;
            this.genre = genre;
        }

        public int getId() {
            return id;
        }

        public String getTitle() {
            return title;
        }

        public String getGenre() {
            return genre;
        }
    }
}
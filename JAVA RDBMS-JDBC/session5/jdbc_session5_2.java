/*2.Write a Java method addMultipleMovies() that takes a list of movie names and inserts them into a 'movies' 
 * table using JDBC batch processing, similar to uploading multiple movies to a BookMyShow-style app.
 * <br><br><em><strong>Hint:</strong> Use addBatch() and executeBatch() methods to perform the inserts efficiently.</em>
 */
package jdbc_session5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.ArrayList;

public class jdbc_session5_2  {

    static final String URL = "jdbc:mysql://localhost:3306/movies_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    // Method to add multiple movies
    public static void addMultipleMovies(ArrayList<String> movies) {

        String sql = "INSERT INTO movies(movie_name) VALUES(?)";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);

            for (String movie : movies) {
                ps.setString(1, movie);
                ps.addBatch();          // Add query to batch
            }

            int[] result = ps.executeBatch();   // Execute all inserts

            System.out.println(result.length + " Movies Inserted Successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {

        ArrayList<String> movieList = new ArrayList<>();

        movieList.add("Pushpa 2");
        movieList.add("Kalki 2898 AD");
        movieList.add("Sikandar");
        movieList.add("Stree 2");
        movieList.add("War 2");

        addMultipleMovies(movieList);
    }
}

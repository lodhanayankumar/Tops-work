/*3.Modify your SpotifyDBTest.java program to handle SQL and ClassNotFound 
 * exceptions using try-catch blocks, and print a custom error message if 
 * the connection fails.<br><br><em><strong>Hint:</strong> Catch both 
 * SQLException and ClassNotFoundException separately and print which one occurred.</em>
 */
package jdbc_session2;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbac_session2_3 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spotify_clone";
        String username = "root";
        String password = "root123";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            System.out.println("Connection Successful");

            // Close Connection
            con.close();

        } catch (ClassNotFoundException e) {

            System.out.println("ClassNotFoundException Occurred!");
            System.out.println("MySQL JDBC Driver not found.");
            System.out.println("Error: " + e.getMessage());

        } catch (SQLException e) {

            System.out.println("SQLException Occurred!");
            System.out.println("Failed to connect to the database.");
            System.out.println("Error: " + e.getMessage());

        }
    }
}

package jdbc_session2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class jdbc_session2_2  {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/spotify_clone";
        String username = "root";
        String password = "";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(url, username, password);

            if (con != null) {
                System.out.println("Connection Successful");
            }

            // Close Connection
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
        } catch (SQLException e) {
            System.out.println("Connection Failed!");
            System.out.println("Error: " + e.getMessage());
        }
    }
}

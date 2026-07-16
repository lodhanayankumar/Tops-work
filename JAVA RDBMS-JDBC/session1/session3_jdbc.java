/*3.In your TestDBConnection.java, intentionally enter a wrong password and 
 * observe the error message printed when running the program.<br><br><em><strong>
 * Hint:</strong> Note the SQLException message and explain in a comment what went 
 * wrong.</em>
 */
package jdbc_ass1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class session3_jdbc{

	public static void main(String[] args) {

		String url = "jdbc:mysql://localhost:3306/music_db";
	    String username = "root";

	        // Intentionally incorrect password
	    String password = "wrong123";
       try {
	            // Load MySQL JDBC Driver
         Class.forName("com.mysql.cj.jdbc.Driver");

	            // Attempt to establish connection
         Connection con = DriverManager.getConnection(url, username, password);

        System.out.println("Connection Successful");

        con.close();

        } catch (ClassNotFoundException e) {
	         System.out.println("MySQL JDBC Driver Not Found!");
        } catch (SQLException e) {

        	System.out.println("Database Connection Failed!");
	        System.out.println("Error Message: " + e.getMessage());

	        }
       }
}


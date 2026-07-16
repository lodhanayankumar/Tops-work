/* 2.Write a Java program named TestDBConnection.java that uses DriverManager to 
 * connect to a local MySQL database called 'music_db' with username 'root' 
 * and password 'root123', then print 'Connection Successful' if the connection is 
 * established.
 */
package jdbc_ass1;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class session2_jdbc {

	public static void main(String[] args) {

     String url = "jdbc:mysql://localhost:3306/music_db";
     String username = "root";
     String password = "root123";

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
	            System.out.println("Database Connection Failed!");
	            System.out.println(e.getMessage());
	        }
	   }
}


/*4.Given the following buggy Java code that uses Statement to insert user input 
 * into a users table: `String query = "INSERT INTO users (username, password) 
 * VALUES ('" + username + "', '" + password + "')"; 
 * Statement stmt = conn.createStatement(); stmt.executeUpdate(query);
 * ` — refactor this code to use PreparedStatement and explain how this change 
 * helps prevent SQL Injection.<br><br><em><strong>Hint:</strong> Show both the 
 * refactored code and a 1-2 line explanation.</em>
 */
package jdbc_session3;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_session3_4 {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/shopping_db";
        String user = "root";
        String password = "Nayan@2001";

        String username = "Nayan";
        String userPassword = "12345";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection(url, user, password);

            String query = "INSERT INTO users (username, password) VALUES (?, ?)";

            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, username);
            pstmt.setString(2, userPassword);

            int rows = pstmt.executeUpdate();

            if (rows > 0) {
                System.out.println("User inserted successfully.");
            } else {
                System.out.println("User insertion failed.");
            }

            pstmt.close();
            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("PreparedStatement uses parameter placeholders (?) instead of concatenating\n user input into the SQL query. This treats user input as data rather than \nexecutable SQL, preventing SQL Injection attacks and making the code more secure.");
        }
}

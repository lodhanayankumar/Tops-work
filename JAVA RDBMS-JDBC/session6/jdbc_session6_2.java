/*2.Modify an existing JDBC code that fetches user data from a 'users' table so that it properly handles SQL 
 * exceptions and prints a user-friendly error message if the database connection fails.<br><br><em><strong>
 * Hint:</strong> Use catch blocks to handle SQLException and display a custom message instead of the stack trace.</em>
 */
package jdbc_session6;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class jdbc_session6_2 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        String sql = "SELECT * FROM users";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            System.out.println("User Details");
            System.out.println("---------------------------");

            while (rs.next()) {
                System.out.println(
                        rs.getInt("user_id") + " " +
                        rs.getString("username") + " " +
                        rs.getString("password"));
            }

            rs.close();
            ps.close();
            con.close();

        } catch (SQLException e) {
            System.out.println("Unable to connect to the database. Please check the database server, URL, username, or password.");

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver not found.");
        }
    }
}

/*4.Given this scenario: you forgot to call commit() after inserting multiple records in a JDBC transaction 
 * (auto-commit is off), explain what happens to the data in the database and how you would fix the issue in code.
 */
package jdbc_session5;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_session5_4 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Disable Auto Commit
            con.setAutoCommit(false);

            String sql = "INSERT INTO orders(order_id, product_name, quantity) VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            // First Record
            ps.setInt(1, 201);
            ps.setString(2, "Laptop");
            ps.setInt(3, 1);
            ps.executeUpdate();

            // Second Record
            ps.setInt(1, 202);
            ps.setString(2, "Mouse");
            ps.setInt(3, 2);
            ps.executeUpdate();

            // Third Record
            ps.setInt(1, 203);
            ps.setString(2, "Keyboard");
            ps.setInt(3, 1);
            ps.executeUpdate();

            // Save all records permanently
            con.commit();

            System.out.println("Transaction Committed Successfully.");

            ps.close();
            con.close();

        } catch (Exception e) {

            try {
                if (con != null) {
                    con.rollback();
                    System.out.println("Transaction Rolled Back.");
                }
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            e.printStackTrace();
        }
        System.out.println("Without commit(), the transaction is not saved to the database; adding con.commit() after \nsuccessful inserts permanently stores the records.");
    }
}
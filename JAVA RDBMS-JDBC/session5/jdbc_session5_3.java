/*3.Simulate a Flipkart-style shopping cart: Write Java code that adds multiple products to an 'orders' table in a 
 * single batch using JDBC, but if any insert fails (e.g., duplicate product id), rollback the entire transaction 
 * so no products are saved.<br><br><em><strong>Hint:</strong> Use setAutoCommit(false), commit(), and rollback() 
 * methods for transaction control.</em>
 */
package jdbc_session5;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class jdbc_session5_3  {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Connection con = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Start Transaction
            con.setAutoCommit(false);

            String sql = "INSERT INTO orders(order_id, product_name, quantity) VALUES(?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(sql);

            // Order 1
            ps.setInt(1, 101);
            ps.setString(2, "Laptop");
            ps.setInt(3, 1);
            ps.addBatch();

            // Order 2
            ps.setInt(1, 102);
            ps.setString(2, "Mouse");
            ps.setInt(3, 2);
            ps.addBatch();

            // Duplicate ID (to simulate failure)
            ps.setInt(1, 101);
            ps.setString(2, "Keyboard");
            ps.setInt(3, 1);
            ps.addBatch();

            // Execute Batch
            ps.executeBatch();

            // Commit Transaction
            con.commit();

            System.out.println("All orders inserted successfully.");

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
    }
}
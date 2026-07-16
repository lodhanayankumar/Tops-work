/*2.Write a Java method updateOrderStatus in a class FlipkartOrderManager that uses 
 * PreparedStatement to update the status of an order (by order_id) in an orders table.
 */

package jdbc_session3;

 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class jdbc_session3_2 {

    // Database Connection Details
    static final String URL = "jdbc:mysql://localhost:3306/flipkart_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    // Method to update order status
    public static void updateOrderStatus(int orderId, String status) {

        String query = "UPDATE orders SET status = ? WHERE order_id = ?";

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Database Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create PreparedStatement
            PreparedStatement ps = con.prepareStatement(query);

            // Set Parameters
            ps.setString(1, status);
            ps.setInt(2, orderId);

            // Execute Update
            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Order status updated successfully.");
            } else {
                System.out.println("Order ID not found.");
            }

            // Close Resources
            ps.close();
            con.close();

        } catch (ClassNotFoundException e) {
            System.out.println("MySQL JDBC Driver Not Found!");
        } catch (SQLException e) {
            System.out.println("Database Error!");
            System.out.println(e.getMessage());
        }
    }

    public static void main(String[] args) {

        // Update order status
        updateOrderStatus(101, "Delivered");

    }
}

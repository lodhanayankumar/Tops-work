/*Task 4: Atomic Order Placement with Transaction Control
Build a Java service that places a food order by executing three related SQL statements inside
a single JDBC transaction and rolling back all changes atomically if any one step fails.
*Implement placeOrder(String customerId, int restaurantId, double orderAmount) that opens a
single Connection, immediately calls setAutoCommit(false), and executes all three operations
on that connection.
*The three operations are: (1) UPDATE customers SET wallet_balance = wallet_balance - ?
WHERE customer_id = ?, (2) INSERT INTO orders (customer_id, restaurant_id, amount) VALUES
(?, ?, ?), and (3) UPDATE restaurants SET pending_orders = pending_orders + 1 WHERE
restaurant_id = ?.
*If all three execute without throwing an exception, call conn.commit(); in the catch block call
conn.rollback() before re-throwing the exception wrapped in a descriptive RuntimeException.
*In main(), demonstrate the rollback path by passing a non-existent restaurantId to trigger
failure on the third statement; after the exception is caught, query the customers and orders
tables to confirm no rows were modified and print the result.
*/
package assesment;

import java.sql.*;

public class B_task4 {

    static final String DB_URL = "jdbc:mysql://localhost:3306/fooddb";
    static final String DB_USER = "root";
    static final String DB_PASSWORD = "Nayan@2001";

    // Place Order
    public static void placeOrder(String customerId, int restaurantId, double orderAmount) {

        Connection conn = null;

        try {

            conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

            // Start Transaction
            conn.setAutoCommit(false);

            // 1. Update Customer Wallet
            String sql1 = "UPDATE customers SET wallet_balance = wallet_balance - ? WHERE customer_id=?";

            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setDouble(1, orderAmount);
            ps1.setString(2, customerId);

            if (ps1.executeUpdate() == 0) {
                throw new SQLException("Customer not found.");
            }

            // 2. Insert Order
            String sql2 = "INSERT INTO orders(customer_id,restaurant_id,amount) VALUES(?,?,?)";

            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, customerId);
            ps2.setInt(2, restaurantId);
            ps2.setDouble(3, orderAmount);

            ps2.executeUpdate();

            // 3. Update Restaurant
            String sql3 = "UPDATE restaurants SET pending_orders=pending_orders+1 WHERE restaurant_id=?";

            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setInt(1, restaurantId);

            if (ps3.executeUpdate() == 0) {
                throw new SQLException("Restaurant not found.");
            }

            // Commit
            conn.commit();

            System.out.println("Order Placed Successfully.");

            ps1.close();
            ps2.close();
            ps3.close();

        } catch (Exception e) {

            try {

                if (conn != null) {
                    conn.rollback();
                    System.out.println("Transaction Rolled Back.");
                }

            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            throw new RuntimeException("Order Placement Failed : " + e.getMessage());

        } finally {

            try {

                if (conn != null) {
                    conn.setAutoCommit(true);
                    conn.close();
                }

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    // Display Customer Wallet
    public static void showCustomer(String customerId) {

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);

                PreparedStatement ps = conn.prepareStatement(
                        "SELECT * FROM customers WHERE customer_id=?")) {

            ps.setString(1, customerId);

            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                System.out.println("Customer : "+ rs.getString("customer_id")+ " Wallet : "
                        + rs.getDouble("wallet_balance"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Display Orders
    public static void showOrders() {

        try (
                Connection conn = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery("SELECT * FROM orders")) {
            System.out.println("\nOrders Table");
            while (rs.next()) {
                System.out.println(rs.getInt("order_id") + " "+ rs.getString("customer_id") + " "
                                + rs.getInt("restaurant_id") + " "+ rs.getDouble("amount"));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }
    // Main
    public static void main(String[] args) {

        System.out.println("Before Transaction");
        showCustomer("C101");
        showOrders();
        try {
            // Invalid Restaurant ID
            placeOrder("C101", 999, 300);
        } catch (RuntimeException e) {

            System.out.println(e.getMessage());
        }
        System.out.println("\nAfter Rollback");

        showCustomer("C101");
        showOrders();
    }
}
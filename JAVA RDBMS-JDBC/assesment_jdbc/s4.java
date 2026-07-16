/*s4 SCENARIO
You are building the order placement flow for a food delivery platform. When a
customer places an order, three database operations must succeed together: (1)
deduct the order amount from the customer's wallet_balance, (2) insert a new row into
the orders table, and (3) increment the restaurant's pending_orders counter.*/
package assesment;

import java.sql.*;
import java.util.Scanner;

public class s4 {

    public static void main(String[] args) {

        Connection con = null;
        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "Nayan@2001");

            // Start Transaction
            con.setAutoCommit(false);

            System.out.print("Enter Customer ID : ");
            int customerId = sc.nextInt();

            System.out.print("Enter Restaurant ID : ");
            int restaurantId = sc.nextInt();

            System.out.print("Enter Order Amount : ");
            double amount = sc.nextDouble();

            // ================= Check Customer =================

            PreparedStatement checkCustomer = con.prepareStatement(
                    "SELECT wallet_balance FROM customer WHERE customer_id=?");

            checkCustomer.setInt(1, customerId);

            ResultSet rs = checkCustomer.executeQuery();

            if (!rs.next()) {
                throw new SQLException("Customer ID Not Found.");
            }

            double balance = rs.getDouble("wallet_balance");

            if (balance < amount) {
                throw new SQLException("Insufficient Wallet Balance.");
            }

            // ================= 1. Deduct Wallet =================

            PreparedStatement ps1 = con.prepareStatement(
                    "UPDATE customer SET wallet_balance=wallet_balance-? WHERE customer_id=?");

            ps1.setDouble(1, amount);
            ps1.setInt(2, customerId);

            int walletUpdate = ps1.executeUpdate();

            if (walletUpdate == 0) {
                throw new SQLException("Wallet Update Failed.");
            }

            // ================= 2. Insert Order =================

            PreparedStatement ps2 = con.prepareStatement(
                    "INSERT INTO orders(customer_id,restaurant_id,amount) VALUES(?,?,?)");

            ps2.setInt(1, customerId);
            ps2.setInt(2, restaurantId);
            ps2.setDouble(3, amount);

            int orderInsert = ps2.executeUpdate();

            if (orderInsert == 0) {
                throw new SQLException("Order Insert Failed.");
            }

            // ================= 3. Update Restaurant =================

            PreparedStatement ps3 = con.prepareStatement(
                    "UPDATE restaurant SET pending_orders=pending_orders+1 WHERE restaurant_id=?");

            ps3.setInt(1, restaurantId);

            int restaurantUpdate = ps3.executeUpdate();

            if (restaurantUpdate == 0) {
                throw new SQLException("Restaurant ID Not Found.");
            }

            // ================= Commit =================

            con.commit();

            System.out.println("\nTransaction Successful.");
            System.out.println("Wallet Deducted.");
            System.out.println("Order Placed.");
            System.out.println("Restaurant Pending Orders Updated.");

        } catch (Exception e) {

            System.out.println("\nTransaction Failed.");
            System.out.println(e.getMessage());

            try {

                if (con != null) {

                    con.rollback();

                    System.out.println("Rollback Completed.");

                }

            } catch (SQLException ex) {

                System.out.println(ex.getMessage());

            }

        } finally {

            try {

                if (con != null) {

                    con.setAutoCommit(true);

                    con.close();

                }

            } catch (Exception e) {

                System.out.println(e.getMessage());

            }

            sc.close();

        }

    }

}
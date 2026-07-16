/*1.Write a Java program using JDBC that connects to your MySQL database and executes a SELECT query to 
 * fetch all products from a 'products' table, then displays each product's name and price in a formatted table 
 * in the console.
 */
package jdbc_session4;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class jdbc_session4_1 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        try {
            // Load MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish Connection
            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Create Statement
            Statement stmt = con.createStatement();

            // Execute SELECT Query
            String query = "SELECT * FROM products";
            ResultSet rs = stmt.executeQuery(query);

            // Display Data
            System.out.println("---------------------------------------");
            System.out.printf("%-20s %-10s%n", "Product Name", "Price");
            System.out.println("---------------------------------------");

            while (rs.next()) {
                String productName = rs.getString("product_name");
                double price = rs.getDouble("price");

                System.out.printf("%-20s ₹%.2f%n", productName, price);
            }

            System.out.println("---------------------------------------");

            // Close Resources
            rs.close();
            stmt.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

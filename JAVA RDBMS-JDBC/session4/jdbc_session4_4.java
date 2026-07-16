/*4.Add sorting to your SELECT query so that products are displayed in ascending order of price. Let the user choose 
 * whether to sort by price or by product name before fetching results.
 */
package jdbc_session4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class jdbc_session4_4 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Choose Sorting Option");
        System.out.println("1. Price");
        System.out.println("2. Product Name");
        System.out.print("Enter Choice: ");
        int choice = sc.nextInt();

        String query;

        if (choice == 1) {
            query = "SELECT product_name, category, price FROM products ORDER BY price ASC";
        } else if (choice == 2) {
            query = "SELECT product_name, category, price FROM products ORDER BY product_name ASC";
        } else {
            System.out.println("Invalid Choice");
            sc.close();
            return;
        }

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery(query);

            System.out.println("\n------------------------------------------------------------");
            System.out.printf("%-20s %-15s %-10s%n",
                    "Product Name", "Category", "Price");
            System.out.println("------------------------------------------------------------");

            while (rs.next()) {
                System.out.printf("%-20s %-15s ₹%.2f%n",
                        rs.getString("product_name"),
                        rs.getString("category"),
                        rs.getDouble("price"));
            }

            rs.close();
            stmt.close();
            con.close();
            sc.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

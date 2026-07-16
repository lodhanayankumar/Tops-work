/*s3 SCENARIO
You are developing the admin login and menu search features for a food delivery
back-office panel. The login query is built by concatenating the username and
password directly into a SQL string. The menu search constructs its query the same way
using the keyword typed by the admin*/
package assesment;

import java.sql.*;
import java.util.Scanner;

public class S3 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/food_delivery",
                    "root",
                    "Nayan@2001");

            // ================= VULNERABLE LOGIN =================

            System.out.println("========== VULNERABLE LOGIN ==========");

            System.out.print("Enter Username : ");
            String username = sc.nextLine();

            System.out.print("Enter Password : ");
            String password = sc.nextLine();

            Statement st = con.createStatement();

            String vulnerableQuery =
                    "SELECT * FROM admin WHERE username='" + username +
                    "' AND password='" + password + "'";

            System.out.println("\nGenerated Query:");
            System.out.println(vulnerableQuery);

            ResultSet rs = st.executeQuery(vulnerableQuery);

            if (rs.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }

            System.out.println("\n-----------------------------------");
            System.out.println("This query is vulnerable to SQL Injection.");
            System.out.println("-----------------------------------");


            // ================= SECURE LOGIN =================

            System.out.println("\n========== SECURE LOGIN ==========");

            System.out.print("Enter Username : ");
            username = sc.nextLine();

            System.out.print("Enter Password : ");
            password = sc.nextLine();

            String secureQuery =
                    "SELECT * FROM admin WHERE username=? AND password=?";

            PreparedStatement ps = con.prepareStatement(secureQuery);

            ps.setString(1, username);
            ps.setString(2, password);

            ResultSet rs2 = ps.executeQuery();

            if (rs2.next()) {
                System.out.println("Login Successful");
            } else {
                System.out.println("Invalid Username or Password");
            }

            System.out.println("\nPreparedStatement prevents SQL Injection.");

            // ================= MENU SEARCH =================

            System.out.println("\n========== MENU SEARCH ==========");

            System.out.print("Enter Menu Item : ");
            String keyword = sc.nextLine();

            String menuQuery =
                    "SELECT * FROM menu WHERE item_name LIKE ?";

            PreparedStatement ps2 = con.prepareStatement(menuQuery);

            ps2.setString(1, "%" + keyword + "%");

            ResultSet rs3 = ps2.executeQuery();

            System.out.println("\nMenu Items:");

            while (rs3.next()) {

                System.out.println("ID    : " + rs3.getInt("item_id"));
                System.out.println("Item  : " + rs3.getString("item_name"));
                System.out.println("Price : " + rs3.getDouble("price"));
                System.out.println("----------------------");

            }

            con.close();

        } catch (Exception e) {
            System.out.println(e);
        }

        sc.close();
    }
}
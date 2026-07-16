package jdbc_mini_project5;

import java.sql.*;
import java.util.Scanner;

public class ExpenseController {

    static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void addExpense(int userId) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Amount : ");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter Date (YYYY-MM-DD): ");
        String date = sc.nextLine();

        System.out.print("Enter Category ID : ");
        int categoryId = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Description : ");
        String description = sc.nextLine();

        String sql = "INSERT INTO expenses(user_id,amount,expense_date,category_id,description) VALUES(?,?,?,?,?)";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setDouble(2, amount);
            ps.setString(3, date);
            ps.setInt(4, categoryId);
            ps.setString(5, description);

            int rows = ps.executeUpdate();

            if (rows > 0) {
                System.out.println("Expense Added Successfully.");
            }

        } catch (Exception e) {
            System.out.println("Database Error : " + e.getMessage());
        }
    }
}
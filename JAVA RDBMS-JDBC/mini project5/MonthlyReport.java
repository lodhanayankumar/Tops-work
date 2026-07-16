package jdbc_mini_project5;

import java.sql.*;
import java.util.Scanner;

public class MonthlyReport {

    static final String URL = "jdbc:mysql://localhost:3306/expense_tracker";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void report() {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter User ID : ");
        int userId = sc.nextInt();

        System.out.print("Enter Month (1-12): ");
        int month = sc.nextInt();

        String sql =
        "SELECT s.name, SUM(e.amount) AS Total " +
        "FROM expenses e " +
        "JOIN SpendingCategory s ON e.category_id=s.id " +
        "WHERE e.user_id=? AND MONTH(e.expense_date)=? " +
        "GROUP BY s.name";

        try (
                Connection con = DriverManager.getConnection(URL, USER, PASSWORD);
                PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, userId);
            ps.setInt(2, month);

            ResultSet rs = ps.executeQuery();

            System.out.println("-------------------------------------");
            System.out.printf("%-20s %-10s%n","Category","Total");
            System.out.println("-------------------------------------");

            while(rs.next()){

                System.out.printf("%-20s %.2f%n",
                        rs.getString("name"),
                        rs.getDouble("Total"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
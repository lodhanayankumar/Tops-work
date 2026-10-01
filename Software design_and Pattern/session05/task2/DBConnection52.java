package session05;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection52 {

    private static final String URL ="jdbc:mysql://localhost:3306/songdb";
    private static final String USER = "root";
    private static final String PASSWORD = "Nayan001";

    public static Connection getConnection() {

        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection( URL, USER, PASSWORD);
            System.out.println("Database Connected Successfully");
        } catch (Exception e) {
           e.printStackTrace();
        }
        return con;
    }
}
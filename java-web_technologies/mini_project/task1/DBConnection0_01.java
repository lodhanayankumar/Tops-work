package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection0_01 {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }
}
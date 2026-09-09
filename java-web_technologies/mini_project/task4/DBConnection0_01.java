package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection0_01 {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/Eventlist03";
        String username = "root";
        String password = "Nayan@2001";

        return DriverManager.getConnection(url, username, password);
    }
}

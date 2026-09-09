package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection02 {

    private static final String url ="jdbc:mysql://localhost:3306/restaurant_db";
    private static final String user = "root";
    private static final String pass = "root";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url,user,pass);
    }
}
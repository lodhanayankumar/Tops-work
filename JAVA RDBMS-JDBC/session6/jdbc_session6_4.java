/*4.Write a Java snippet that connects to your database and uses DatabaseMetaData to list all table names in your 
 * current schema, similar to how Zomato might list all restaurant tables in its backend.
 */
package jdbc_session6;
 
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;

public class jdbc_session6_4 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            // Get DatabaseMetaData
            DatabaseMetaData dbMetaData = con.getMetaData();

            // Get all table names
            ResultSet rs = dbMetaData.getTables(null, null, "%", new String[]{"TABLE"});

            System.out.println("Tables in shopping_db");
            System.out.println("---------------------------");

            while (rs.next()) {
                System.out.println(rs.getString("TABLE_NAME"));
            }

            rs.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

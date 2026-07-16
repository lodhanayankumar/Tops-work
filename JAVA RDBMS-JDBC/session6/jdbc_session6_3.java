/*3.Use ResultSetMetaData in a Java program to print the column names and data types for a 'products' table 
 * (imagine Flipkart product listings) after executing a SELECT * query
 */
package jdbc_session6;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;

public class jdbc_session6_3 {

    static final String URL = "jdbc:mysql://localhost:3306/shopping_db";
    static final String USER = "root";
    static final String PASSWORD = "Nayan@2001";

    public static void main(String[] args) {

        String sql = "SELECT * FROM products";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            // Get ResultSetMetaData
            ResultSetMetaData metaData = rs.getMetaData();

            int columnCount = metaData.getColumnCount();

            System.out.println("Products Table Metadata");
            System.out.println("--------------------------------------");

            for (int i = 1; i <= columnCount; i++) {
                System.out.println("Column Name : " + metaData.getColumnName(i));
                System.out.println("Data Type   : " + metaData.getColumnTypeName(i));
                System.out.println("--------------------------------------");
            }

            rs.close();
            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
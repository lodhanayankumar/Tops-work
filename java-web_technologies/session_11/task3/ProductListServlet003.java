/*3.Modify your ProductListServlet to handle SQL exceptions and display a user-friendly error message on the JSP page if the database connection fails
.<br><br><em><strong>Hint:</strong> Use request.setAttribute to pass error messages to the JSP.</em>
*/
package a12;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean12.Product00;

@WebServlet("/ProductListServlet003")
public class ProductListServlet003  extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product00> products = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/productdb", "root", "Nayan@2001");

            String sql = "SELECT id, name, price FROM products";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Product00 p = new Product00();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));

                products.add(p);
            }

            rs.close();
            ps.close();
            con.close();

            request.setAttribute("products", products);

            RequestDispatcher rd = request.getRequestDispatcher("products003.jsp");
            rd.forward(request, response);

        } catch (Exception e) {

            request.setAttribute( "errorMessage", "Sorry, we could not load the products. Please try again later." );
            RequestDispatcher rd = request.getRequestDispatcher("products003.jsp");

            rd.forward(request, response);
        }
    }
}


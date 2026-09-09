/*2.Build a LoginServlet that authenticates users by checking their username and password against 
 * the users table in the database, then redirects to a Home.jsp page if successful.<br><br><em>
 * <strong>Hint:</strong> Use JDBC to query the database and HttpSession to store login state.</em>
 */

package servle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dbc.DBConnection0_01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/LoginServlet0_02")
public class LoginServlet0_02 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        String sql = "SELECT * FROM users WHERE username = ? AND password = ?";

        try {
            Connection con = DBConnection0_01.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                HttpSession session = request.getSession();
                session.setAttribute("username", username);
                response.sendRedirect("Home0_02.jsp");
            } else {
                response.getWriter().println("Invalid username or password!");
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}

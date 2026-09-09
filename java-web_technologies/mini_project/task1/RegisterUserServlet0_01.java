/*1.Create a simple web form named RegisterUser.jsp for new users to sign up with fields: username, 
 * email, and password. On submit, post the data to a RegisterUserServlet that saves the user info 
 * into a database table called users.
 */

package servle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBConnection0_01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/RegisterUserServlet0_01")
public class RegisterUserServlet0_01 extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String sql = "INSERT INTO users(username, email, password) VALUES (?, ?, ?)";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, username);
            ps.setString(2, email);
            ps.setString(3, password);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println("User registered successfully!");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Registration failed!");
        }
    }
}

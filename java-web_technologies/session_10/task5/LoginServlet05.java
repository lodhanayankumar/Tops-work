/*5.Modify your login servlet so that if login fails (wrong username or password), 
 * it forwards to login.jsp and displays 'Invalid Credentials' in bold red text above 
 * the form.<br><br><em><strong>Constraint:</strong> Do not reload the entire page;
 *  use request attributes to pass the error message.</em>
 */

package servlet02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/LoginServlet05")
public class LoginServlet05 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if ("admin".equals(username) && "123456".equals(password)) {
            response.sendRedirect("home05.jsp");
        } else {
            request.setAttribute("errorMessage", "Invalid Credentials");

            RequestDispatcher rd = request.getRequestDispatcher("login05.jsp");
            rd.forward(request, response);
        }
    }
}

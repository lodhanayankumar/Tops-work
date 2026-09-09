/*4.Create a servlet called InstaRedirectServlet that always redirects the user to a trending page (TrendingServlet) using response.
 * sendRedirect(), but before redirecting, set the HTTP status code to 302 and log the redirection in the server console.<br><br><em><strong>
 * Hint:</strong> Use response.setStatus(302) before calling sendRedirect().</em>
 */

package test12;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/instaRedirect")
public class InstaRedirectServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setStatus(302);
        System.out.println("Redirecting user to TrendingServlet...");

        response.sendRedirect("trendin_g");
    }
}
/*2.Implement a 'Remember Me' feature using cookies: when the user checks a 'Remember Me' box during login, store their 
 * username in a cookie and auto-fill it the next time they visit the login page.<br><br><em><strong>Hint:</strong> 
 * Use response.addCookie() and request.getCookies() to manage cookies in your servlet.</em>
 */

package login1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/rememberMe302")
public class remembermeservlet302 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        String rememberMe = request.getParameter("rememberMe");

        if ("yes".equals(rememberMe)) {

            Cookie cookie = new Cookie("username", username);
            cookie.setMaxAge(7*24*60 *60);
            response.addCookie(cookie);
        }

        PrintWriter out = response.getWriter();
        
        out.println("Welcome, " + username + "!");
        out.println("Login successful.");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String savedUsername = "";

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if ("username".equals(cookie.getName())) {
                    savedUsername = cookie.getValue();
                    break;
                }
            }
        }
    }
}


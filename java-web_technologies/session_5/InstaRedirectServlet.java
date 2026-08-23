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
/*Trendingservlet.java

package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/trendin_g")
public class TrendingServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("Trending Page");
        out.println("Welcome to the Trending Page!");
    }
}*/

/*instatrand.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Instagram Style Page</h1>
    <form action="instaRedirect" method="get">
        <input type="submit" value="View Trending">
    </form>
</body>
</html>*/
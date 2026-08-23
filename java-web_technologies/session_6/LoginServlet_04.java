package test13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/login_04")
public class LoginServlet_04 extends HttpServlet {

    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");
        String password = request.getParameter("password");

        if (username.equals("admin") && password.equals("1234")) {
            HttpSession session = request.getSession();
            session.setAttribute("username", username);
            response.sendRedirect("Deshboard_04.jsp");
        } else {
            out.println("Invalid Username or Password");
            out.println("<a href='login_04.html'>Try Again</a>");
        }
    }
}

/*LogoutServlet_04
 * package test13;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/logout_04")
public class LogoutServlet_04 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession(false);

        if (session != null) {
            session.invalidate();
        }
       response.sendRedirect("login_04.html");
    }
}
 */

/*login_04.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Movie Login</h1>
    <form action="login_04" method="post">
        Username:<input type="text" name="username" ><br>
        Password:<input type="password" name="password" ><br>
        <input type="submit" value="Login">
    </form>
</body>
</html>*/
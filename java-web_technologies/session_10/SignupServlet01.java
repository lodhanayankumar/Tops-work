/*2.In your servlet, perform server-side validation for the signup form: check that no field is empty, the password is at least 6 characters, 
and the email contains '@' and ends with '.com'. If any check fails, forward back to signup.jsp with an error message.
*/
package servlet02;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SignupServlet01")
public class SignupServlet01 extends HttpServlet {

   protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        String username = request.getParameter("username");
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        String error = "";
        if (username == null || username.trim().isEmpty()) {
            error = "Username cannot be empty.";
        }
        else if (email == null || email.trim().isEmpty()) {
            error = "Email cannot be empty.";
        }
        else if (password == null || password.trim().isEmpty()) {
            error = "Password cannot be empty.";
        }
        else if (password.length() < 6) {
            error = "Password must be at least 6 characters.";
        }
        else if (!email.contains("@") || !email.endsWith(".com")) {
            error = "Email must contain '@' and end with '.com'.";
        }

// if fails
        if (!error.isEmpty()) {
            request.setAttribute("error", error);
            RequestDispatcher rd =
                    request.getRequestDispatcher("signup01.jsp");
            rd.forward(request, response);
            return;
        }
        response.getWriter().println("Signup Successful");
        response.getWriter().println("Username: "+ username);
        response.getWriter().println("Email: "+email);
    }
}


/*signup01.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Signup Form</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p style="color:red;"><%= error %></p>
<% }%>
<form action="SignupServlet01" method="post">
    Username:<input type="text" name="username"><br>
    Email:<input type="email" name="email"><br>
    Password:<input type="password" name="password"><br>
    <input type="submit" value="Signup">
</form>
</body>
</html>*/

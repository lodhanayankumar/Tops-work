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
import jakarta.servlet.http.HttpSession;

@WebServlet("/EventPostServlet0_03")
public class EventPostServlet0_03 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("Login0_02.jsp");
            return;
        }

        String title = request.getParameter("title");
        String eventDate = request.getParameter("event_date");
        String description = request.getParameter("description");

        String sql = "INSERT INTO events(title, event_date, description, username) "+ "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, eventDate);
            ps.setString(3, description);
            ps.setString(4, username);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println("Event posted successfully!");
            } else {
                response.getWriter().println("Event could not be posted.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}

/*EventPost0_03.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Post Event</title>
</head>
<body>
<h2>Post New Event</h2>
<%
    String username = (String) session.getAttribute("username");

    if (username == null) {
        response.sendRedirect("Login0_02.jsp");
        return;
    }
%>
<p>Logged in as: <strong><%= username %></strong></p>
<form action="EventPostServlet0_03" method="post">
    Event Title:<input type="text" name="title"><br>
    Event Date:<input type="date" name="event_date"><br>
    Description:<textarea name="description" rows="5" cols="40"></textarea>
    <br>
    <input type="submit" value="Post Event">
</form>
</body>
</html>*/
/*DBConnection0_01.java
package dbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection0_01 {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/test1";
        String username = "root";
        String password = "root";

        return DriverManager.getConnection(url, username, password);
    }
}*/
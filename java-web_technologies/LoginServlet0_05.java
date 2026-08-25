/*5.Refactor your servlets and JSPs to follow the MVC pattern clearly: controllers (Servlets), 
 * models (JavaBeans), and views (JSPs). Briefly comment each file to indicate its role in MVC.
 */

package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/LoginServlet0_05")
public class LoginServlet0_05 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {

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
                response.sendRedirect("Home0_05.jsp");
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

/*Event0_05.java
package model1;


public class Event0_05 {

    private int id;
    private String title;
    private String eventDate;
    private String description;
    private String username;

    public Event0_05() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEventDate() {
        return eventDate;
    }

    public void setEventDate(String eventDate) {
        this.eventDate = eventDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}*/


/*DBConnection0_01.java
 * package servlet;


import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection0_01 {

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        String url = "jdbc:mysql://localhost:3306/event_db";
        String username = "root";
        String password = "Nayan@2001";

        return DriverManager.getConnection(url, username, password);
    }
}*/

/*EventListServlet0_05.java
 * package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import model1.Event0_05;


@WebServlet("/EventListServlet0_05")
public class EventListServlet0_05 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Event0_05> eventList = new ArrayList<>();

        String sql = "SELECT * FROM events ORDER BY event_date";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Event0_05 event = new Event0_05();

                event.setId(rs.getInt("id"));
                event.setTitle(rs.getString("title"));
                event.setEventDate(rs.getString("event_date"));
                event.setDescription(rs.getString("description"));
                event.setUsername(rs.getString("username"));

                eventList.add(event);
            }

            // Send the model data to the View
            request.setAttribute("eventList", eventList);

            rs.close();
            ps.close();
            con.close();

            // Forward request to JSP View
            request.getRequestDispatcher("EventsList0_05.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}*/

/*EventPostServlet0_05.java
 * package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import servlet.DBConnection0_01;


@WebServlet("/EventPostServlet0_05")
public class EventPostServlet0_05 extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                           HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession session = request.getSession();

        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("Login0_02.jsp");
            return;
        }

        String title = request.getParameter("title");
        String eventDate = request.getParameter("event_date");
        String description = request.getParameter("description");

        String sql = "INSERT INTO events(title, event_date, description, username) "
                   + "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, eventDate);
            ps.setString(3, description);
            ps.setString(4, username);

            ps.executeUpdate();

            ps.close();
            con.close();

            response.sendRedirect("EventListServlet0_05");
        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}*/

/*EventPost0_05.jsp
 * <%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Post Event</title>
</head>
<body>

    <%
        String username = (String) session.getAttribute("username");
        if (username == null) {
            response.sendRedirect("Login0_02.jsp");
            return;
     }
    %>
    <h2>Post New Event</h2>
    <p>Logged in as: <strong><%= username %></strong></p>
    <form action="EventPostServlet0_05" method="post">
        Event Title:
        <input type="text" name="title"><br>
        Event Date:<input type="date" name="event_date"><br>
        Description:<textarea name="description"
                  rows="5"
                  cols="40"></textarea>
        <br>
        <input type="submit" value="Post Event">
    </form>
</body>
</html>*/


/*EventList0_05.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model1.Event0_05" %>

<!DOCTYPE html>
<html>
<head>
</head>
<body>
<h2>All Events</h2>

<%
    List<Event0_05> eventList =
        (List<Event0_05>) request.getAttribute("eventList");
%>

<%
    if (eventList != null && !eventList.isEmpty()) {
%>
<table>
    <tr>
        <th>ID</th>
        <th>Title</th>
        <th>Date</th>
        <th>Description</th>
        <th>Posted By</th>
    </tr>
    <%
        for (Event0_05 event : eventList) {
    %>
    <tr>
        <td><%= event.getId() %></td>
        <td><%= event.getTitle() %></td>
        <td><%= event.getEventDate() %></td>
        <td><%= event.getDescription() %></td>
        <td><%= event.getUsername() %></td>
    </tr>
    <%
        }
    %>
</table>
<%
    } else {
%>
    <p>No events found.</p>
<% } %>
</body>
</html>*/
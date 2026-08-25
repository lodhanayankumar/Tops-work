/*4.Display a dynamic list of all events on EventsList.jsp by fetching event data from the events table 
 * in your database and passing it from an EventListServlet to the JSP using request attributes
 * .<br><br><em><strong>Constraint:</strong> Use a JavaBean class named Event to represent each 
 * event in your list.</em>
 */

package servle;

public class Event0_04 {

    private int id;
    private String title;
    private String eventDate;
    private String description;
    private String username;

    public Event0_04() {
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
}

/*EventListServlet0_04.jsp
 * package servle;

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

import bean.Event0_04;
import dbc.DBConnection0_01;

@WebServlet("/EventListServlet0_04")
public class EventListServlet0_04 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Event0_04> eventList = new ArrayList<>();

        String sql = "SELECT * FROM events ORDER BY event_date";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Event0_04 event = new Event0_04();

                event.setId(rs.getInt("id"));
                event.setTitle(rs.getString("title"));
                event.setEventDate(rs.getString("event_date"));
                event.setDescription(rs.getString("description"));
                event.setUsername(rs.getString("username"));

                eventList.add(event);
            }

            request.setAttribute("eventList", eventList);

            rs.close();
            ps.close();
            con.close();

            request.getRequestDispatcher("EventsList0_04.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}
 * 
 */

/*EventList0_04.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="servle.Event0_04" %>

<!DOCTYPE html>
<html>
<head>
</head>

<body>

<h2>All Events</h2>

<%
    List<Event0_04> eventList =
        (List<Event0_04>) request.getAttribute("eventList");
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
        for (Event0_04 event : eventList) {
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
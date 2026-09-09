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
</html>
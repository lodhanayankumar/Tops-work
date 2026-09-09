<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page import="java.util.List"%>
<%@ page import="bean12.Product00"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<style>
    table {
        border-collapse: collapse;
        width: 600px;
    }
    th, td {
        border: 1px solid black;
        padding: 10px;
        text-align: left;
    }
    th {
        background-color: lightgray;
    }

    .error {
        color: red;
        font-weight: bold;
    }
</style>

</head>

<body>

<h2>Product List</h2>

<%
    String errorMessage =
        (String) request.getAttribute("errorMessage");

    if (errorMessage != null) {
%>

    <p class="error">
        <%= errorMessage %>
    </p>

<%
    }
%>

<%
    List<Product00> products =
        (List<Product00>) request.getAttribute("products");
%>
<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
    </tr>
<%
    if (products != null) {
        for (Product00 p : products) {
%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td>₹<%= p.getPrice() %></td>
    </tr>
<%
        }
    } %>
</table>
</body>
</html>
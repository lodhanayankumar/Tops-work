<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="model.Product004"%>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Flipkart Product List</title>
</head>
<body>
<h2>Product List</h2>
<%
    String error = (String) request.getAttribute("error");
    if (error != null) {
%>
    <p class="error"><%= error %></p>
<%
    }
    List<Product004> products =
        (List<Product004>) request.getAttribute("products");
    if (products != null) {
%>
<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
<%
        for (Product004 p : products) {
%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td>₹ <%= p.getPrice() %></td>
    </tr>
<%}%>
</table>
<%
    }
%>
</body>
</html>
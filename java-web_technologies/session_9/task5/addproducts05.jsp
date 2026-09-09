<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="bean1.Product01" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registered Products</title>
</head>
<body>
<h2>Registered Products</h2>

<%
    List<Product01> productList =
        (List<Product01>) session.getAttribute("productList");

    if (productList != null && !productList.isEmpty()) {
%>
<table border="1" cellpadding="10">
    <tr>
        <th>No.</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
<%
    int count = 1;
    for (Product01 product : productList) {%>
    <tr>
        <td><%= count++ %></td>
        <td><%= product.getName() %></td>
        <td><%= product.getPrice() %></td>
    </tr>
<% }%>
</table>
<% } else {%>
<p>No products registered yet.</p>
<%}%>
</body>
</html>
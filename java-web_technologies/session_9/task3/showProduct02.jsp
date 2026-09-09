<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="bean02.Product0_2" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product Details</h2>
<%
    Product0_2 product = (Product0_2) session.getAttribute("product"); %>
<table border="1" cellpadding="10">
    <tr>
        <th>Name</th>
        <td><%= product.getName() %></td>
    </tr>

    <tr>
        <th>Price</th>
        <td><%= product.getPrice() %></td>
    </tr>

    <tr>
        <th>Category</th>
        <td><%= product.getCategory() %></td>
    </tr>
</table>
</body></html>
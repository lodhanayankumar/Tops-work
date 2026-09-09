<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List"%>
<%@ page import="bean12.Product00"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head><style>
        body {
            font-family: Arial;
            margin: 40px;
        }
        input {
            padding: 8px;
            width: 250px;
        }
        button {
            padding: 8px 15px;
        }
        table {
            border-collapse: collapse;
            width: 600px;
            margin-top: 20px;
        }
        th, td {
            border: 1px solid black;
            padding: 10px;
        }
        th {
            background-color: #eeeeee;
        }
        .error {
            color: red;
        }
    </style>
</head>
<body>
<h2>Product List</h2>
<form action="ProductListServlet004" method="get">
    <input type="text"
           name="name"
           placeholder="Search product name">
    <button type="submit">Search</button>
</form>
<%
    String error = (String) request.getAttribute("error");

    if (error != null) {
%>
    <p class="error"><%= error %></p>
<%
    }
%>
<table>
    <tr>
        <th>ID</th>
        <th>Product Name</th>
        <th>Price</th>
    </tr>
<%
    List<Product00> products =
        (List<Product00>) request.getAttribute("products");

    if (products != null && !products.isEmpty()) {

        for (Product00 p : products) {
%>
    <tr>
        <td><%= p.getId() %></td>
        <td><%= p.getName() %></td>
        <td><%= p.getPrice() %></td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="3">No products found.</td>
    </tr>
<%
    }
%>
</table>
</body>
</html>
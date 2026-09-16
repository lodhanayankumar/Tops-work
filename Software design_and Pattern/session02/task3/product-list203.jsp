<%@ page language="java"
    contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="model203.Product203" %>

<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Product List 203</title>
    <style>
        body {
            font-family: Arial;
            background-color: #f5f5f5;
            padding: 30px;
        }
        h1 {
            text-align: center;
        }
        table {
            width: 80%;
            margin: 30px auto;
            border-collapse: collapse;
            background-color: white;
        }
        th {
            background-color: orange;
            color: white;
            padding: 15px;
        }
        td {
            padding: 15px;
            text-align: center;
            border: 1px solid #ddd;
        }
        .price {
            color: green;
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Product List</h1>
    <table>
        <tr>
            <th>Product ID</th>
            <th>Product Name</th>
            <th>Price</th>
        </tr>

        <%
            List<Product203> products =
                (List<Product203>) request.getAttribute("products");

            if (products != null && !products.isEmpty()) {

                for (Product203 p : products) {
        %>

        <tr>
            <td><%= p.getId() %></td>

            <td><%= p.getName() %></td>

            <td class="price">
                ₹<%= p.getPrice() %>
            </td>
        </tr>

        <%
                }
            } else {
        %>

        <tr>
            <td colspan="3">No products available</td>
        </tr>

        <%
            }
        %>

    </table>
</body>
</html>
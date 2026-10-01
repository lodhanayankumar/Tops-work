<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!DOCTYPE html>
<html>
<head>

    <meta charset="UTF-8">

    <title>My Orders</title>

    <style>

        body {
            font-family: Arial;
            margin: 40px;
        }

        h1 {
            color: #2874f0;
        }

        table {
            width: 80%;
            border-collapse: collapse;
        }

        th, td {
            border: 1px solid #ddd;
            padding: 12px;
            text-align: left;
        }

        th {
            background-color: #2874f0;
            color: white;
        }

        tr:hover {
            background-color: #f5f5f5;
        }

    </style>

</head>

<body>

    <h1>My Orders</h1>

    <table>

        <tr>
            <th>Order ID</th>
            <th>Product Name</th>
            <th>Status</th>
        </tr>

        <c:forEach var="order" items="${orders}">

            <tr>

                <td>${order.orderId}</td>

                <td>${order.productName}</td>

                <td>${order.status}</td>

            </tr>

        </c:forEach>

    </table>

</body>
</html>
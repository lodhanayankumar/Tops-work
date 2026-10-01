<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Orders</title>
</head>
<body>
    <%@ include file="sidebar.jsp" %>
    <div class="content">
        <h1>Orders</h1>

        <table border="1" cellpadding="10">

            <tr>
                <th>Order ID</th>
                <th>Customer</th>
                <th>Amount</th>
            </tr>

            <tr>
                <td>101</td>
                <td>Nayan</td>
                <td>₹500</td>
            </tr>

            <tr>
                <td>102</td>
                <td>Rahul</td>
                <td>₹750</td>
            </tr>

        </table>

    </div>

</body>
</html>
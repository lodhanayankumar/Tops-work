/*4.Configure a custom error page error404.jsp in your web.xml to display a friendly message and a link back to 
 * the homepage whenever a user enters an invalid URL.<br><br><em><strong>Hint:</strong> Use the <error-page> 
 * tag in web.xml and test by visiting a non-existent page.</em>
 */

package a12;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean12.Product00;

@WebServlet("/ProductListServlet004")
public class ProductListServlet004 extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/test1";
    private static final String user = "root";
    private static final String pass = "Nayan@2001";

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        List<Product00> products = new ArrayList<>();
        String name = request.getParameter("name");
        String sql;
        if (name != null && !name.trim().isEmpty()) {
            sql = "SELECT * FROM products " + "WHERE LOWER(name) LIKE LOWER(?)";
        } else {
            sql = "SELECT * FROM products";
        }
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con = DriverManager.getConnection (url,user,pass);
            PreparedStatement ps = con.prepareStatement(sql);

            if (name != null && !name.trim().isEmpty()) {
                ps.setString(1, "%" + name.trim() + "%");
            }
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Product00 p = new Product00();

                p.setId(rs.getInt("id"));
                p.setName(rs.getString("name"));
                p.setPrice(rs.getDouble("price"));

                products.add(p);
            }

            rs.close();
            ps.close();
            con.close();

            request.setAttribute("products", products);
            request.getRequestDispatcher("products004.jsp").forward(request, response);
        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error"," try again.");
            request.getRequestDispatcher("product004.jsp")
                   .forward(request, response);
        }
    }
}

/*Product004.jsp
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
</html>*/
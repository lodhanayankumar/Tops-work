/*2.Create a JSP page called products.jsp that receives a list of Product objects from the servlet and displays 
 * them in a table with columns for ID, Name, and Price.
 */

package a12;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean12.Product00;

@WebServlet("/ProductListServlet")
public class ProductListServlet extends HttpServlet {

    private static final String url = "jdbc:mysql://localhost:3306/productdb";
    private static final String user = "root";
    private static final String pass = "Nayan@2001";

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Product00> products = new ArrayList<>();

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection con = DriverManager.getConnection(url, user, pass);

            String sql = "SELECT id, name, price FROM products";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                int id = rs.getInt("id");
                String name = rs.getString("name");
                double price = rs.getDouble("price");

                Product00 p = new Product00();

                p.setId(id);
                p.setName(name);
                p.setPrice(price);

                products.add(p);
            }

            rs.close();
            ps.close();
            con.close();

            request.setAttribute("products", products);

            RequestDispatcher rd =
                    request.getRequestDispatcher("products.jsp");

            rd.forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database Error: " + e.getMessage());
        }
    }
}

/*Product00.java
 * package bean12;

public class Product00 {

    private int id;
    private String name;
    private double price;

    public Product00() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
 */


/*products.jsp
<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>
<%@ page import="bean12.Product00" %>
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
        background-color: lightgray; }
</style>
</head>
<body>
<h2>Product List</h2>
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
</html>*/
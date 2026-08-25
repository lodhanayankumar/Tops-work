/*4.Refactor an existing Servlet+JSP codebase for a Flipkart-style product listing so that it 
 * follows the MVC pattern: separate the data access (Model), request handling (Controller), 
 * and display (View) into different Java classes and JSP files.<br><br><em><strong>
 * Hint:</strong> Your Controller should not contain any HTML code.</em>
 */

package a13;

import java.io.IOException;

import java.util.List;

import model.Product004;
import dao.ProductDAO004;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/ProductListServlet004")
public class ProductListServlet004 extends HttpServlet {

    protected void doGet(HttpServletRequest request,  HttpServletResponse response)  throws ServletException, IOException {

        try {

            ProductDAO004 dao = new ProductDAO004();
            List<Product004> products = dao.getAllProducts();

            request.setAttribute("products", products);
            request.getRequestDispatcher( "products004.jsp").forward(request, response);

        } catch (Exception e) {
            e.printStackTrace();
            request.setAttribute("error","Unable to load products.");

            request.getRequestDispatcher("products004.jsp").forward(request, response);
        }
    }
}

/*DBConnection02.java
package dbconn;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection02 {

    private static final String url ="jdbc:mysql://localhost:3306/test2";
    private static final String user = "root";
    private static final String pass = "root";

    public static Connection getConnection() throws Exception {

        Class.forName("com.mysql.cj.jdbc.Driver");

        return DriverManager.getConnection(url,user,pass);
    }
}*/

/*ProductDao004.java
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import dbconn.DBConnection02;
import model.Product004;

public class ProductDAO004 {

    public List<Product004> getAllProducts()
            throws Exception {

        List<Product004> products = new ArrayList<>();

        String sql = "SELECT * FROM products";
        Connection con = DBConnection02.getConnection();
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        while (rs.next()) {

            Product004 product = new Product004();

            product.setId(rs.getInt("id"));
            product.setName(rs.getString("name"));
            product.setPrice(rs.getDouble("price"));

            products.add(product);
        }

        rs.close();
        ps.close();
        con.close();

        return products;
    }
}*/
/*product004.jsp
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
</html>*/
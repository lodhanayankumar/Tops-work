/*2.Build a simple Product class (Product.java) with properties: name and price. In a JSP page named showProduct.
 * jsp, use <jsp:useBean> to create a Product bean and display its default values.
 */

package test14;

public class Product {

    private String name;
    private double price;

    // Default constructor
    public Product() {
    }

    // Getter for name
    public String getName() {
        return name;
    }

    // Setter for name
    public void setName(String name) {
        this.name = name;
    }

    // Getter for price
    public double getPrice() {
        return price;
    }

    // Setter for price
    public void setPrice(double price) {
        this.price = price;
    }
}

/*showProduct.jsp
 <%@ page language="java" contentType="text/html; charset=UTF-8"
 
pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>Product Details</h2>
<jsp:useBean id="product" class="test14.Product" scope="page" />
<p>Product Name: <%= product.getName() %></p>
<p>Product Price: <%= product.getPrice() %></p>
</body>
</html>*/
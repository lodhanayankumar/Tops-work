package test13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/addToCart")
public class AddToCartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();
        String product = request.getParameter("product");

        if (product != null && !product.isEmpty()) {

            Cookie cartCookie = new Cookie("cartItem", product);
            cartCookie.setMaxAge(10 * 60);
            cartCookie.setPath("/");
           response.addCookie(cartCookie);
        }
        out.println("Shopping Cart");

        if (product != null && !product.isEmpty()) {
            out.println("Added to Cart: " + product);
        } else {
            out.println("No product selected");
        }
        out.println("<br>"+"<a href='cart'>View Cart</a>");

    }
}

/*CartServlet
 * package test13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/cart")
public class CartServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        String cartItem = null;

        Cookie[] cookies = request.getCookies();

        if (cookies != null) {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("cartItem"))
                    cartItem = cookie.getValue();
            }
        }
        out.println("My Cart");
        if (cartItem != null) out.println("Selected Item: " + cartItem );
        else  out.println("Cart is empty");
    }
}
 */

/*Addcart.html
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Shopping App</h1>
    <h2>Select Product</h2>
    <a href="addToCart?product=iPhone"> Add iPhone</a><br>
    <a href="addToCart?product=Laptop">Add Laptop </a><br>
    <a href="addToCart?product=Headphones"> Add Headphones</a><br>
    <a href="cart"> View Cart</a>
</body>
</html>*/
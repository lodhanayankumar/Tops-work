/*1.Create a Java Servlet called AddToCartServlet that uses cookies to remember a user's selected items 
 * for 10 minutes, even if the user navigates away and returns to the site within that time.
 */

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

    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

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

package test13;

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
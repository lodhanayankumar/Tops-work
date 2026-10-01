package se44;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/orders")
public class OrderServlet44 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        List<Order44> orders = new ArrayList<>();

        orders.add(new Order44(101,"samsung mobile", "delivered"));
        orders.add(new Order44(102,"bot speaker", "shipped"));
        orders.add(new Order44(103,"hp laptop", "processing"));
        orders.add(new Order44(104,"nike shoes", "delivered"));

        request.setAttribute("orders", orders);

        request.getRequestDispatcher("Orders44.jsp").forward(request, response);
    }
}
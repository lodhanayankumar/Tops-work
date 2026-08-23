package test11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/welcomeuser")
public class wlcomtest extends HttpServlet {

	@Override
    public void init() throws ServletException {
        System.out.println("init() method is running");
    }

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        System.out.println("service() method is running");

        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("Welcome, User!");
    }

    @Override
    public void destroy() {
        System.out.println("destroy() method is running");
    }
}
package assig_patt_04;


import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/dashboard")
public class dashboardservlet41 extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userName = "Nayan";
        request.setAttribute("userName", userName);

        request.getRequestDispatcher("Dashboard1.jsp")
               .forward(request, response);
    }
}
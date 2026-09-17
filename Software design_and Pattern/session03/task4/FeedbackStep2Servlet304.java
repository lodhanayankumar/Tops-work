package login1;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedbackStep2_304")
public class FeedbackStep2Servlet304 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String name = request.getParameter("name");

        String feedback = request.getParameter("feedback");

        request.setAttribute("name", name);
        request.setAttribute("feedback", feedback);

        request.getRequestDispatcher("thankyou304.jsp")
               .forward(request, response);
    }
}

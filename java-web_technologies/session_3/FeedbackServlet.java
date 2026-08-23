/*4.Implement a FeedbackServlet that overrides the doPost() method, retrieves the user's name, order ID, and feedback 
 * using request.getParameter(), and displays a thank you message with the submitted details.
 */

package test11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/FeedbackServlet")
public class FeedbackServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String orderId = request.getParameter("orderid");
        String feedback = request.getParameter("feedback");

        PrintWriter out = response.getWriter();

        out.println("User Name: " + userName);
        out.println("Order ID: " + orderId);
        out.println("Feedback: " + feedback);
        out.println("Thank You");
    }
}
/*5.Modify your FeedbackServlet to check if any of the form fields are empty and display an error message if so; 
 * otherwise, show the thank you message.<br><br><em><strong>Hint:</strong> Use request.getParameter() and simple 
 * if-else logic to validate the inputs.</em>
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
public class FeedbackServlet1 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userName = request.getParameter("username");
        String orderId = request.getParameter("orderid");
        String feedback = request.getParameter("feedback");

        PrintWriter out = response.getWriter();
        if (userName==null||userName.trim().isEmpty()||orderId==null||orderId.trim().isEmpty()||feedback==null||feedback.trim().isEmpty()) {
            out.println("Error: Please fill in all fields.");

        } else {
            out.println("User Name: " + userName);
            out.println("Order ID: " + orderId);
            out.println("Feedback: " + feedback);
            out.println("Thank You");
        }
    }
}
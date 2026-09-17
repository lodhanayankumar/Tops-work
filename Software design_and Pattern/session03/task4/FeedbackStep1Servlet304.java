/*4.Demonstrate session tracking using hidden form fields: create a two-step feedback form (step 1: 
 * enter name, step 2: enter feedback). Pass the user's name from step 1 to step 2 using a hidden input 
 * field and display both values on the final 'Thank You' page.
 */

package login1;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/feedbackStep1_304")
public class FeedbackStep1Servlet304 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // Get name from Step 1
        String name = request.getParameter("name");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<form action='feedbackStep2_304' method='post'>");
        out.println("<input type='hidden' name='name' value='" + name + "'>");
        out.println("Enter your feedback:  <br><br>");
        out.println("<textarea name='feedback' rows='5' cols='40' required></textarea><br><br>");
        out.println("<input type='submit' value='Submit Feedback'>");
    }
}

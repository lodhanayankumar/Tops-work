/*3.Design an EventPost.jsp page where a logged-in user can submit a new event with title, 
 * date, and description. The form should POST to an EventPostServlet that inserts the event 
 * into an events table in your database.
 */

package servle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;

import dbc.DBConnection0_01;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/EventPostServlet0_03")
public class EventPostServlet0_03 extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");

        if (username == null) {
            response.sendRedirect("Login0_02.jsp");
            return;
        }

        String title = request.getParameter("title");
        String eventDate = request.getParameter("event_date");
        String description = request.getParameter("description");

        String sql = "INSERT INTO events(title, event_date, description, username) "+ "VALUES (?, ?, ?, ?)";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ps.setString(1, title);
            ps.setString(2, eventDate);
            ps.setString(3, description);
            ps.setString(4, username);

            int result = ps.executeUpdate();

            if (result > 0) {
                response.getWriter().println("Event posted successfully!");
            } else {
                response.getWriter().println("Event could not be posted.");
            }

            ps.close();
            con.close();

        } catch (Exception e) {
            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}

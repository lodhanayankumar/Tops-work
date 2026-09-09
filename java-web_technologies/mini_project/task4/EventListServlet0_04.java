package servle;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import bean.Event0_04;
import dbc.DBConnection0_01;

@WebServlet("/EventListServlet0_04")
public class EventListServlet0_04 extends HttpServlet {

    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response)
            throws ServletException, IOException {

        List<Event0_04> eventList = new ArrayList<>();

        String sql = "SELECT * FROM events ORDER BY event_date";

        try {
            Connection con = DBConnection0_01.getConnection();

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Event0_04 event = new Event0_04();

                event.setId(rs.getInt("id"));
                event.setTitle(rs.getString("title"));
                event.setEventDate(rs.getString("event_date"));
                event.setDescription(rs.getString("description"));
                event.setUsername(rs.getString("username"));

                eventList.add(event);
            }

            request.setAttribute("eventList", eventList);

            rs.close();
            ps.close();
            con.close();

            request.getRequestDispatcher("EventsList0_04.jsp")
                   .forward(request, response);

        } catch (Exception e) {

            e.printStackTrace();
            response.getWriter().println("Database error!");
        }
    }
}
package test11;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SongSearchServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String song = request.getParameter("songName");
        String artist = request.getParameter("artist");

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        out.println("<h2>Searching for " + song + " by " + artist + "</h2>");
    }
}
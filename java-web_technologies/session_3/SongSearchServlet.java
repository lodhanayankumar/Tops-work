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

    protected void doGet(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException {

        String song = request.getParameter("songName");
        String artist = request.getParameter("artist");
        
        PrintWriter out = response.getWriter();
        out.println("Searching for " + song + " by " + artist );
    }
}

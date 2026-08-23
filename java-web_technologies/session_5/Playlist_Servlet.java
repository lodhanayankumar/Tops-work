/*2.Build a servlet called PlaylistServlet that receives a request with a playlistId parameter and forwards 
 * the request to a new servlet called PlaylistDetailsServlet using RequestDispatcher.forward(). 
 * In PlaylistDetailsServlet, display the playlistId received
 */

package test12;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/playlis_t")
public class Playlist_Servlet extends HttpServlet {
	
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String playlistId = request.getParameter("playlistId");
        RequestDispatcher rd = request.getRequestDispatcher("/playlistDetails");
        rd.forward(request, response);
    }
}

/*Playlist_Servlet.java
 * package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/playlistDetails")
public class PlaylistDetailsServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();
        String playlistId = request.getParameter("playlistId");
        out.println("Playlist Details");
        out.println("Playlist ID: " + playlistId);
    }
}
 */

/*play_list.HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Playlist Search</h1>
    <form action="playlis_t" method="get">
        Enter Playlist ID:<input type="text" name="playlistId"><br><br>
        <input type="submit" value="View Playlist">
    </form>
</body>
</html>*/
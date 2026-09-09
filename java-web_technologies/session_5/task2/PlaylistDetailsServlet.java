/*2.Build a servlet called PlaylistServlet that receives a request with a playlistId parameter and 
 * forwards the request to a new servlet called PlaylistDetailsServlet using RequestDispatcher.forward().
 *  In PlaylistDetailsServlet, display the playlistId received
 */

package test12;

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
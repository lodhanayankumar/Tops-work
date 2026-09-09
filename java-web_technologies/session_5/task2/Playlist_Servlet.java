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

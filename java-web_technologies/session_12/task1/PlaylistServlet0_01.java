/*1.Create a simple Java Servlet called PlaylistServlet that displays a hardcoded list of your 3 favorite Spotify 
 * playlists when accessed in the browser.
 */

package a13;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/PlaylistServlet0_01")
public class PlaylistServlet0_01 extends HttpServlet {

    protected void doGet(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("My Favorite Spotify Playlists</title>"+"/n");
        out.println("My Favorite Spotify Playlists");
        out.println("Today's Top Hits");
        out.println("RapCaviar");
        out.println("Chill Hits");
  }
}
/*1.Create a servlet called PlaylistServlet that reads a 'defaultGenre' parameter from web.xml using ServletConfig and 
 * displays it as the default playlist genre for a new user.
 */

package test12;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class PlaylistServlet extends HttpServlet {

    private String defaultGenre;
    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        defaultGenre = config.getInitParameter("defaultGenre");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        out.println("Welcome New User");
        out.println("Default Playlist Genre: "+defaultGenre );
    }
}
/*
<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
	<servlet>
    <servlet-name>PlaylistServlet</servlet-name>
    <servlet-class>test12.PlaylistServlet</servlet-class>

    <init-param>
        <param-name>defaultGenre</param-name>
        <param-value>usear1</param-value>
    </init-param>
</servlet>

<servlet-mapping>
    <servlet-name>PlaylistServlet</servlet-name>
    <url-pattern>/playlist11</url-pattern>
</servlet-mapping>
</web-app>
*/
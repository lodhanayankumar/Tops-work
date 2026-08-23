/*2.Add an <context-param> in web.xml for 'appTheme' (e.g., 'dark', 'light') and access this value in a servlet 
 * called ThemeServlet using ServletContext to display the current app theme
 */

package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThemeServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();

        String theme = context.getInitParameter("appTheme");
        out.println("Application Theme");
        out.println("Current App Theme: " + theme);
    }
}


/*<?xml version="1.0" encoding="UTF-8"?>
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

<context-param>
    <param-name>appTheme</param-name>
    <param-value>dark</param-value>
</context-param>

<servlet>
    <servlet-name>ThemeServlet</servlet-name>
    <servlet-class>test12.ThemeServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>ThemeServlet</servlet-name>
    <url-pattern>/theme</url-pattern>
</servlet-mapping>
</web-app>
*/
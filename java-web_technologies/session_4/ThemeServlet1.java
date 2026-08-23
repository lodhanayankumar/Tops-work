/*3.Modify your ThemeServlet to allow switching the theme by updating a request parameter and displaying the new 
 * theme, but always read the default from the context parameter in web.xml.<br><br><em><strong>Hint:</strong> 
 * Use ServletContext to fetch the default, but override it if a 'theme' parameter is present in the request.</em>
 */

package test12;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class ThemeServlet1 extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request,HttpServletResponse response)throws ServletException, IOException {

        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();

        String theme = context.getInitParameter("appTheme");
        String newTheme = request.getParameter("theme");

        if (newTheme != null && !newTheme.isEmpty()) {
            theme = newTheme;
        }
        out.println("Application Theme");
        out.println("Current App Theme: " + theme);
    }
}


/*<?xml version="1.0" encoding="UTF-8"?>
<web-app id="WebApp_ID" version="2.4" xmlns="http://java.sun.com/xml/ns/j2ee" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance" xsi:schemaLocation="http://java.sun.com/xml/ns/j2ee http://java.sun.com/xml/ns/j2ee/web-app_2_4.xsd">
<servlet>
<servlet-name>PlaylistServlet</servlet-name>
<servlet-class>test12.PlaylistServlet1</servlet-class>

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
/*HTML
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h1>Theme Application</h1>
    <form action="theme" method="get">
       Select Theme: <select name="theme">
            <option value="dark">Dark</option>
            <option value="light">Light</option>
            <option value="blue">Blue</option>
        </select><br><br>
        <input type="submit" value="Change Theme">
    </form>
    <a href="theme">Use Default Theme</a>
</body>
</html>*/
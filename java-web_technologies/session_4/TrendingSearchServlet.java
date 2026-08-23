/*4.Build a servlet called TrendingSearchServlet that uses ServletContext to store a shared list of trending 
 * search keywords (like Flipkart's trending products) and displays them on every request.<br><br><em>
 * <strong>Hint:</strong> Use getServletContext().setAttribute() and getAttribute() to maintain the trending list.
 * </em>
 */

package test12;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/trending")
public class TrendingSearchServlet extends HttpServlet {
    
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        ServletContext context = getServletContext();
        List<String> trendingList = (List<String>) context.getAttribute("trendingList");

        if (trendingList == null) {
            
        	trendingList = new ArrayList<String>();

            trendingList.add("iPhone");
            trendingList.add("Laptop");
            trendingList.add("Smart Watch");
            trendingList.add("Headphones");
            trendingList.add("Shoes");
            context.setAttribute("trendingList", trendingList);
        }
        out.println("Trending Searches");
        
        for (String item : trendingList) {
            out.println("-" +item+"/t" );
        }
}
}
/*<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <form action="trending" method="get">
        <input type="submit" value="view Trending searches">
    </form>
</body>
</html>*/
package session05;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/downloadSong53")
public class DownloadSongServlet53 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String fileName = request.getParameter("filename");

        if (fileName == null || fileName.trim().isEmpty()) {

            response.setContentType("text/html");

            response.getWriter().println("<h2>Filename is required.</h2>");
            return;
        }
        String uploadPath =  getServletContext().getRealPath("/uploads");

        File file = new File(uploadPath, fileName);

        if (!file.exists() || !file.isFile()) {
            response.setContentType("text/html");
            response.getWriter().println("<h2>File not found.</h2>");
            return;
        }

        if (!fileName.toLowerCase().endsWith(".mp3")) {

            response.setContentType("text/html");
            response.getWriter().println("<h2>Only MP3 files can be downloaded.</h2>");
            return;
        }

        response.setContentType("audio/mpeg");

        response.setHeader("Content-Disposition", "attachment; filename=\"" + file.getName() + "\"" );//downlod fill and display

        response.setContentLengthLong(file.length());//size

        try (FileInputStream inputStream = new FileInputStream(file);

             OutputStream outputStream = response.getOutputStream()) {

            byte[] buffer = new byte[8192];

            int bytesRead;

            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }

            outputStream.flush();
        }
    }
}
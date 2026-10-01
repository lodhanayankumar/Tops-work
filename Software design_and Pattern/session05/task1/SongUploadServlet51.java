package session05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadSong51")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,      // 1 MB
        maxFileSize = 10 * 1024 * 1024,       // 10 MB
        maxRequestSize = 15 * 1024 * 1024     // 15 MB
)
public class SongUploadServlet51 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request,  HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        Part filePart = request.getPart("song");

        String fileName = filePart.getSubmittedFileName();

        if (fileName == null || fileName.isEmpty()) {

            out.println("<h2>Please select an MP3 file.</h2>");
            return;
        }

        // Check MP3 extension
        if (!fileName.toLowerCase().endsWith(".mp3")) {

            out.println("<h2>Only MP3 files are allowed.</h2>");
            return;
        }

 
        String uploadPath = getServletContext().getRealPath("/uploads");

        // Create uploads folder if it does not exist
        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }

        // Save uploaded MP3 file
        filePart.write(uploadPath + File.separator + fileName);

        // Display success message
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Song Upload</title>");
        out.println("</head>");

        out.println("<body>");

        out.println("<h2>Song Uploaded Successfully!</h2>");

        out.println("<p><b>File Name:</b> "+ fileName + "</p>");

        out.println("<p><b>Saved Location:</b> " + uploadPath + "</p>");

        out.println("<br>");

        out.println("<a href='upload51.jsp'>Upload Another Song</a>");
        out.println("</body>");
        out.println("</html>");
    }
}
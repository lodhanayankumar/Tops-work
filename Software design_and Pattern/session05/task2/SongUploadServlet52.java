package session05;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

@WebServlet("/uploadSong52")
@MultipartConfig(
        fileSizeThreshold = 1024 * 1024,
        maxFileSize = 10 * 1024 * 1024,
        maxRequestSize = 15 * 1024 * 1024
)
public class SongUploadServlet52 extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        String username = request.getParameter("username");

        Part filePart = request.getPart("song");// get uploaded mp3 file

        String originalFileName = filePart.getSubmittedFileName();

        if (username == null || username.trim().isEmpty()) {
            out.println("<h2>Username is required.</h2>");
            return;
        }
        if (originalFileName == null || originalFileName.isEmpty()) {
            out.println("<h2>Please select an MP3 file.</h2>");
            return;
        }
        if (!originalFileName.toLowerCase().endsWith(".mp3")) {

            out.println("<h2>Only MP3 files are allowed.</h2>");
            return;
        }
        String uploadPath = getServletContext().getRealPath("/uploads");

        File uploadDir = new File(uploadPath);

        if (!uploadDir.exists()) {
            uploadDir.mkdirs();
        }
        filePart.write(uploadPath + File.separator + originalFileName);

        String filePath = uploadPath + File.separator + originalFileName;

        String sql = "insert into uploaded_songs " + "(username, original_filename, file_path) " + "values(?, ?, ?)";

        try (
                Connection con = DBConnection52.getConnection();
                PreparedStatement ps = con.prepareStatement(sql)
        ) {
            ps.setString(1, username);
            ps.setString(2, originalFileName);
            ps.setString(3, filePath);
            int result = ps.executeUpdate();

            if (result > 0) {

                out.println("<html>");
                out.println("<head>");
                out.println("<title>Song Upload Success</title>");
                out.println("</head>");

                out.println("<body>");

                out.println("<h2>Song Uploaded Successfully!</h2>");

                out.println("<p><b>Username:</b> "
                        + username + "</p>");

                out.println("<p><b>Original Filename:</b> "
                        + originalFileName + "</p>");

                out.println("<p><b>File Path:</b> "
                        + filePath + "</p>");

                out.println("<p>");
                out.println("File data is stored in the uploads folder.");
                out.println("</p>");

                out.println("<p>");
                out.println("Only the file path is stored in MySQL.");
                out.println("</p>");

                out.println("<br>");

                out.println("<a href='upload52.jsp'>");
                out.println("Upload Another Song");
                out.println("</a>");

                out.println("</body>");
                out.println("</html>");

            } else {

                out.println("<h2>Database insertion failed.</h2>");
            }

        } catch (Exception e) {

            e.printStackTrace();

            out.println("<h2>Database Error</h2>");
            out.println("<p>" + e.getMessage() + "</p>");
        }
    }
}
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

/**
 * @author Oksana Poliakova on 16.07.2023
 * @projectName MavenApache
 */
@WebServlet("/download")
public class DownloadServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // Set the header to specify that the response should be treated as an attachment with the filename "filename.txt"
        resp.setHeader("Content-Disposition", "attachment; filename=\"filename.txt\"");
        // Set the content type of the response to indicate that it is in JSON format
        resp.setContentType("application/json");
        // Set the character encoding of the response to UTF-8
        resp.setCharacterEncoding(StandardCharsets.UTF_8.name());

        // Get the output stream of the response to write the data
        try (var outputStream = resp.getOutputStream();
             // Get the input stream for the "first.json" file, assuming it is located in the classpath
             var stream = DownloadServlet.class.getClassLoader().getResourceAsStream("first.json")) {
            // Write the content of the "first.json" file to the response output stream
            outputStream.write(stream.readAllBytes());
        }
    }
}
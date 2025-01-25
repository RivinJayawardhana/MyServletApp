package src;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/RequestHeaderServlet")
public class RequestHeaderServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        out.println("<html><head><title>Request Headers</title></head><body>");
        out.println("<h2>Request Headers</h2>");
        out.println("<table border='1' cellpadding='5' cellspacing='0'>");
        out.println("<tr><th>Header Name</th><th>Header Values</th></tr>");

        // Get all header names
        Enumeration<String> headerNames = request.getHeaderNames();
        while (headerNames.hasMoreElements()) {
            String headerName = headerNames.nextElement();

            // Get all values for the header
            Enumeration<String> headerValues = request.getHeaders(headerName);
            out.println("<tr>");
            out.println("<td>" + headerName + "</td>");
            out.println("<td>");

            // Display all header values
            while (headerValues.hasMoreElements()) {
                String value = headerValues.nextElement();
                out.println(value + "<br>");
            }
            out.println("</td>");
            out.println("</tr>");
        }

        out.println("</table>");
        out.println("</body></html>");
    }
}

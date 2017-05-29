package by.sergey.servletjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.sergey.servletjsp.utis.TrafficZipUtility;

/**
 * Servlet implementation class CompressedServlet
 */
@WebServlet("/CompressedServlet")
public class CompressedServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public CompressedServlet() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

//        if (TrafficZipUtility.isGzipSupported(request) && !TrafficZipUtility.isGzipDisabled(request)) {
//            out = TrafficZipUtility.getGzipWriter(response);
//            response.setHeader("Content-Encoding", "gzip");
//        } else {
//            out = response.getWriter();
//        }

        String dummyLine = "Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry's standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.";

        out.println("<!Doctype HTML>");
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Demo: Request Headers</title>");
        out.println("</head>");
        out.println("<body>");

        for (int i = 0; i < 10000; i++) {
            out.println(dummyLine + "</br>");
        }

        out.println("</body>");
        out.println("</html>");
        out.close();
    }

}

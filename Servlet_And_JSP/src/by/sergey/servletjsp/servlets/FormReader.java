package by.sergey.servletjsp.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class FormReader
 */
@WebServlet(urlPatterns = { "/ProfileProcessor" }, initParams = {
        @WebInitParam(name = "db_url", value = "oracle_thin:jdbc", description = "oracle connection url") })
public class FormReader extends HttpServlet {
    private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public FormReader() {
        super();
        // TODO Auto-generated constructor stub
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        PrintWriter writer = response.getWriter();

        String parameter = request.getParameter("firstName");
        String parameter2 = request.getParameter("job");

        writer.write("=======getParameter() output========<br>");
        writer.write("Your name is " + parameter + "<br>");
        writer.write("Your job is " + parameter2 + "<br>");
        writer.write("=====================================<br><br>");

        writer.write("=======getParameterValues output========<br>");
        String[] parameterValues = request.getParameterValues("location");
        for (String location : parameterValues)
            writer.write("Your location is " + location + "<br>");
        writer.write("=====================================<br><br><br>");
        
        int contentLength = request.getContentLength();
        writer.write("=======getParameterMap output========<br>");
        Set<String> keySet = request.getParameterMap().keySet();
        Iterator<String> iterator = keySet.iterator();
        while(iterator.hasNext()){
            String key = iterator.next();
            writer.write("Parameter " + key + " has value " + 
                    request.getParameterMap().get(key)[0] + "<br>");
        }
        writer.write("\n=====================================");
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
     *      response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        // TODO Auto-generated method stub
        doGet(request, response);
    }

}

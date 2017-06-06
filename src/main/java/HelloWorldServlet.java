import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

//@WebServlet(name = "HelloWorldServlet", urlPatterns = "/hello")



public class HelloWorldServlet extends HttpServlet {

    int counter = 0;

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
            response.setContentType("text/html");
            PrintWriter out = response.getWriter();
            counter++;
            String aName = request.getParameter("name");

            if(aName != null) {
                    out.printf("<h1>Hello, %s</h1>", aName);

                }

            else {
                out.println("<h1>Hello, World!</h1>");
            }
        out.println("<h2>Page visit count: " + counter + "</hw>");
        }

}

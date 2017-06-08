import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by melodytempleton on 6/8/17.
 */
@WebServlet(name = "LoginServlet", urlPatterns = "/Login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("running servlet");
        String username, password;

        username = request.getParameter("username");
        password = request.getParameter("password");

        ListUsersDao list = new ListUsersDao();

        System.out.println(list.getUserByUsername(username));



    }

}

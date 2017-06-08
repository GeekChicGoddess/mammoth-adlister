import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Created by melodytempleton on 6/7/17.
 */
@WebServlet(name = "UsersServlet", urlPatterns = "/Users")
public class UsersSerlvet extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> users = DaoFactory.getUsersDao().all();
        request.setAttribute("instructors", users);
        request.getRequestDispatcher("/profile.jsp").forward(request, response);

    }
}

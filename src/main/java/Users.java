import java.util.List;
/**
 * Created by melodytempleton on 6/7/17.
 */
public interface  Users {
    List<User> all();
    User getUserById(long id);
    User getUserByEmail(String email);
    User getUserByUsername(String username);
}

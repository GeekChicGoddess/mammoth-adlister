import java.util.ArrayList;
import java.util.List;

/**
 * Created by melodytempleton on 6/7/17.
 */
public class ListUsersDao implements Users{

    List<User> users;

    @Override
    public List<User> all()
    {
        if(users == null){
            users = generateDummyUsers();
        }

        return users;
    }

    @Override
    public User getUserById(long id) {
        return null;
    }

    @Override
    public User getUserByEmail(String email) {
        return null;
    }

    @Override
    public User getUserByUsername(String username){
        int ind = this.users.indexOf(username.contains(username));
        return this.users.get(ind);
    }

    public List<User> generateDummyUsers(){

        List<User> list = new ArrayList<>();

        User fer = new User();
        fer.setId(1);
        fer.setUsername("fernando");
        fer.setEmail("fer@mail.com");
        fer.setPassword("pass");

        list.add(fer);
        list.add(new User(2,"luis","luis@mail.com", "pass"));
        list.add(new User(3,"zach","zach@mail.com", "pass"));

        return list;
    }



}

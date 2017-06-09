import java.util.List;
import java.sql.*;
import java.util.ArrayList;
import com.mysql.cj.jdbc.Driver;

/**
 * Created by melodytempleton on 6/8/17.
 */
public class MySQLAdsDao implements Ads {
    private Connection connection = null;


    public MySQLAdsDao(Config config) throws SQLException {

         connection = DriverManager.getConnection(
                config.getUrl(),
                config.getUser(),
                config.getPassword()
        );


    }

    public List<Ad> all()  {
        Statement statemnt = null;

        try {
            statemnt = connection.createStatement();
            ResultSet resultSet = statemnt.executeQuery("SELECT * FROM ads");
        } catch (SQLException e) {
            e.printStackTrace();
        }




        }

    public Long insert(Ad ad) throws SQLException {
        Statement statemnt = connection.createStatement();
        String title = "'desk'";
        String description = "'very nice desk'";
        long id = 5;
        long userid = 5;

        String query = "INSERT INTO ads(title, description, id, user_id) VALUES";
        query += "(" + title + ", " + description + ", " + id + ", " + userid +")";
        statemnt.execute(query);



    }

}

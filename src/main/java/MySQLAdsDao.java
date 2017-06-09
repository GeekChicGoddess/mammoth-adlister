import com.mysql.jdbc.*;
import com.mysql.jdbc.Driver;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by melodytempleton on 6/8/17.
 */
public class MySQLAdsDao implements Ads {
    private Connection connection = null;

    public MySQLAdsDao(Config config)  {

     try {
         DriverManager.registerDriver(new Driver());
         connection = DriverManager.getConnection(
                 config.getUrl(),
                 config.getUser(),
                 config.getPassword()
         );
     }
     catch (SQLException e) {
         throw new RuntimeException("Error connecting to the database!", e);
     }
    }

    @Override
    public List<Ad> all()  {
        Statement statemnt = null;

        try {
            statemnt = connection.createStatement();
            ResultSet resultSet = statemnt.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(resultSet);

        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving all ads.", e);
        }

        }

    @Override
    public Long insert(Ad ad) {

        try {
            Statement statemnt = connection.createStatement();
            statemnt.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultset = statemnt.getGeneratedKeys();
            resultset.next();
            return resultset.getLong(1);

        } catch (SQLException e) {
            throw new RuntimeException("Error creating a new ad.", e);
        }
    }

    private String createInsertQuery(Ad ad) {
        return "INSERT INTO ads(user_id, title, description) VALUES "
                + "(" + ad.getUserId() + ", "
                + "'" + ad.getTitle() +"', "
                + "'" + ad.getDescription() + "')";
    }



    private Ad extractAd(ResultSet rs) throws SQLException {
        return new Ad(
                rs.getLong("id"),
                rs.getLong("user_id"),
                rs.getString("title"),
                rs.getString("description")
        );
    }


    private List<Ad> createAdsFromResults(ResultSet rs) throws SQLException {
        List<Ad> ads = new ArrayList<>();
        while (rs.next()) {
            ads.add(extractAd(rs));
        }
        return ads;
    }

}

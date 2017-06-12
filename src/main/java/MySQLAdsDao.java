import com.mysql.jdbc.*;
import com.mysql.jdbc.Driver;

import java.util.List;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by melodytempleton on 6/8/17.
 */
public class MySQLAdsDao implements Ads {

    Connection connection = null;

    public MySQLAdsDao(Config config) {

        try {
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to database", e);
        }
    }

    @Override
    public List<Ad> all() {
        Statement statement = null;

        try {
            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ads");
            return createAdsFromResults(resultSet);
        } catch (SQLException e) {
            throw new RuntimeException("Error retrieving ads", e);
        }
    }

    @Override
    public Long insert(Ad ad) {
        Statement statement = null;
        try {
            statement = connection.createStatement();
            statement.executeUpdate(createInsertQuery(ad), Statement.RETURN_GENERATED_KEYS);
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            return resultSet.getLong(1);
        }
    catch(SQLException e){
        throw new RuntimeException("Error creating ad", e);
    }

    }

    private String createInsertQuery(Ad ad){
        return "INSERT INTO ads(user_id, title, description) VALUES"
                + "(" + ad.getUserId() +" ,"
                + "'" + ad.getTitle() + "' ,"
                + "'" + ad.getDescription() + "')";
    }

    private Ad executeAd(ResultSet resultSet) throws SQLException {
        return new Ad(
                resultSet.getLong("id"),
                resultSet.getLong("user_id"),
                resultSet.getString("title"),
                resultSet.getString("description")
        );
    }

    private List<Ad> createAdsFromResults(ResultSet resultSet) throws SQLException {
        List<Ad> ads = new ArrayList<>();

        while (resultSet.next()) {
            ads.add(executeAd(resultSet));
        }
        return ads;
    }

}
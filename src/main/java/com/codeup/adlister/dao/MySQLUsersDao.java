package com.codeup.adlister.dao;

import com.codeup.adlister.models.User;
import com.mysql.cj.jdbc.Driver;

import java.sql.*;

/**
 * Created by melodytempleton on 6/12/17.
 */
public class MySQLUsersDao implements Users {
    Connection connection = null;


    public MySQLUsersDao (Config config){

        try {
            DriverManager.registerDriver(new Driver());
            connection = DriverManager.getConnection(
                    config.getUrl(),
                    config.getUser(),
                    config.getPassword()
            );
        } catch (SQLException e) {
            throw new RuntimeException("Error connecting to databaser", e);
        }
    }

    @Override
    public User findByUsername (String username){
        PreparedStatement statement = null;

        try {
            String SQL = "SELECT * FROM users WHERE username = ?";
            statement = connection.prepareStatement(SQL);
            statement.setString(1, username);
            ResultSet rs = statement.executeQuery();
            rs.next();
            return new User (rs.getLong(1), rs.getString(2), rs.getString(4), rs.getString(3));

        }
        catch (SQLException e) {
            throw new RuntimeException("Error retrieving user", e);
        }
    }

    @Override
    public Long insert (User user){
        PreparedStatement statement = null;
        try {
            String SQL = "INSERT INTO users (username, password, email) VALUES (?, ?, ?)";
            statement = connection.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getEmail());
            statement.executeUpdate();
            ResultSet resultSet = statement.getGeneratedKeys();
            resultSet.next();
            Long ID = resultSet.getLong(1);
            user.setId(ID);
            return ID;
        }
        catch (SQLException e) {
            throw new RuntimeException("Error creating new user", e);
        }
    }


}

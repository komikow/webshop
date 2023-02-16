package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.services.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.SELECT_PRODUCTS;

public class UserRepositoryImpl implements UserRepository {
    List<User> users;

    public User createUser(String firstName, String secondName,
                           int age, String login, String password) {
//        User user = new User(firstName, secondName, age, login, password);
//        users.add(user);
//        return user;
        return null;
    }

    public List<User> readUsers() {
        try (Connection connection = DBConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_PRODUCTS);
            users = new ArrayList<>();
            while (resultSet.next()) {
                User user = new User();
                user.setFirstName(resultSet.getString(2));
                user.setSecondName(resultSet.getString(3));
                user.setAge(resultSet.getInt(4));
                user.setLogin(resultSet.getString(5));
                user.setPassword(resultSet.getString(6));
                users.add(user);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return users;
    }
}

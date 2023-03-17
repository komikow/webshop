package by.it.academy.repositories;

import by.it.academy.entities.User;
import by.it.academy.services.DBConnector;

<<<<<<< HEAD
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
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.*;

public class UserRepositoryImpl implements UserRepository {
    List<User> userList;
    User user;

    public void createUser(String firstName, String secondName,
                           int age, String login, String password) {
        Connection connection;
        PreparedStatement preparedStatement;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName(SQL_DRIVER_NAME);
            int id_credentials = 0;
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CREDENTIALS);
            preparedStatement.setString(PARAMETER_ONE, login);
            preparedStatement.setString(PARAMETER_TWO, password);
            preparedStatement.executeUpdate();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_CREDENTIALS);
            while (resultSet.next()) {
                id_credentials = resultSet.getInt(CREDENTIALS_ID);
            }
            resultSet.close();
            statement.close();
            preparedStatement = connection.prepareStatement(INSERT_USERS);
            preparedStatement.setInt(PARAMETER_ONE, id_credentials);
            preparedStatement.setString(PARAMETER_TWO, firstName);
            preparedStatement.setString(PARAMETER_THREE, secondName);
            preparedStatement.setInt(PARAMETER_FOUR, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void deleteUser(String loginToDelete) {
        PreparedStatement preparedStatement;
        try (Connection connection = DBConnector.getConnection()){
            preparedStatement = connection.prepareStatement(
                    DELETE_USER_FROM_USERS + loginToDelete + BRACKET
            );
            preparedStatement.executeUpdate();
            preparedStatement.close();

            preparedStatement = connection.prepareStatement(
                    DELETE_USER_FROM_CREDENTIALS + loginToDelete + QUOTATION_MARK
            );
            preparedStatement.executeUpdate();
            preparedStatement.close();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
>>>>>>> 3c6d791 (add fixed error code)
    }

    public List<User> readUsers() {
        try (Connection connection = DBConnector.getConnection()) {
            Statement statement = connection.createStatement();
<<<<<<< HEAD
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
=======
            ResultSet resultSet = statement.executeQuery(SELECT_USERS);
            userList = new ArrayList<>();
            while (resultSet.next()) {
                String firstName = resultSet.getString(PARAMETER_TWO);
                String secondName = resultSet.getString(PARAMETER_THREE);
                int age = resultSet.getInt(PARAMETER_FOUR);
                String login = resultSet.getString(PARAMETER_FIVE);
                String password = resultSet.getString(PARAMETER_SIX);
                user = new User(firstName, secondName, age, login, password);
                userList.add(user);
>>>>>>> 3c6d791 (add fixed error code)
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
<<<<<<< HEAD
        return users;
=======
        return userList;
>>>>>>> 3c6d791 (add fixed error code)
    }
}

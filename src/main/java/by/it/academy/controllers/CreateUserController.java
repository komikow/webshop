package by.it.academy.controllers;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static by.it.academy.entities.Constants.*;

@WebServlet(urlPatterns = {USERS_URL_CREATE}, loadOnStartup = 0)
public class CreateUserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter(NAME);
        String surname = req.getParameter(SURNAME);
        int age = Integer.parseInt(req.getParameter(AGE));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
        Connection connection;
        PreparedStatement preparedStatement;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName(SQL_DRIVER_NAME);
            int id_credentials = 0;
            connection = DriverManager.getConnection(SQL_URL, SQL_NAME, SQL_PASSWORD);
            preparedStatement = connection.prepareStatement("INSERT INTO credentials (login, password) VALUES (?, ?)");
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            statement = connection.createStatement();
            resultSet = statement.executeQuery("SELECT * FROM credentials");
            while (resultSet.next()) {
                id_credentials = resultSet.getInt("id_credentials");
            }
            resultSet.close();
            statement.close();
            preparedStatement = connection.prepareStatement("INSERT INTO users (id_credentials, name, surname, age) VALUES (?, ?, ?, ?)");
            preparedStatement.setInt(1, id_credentials);
            preparedStatement.setString(2, name);
            preparedStatement.setString(3, surname);
            preparedStatement.setInt(4, age);
            preparedStatement.executeUpdate();
            preparedStatement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher(PAGES_REGISTRATION_TRUE).forward(req, resp);
    }
}

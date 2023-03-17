package by.it.academy.controllers;

<<<<<<< HEAD
import by.it.academy.services.DBConnector;
=======
>>>>>>> 3c6d791 (add fixed error code)
import by.it.academy.services.UserService;
import by.it.academy.services.UserServiceImpl;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

import static by.it.academy.entities.Constants.*;

//@WebServlet(urlPatterns = {USERS_URL_CREATE}, loadOnStartup = 0)
@WebServlet(urlPatterns = {USERS_URL_CREATE}, loadOnStartup = 0)
public class CreateUserController extends HttpServlet {
    private UserService userService;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter(NAME);
        String secondName = req.getParameter(SURNAME);
        int age = Integer.parseInt(req.getParameter(AGE));
        String login = req.getParameter(LOGIN);
        String password = req.getParameter(PASSWORD);
<<<<<<< HEAD
        Connection connection;
        PreparedStatement preparedStatement;
        Statement statement;
        ResultSet resultSet;
        try {
            Class.forName(SQL_DRIVER_NAME);
            int id_credentials = 0;
            connection = DBConnector.getConnection();
            preparedStatement = connection.prepareStatement(INSERT_CREDENTIALS);
            preparedStatement.setString(1, login);
            preparedStatement.setString(2, password);
            preparedStatement.executeUpdate();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_CREDENTIALS);
            while (resultSet.next()) {
                id_credentials = resultSet.getInt("id_credentials");
            }
            resultSet.close();
            statement.close();
            preparedStatement = connection.prepareStatement(INSERT_USERS);
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
=======
        userService.createUser(firstName, secondName, age, login, password);
>>>>>>> 3c6d791 (add fixed error code)
        req.getRequestDispatcher(PAGES_REGISTRATION_TRUE).forward(req, resp);
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
<<<<<<< HEAD
        userService = (UserServiceImpl) config.getServletContext().getAttribute(SERVICES);
=======
        userService = (UserServiceImpl) config.getServletContext().getAttribute(USER_SERVICE);
>>>>>>> 3c6d791 (add fixed error code)
    }
}

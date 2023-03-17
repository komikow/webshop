package by.it.academy.filters;

import by.it.academy.services.DBConnector;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import static by.it.academy.entities.Constants.*;

<<<<<<< HEAD
//@WebFilter(urlPatterns = {USERS_URL_CREATE})
@WebFilter(urlPatterns = {"/user/*"})
=======
@WebFilter(urlPatterns = {PATH_ALL})
>>>>>>> 3c6d791 (add fixed error code)
public class UniqLoginFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res,
                            FilterChain chain) throws IOException, ServletException {
        String login = req.getParameter(LOGIN);
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String dbLogin = null;
        try {
            Class.forName(SQL_DRIVER_NAME);
            connection = DBConnector.getConnection();
            statement = connection.createStatement();
            resultSet = statement.executeQuery(SELECT_CREDENTIALS);
            while (resultSet.next()) {
                dbLogin = resultSet.getString(LOGIN);
            }
            if (dbLogin.equals(login)) {
                req.getRequestDispatcher(ERRORS_LOGIN)
                        .forward(req, res);
            } else {
                chain.doFilter(req, res);
            }
            resultSet.close();
            statement.close();
            connection.close();
        } catch (ClassNotFoundException | SQLException e) {
            throw new RuntimeException(e);
        }
    }
}

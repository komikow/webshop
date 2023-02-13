package by.it.academy.filters;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

import static by.it.academy.entities.Constants.*;

@WebFilter(urlPatterns = {USERS_URL_INPUT})
public class CredentialsFilter extends HttpFilter {
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String loginForm = req.getParameter(LOGIN);
        String passwordForm = req.getParameter(PASSWORD);
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String dbPassword = null;
        if (loginForm.equals(ADMIN_LOGIN) && passwordForm.equals(ADMIN_PASSWORD)) {
            req.getRequestDispatcher(ADMIN_PAGE)
                    .forward(req, res);
        } else {
            try {
                Class.forName(SQL_DRIVER_NAME);
                connection = DriverManager.getConnection(SQL_URL, SQL_NAME, SQL_PASSWORD);
                statement = connection.createStatement();
                resultSet = statement.executeQuery("SELECT password FROM credentials WHERE login ='" + loginForm + "'");
                while (resultSet.next()) {
                    dbPassword = resultSet.getString(PASSWORD);
                }
                if (dbPassword.equals(passwordForm)) {
                    req.getRequestDispatcher(PRODUCTS_PAGE)
                            .forward(req, res);
                } else {
                    req.getRequestDispatcher(ERRORS_AUTHORIZATION)
                            .forward(req, res);
                }
                resultSet.close();
                statement.close();
                connection.close();
            } catch (ClassNotFoundException | SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
}

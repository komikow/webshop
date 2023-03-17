package by.it.academy.filters;

<<<<<<< HEAD
import by.it.academy.entities.Product;
import by.it.academy.repositories.ProductRepositoryImpl;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;
=======
import by.it.academy.repositories.ProductRepository;
import by.it.academy.repositories.ProductRepositoryImpl;
import by.it.academy.repositories.UserRepository;
import by.it.academy.repositories.UserRepositoryImpl;
import by.it.academy.services.ProductService;
import by.it.academy.services.ProductServiceImpl;
import by.it.academy.services.UserService;
>>>>>>> 3c6d791 (add fixed error code)
import by.it.academy.services.UserServiceImpl;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.*;

@WebFilter(urlPatterns = {USERS_URL_INPUT})
public class CredentialsFilter extends HttpFilter {

    private ProductService productService;
<<<<<<< HEAD
=======
    private ProductRepository productRepository;
    private UserService userService;
    private UserRepository userRepository;

>>>>>>> 3c6d791 (add fixed error code)
    @Override
    protected void doFilter(HttpServletRequest req, HttpServletResponse res, FilterChain chain) throws IOException, ServletException {
        String loginForm = req.getParameter(LOGIN);
        String passwordForm = req.getParameter(PASSWORD);
        Connection connection;
        Statement statement;
        ResultSet resultSet;
        String dbPassword = null;

        if (loginForm.isEmpty() || passwordForm.isEmpty()) {
            req.getRequestDispatcher(ERRORS_AUTHORIZATION)
                    .forward(req, res);
        } else if (loginForm.equals(ADMIN_LOGIN) && passwordForm.equals(ADMIN_PASSWORD)) {
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
                    req.getRequestDispatcher(PRODUCT_URL_READ)
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

    @Override
    public void init(FilterConfig config) throws ServletException {
<<<<<<< HEAD
//        List<Product> products = new ArrayList<>();
        productService = new ProductServiceImpl(new ProductRepositoryImpl());
        config.getServletContext().setAttribute("productService", productService);
=======
        userService = new UserServiceImpl();
        config.getServletContext().setAttribute(USER_SERVICE, userService);
        userRepository = new UserRepositoryImpl();
        config.getServletContext().setAttribute(USER_REPOSITORY, userRepository);
        productService = new ProductServiceImpl(new ProductRepositoryImpl());
        config.getServletContext().setAttribute(PRODUCT_SERVICE, productService);
>>>>>>> 3c6d791 (add fixed error code)
    }
}

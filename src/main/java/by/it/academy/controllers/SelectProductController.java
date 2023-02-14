package by.it.academy.controllers;

import by.it.academy.entities.Product;
import by.it.academy.services.ConnectorDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.*;

@WebServlet(urlPatterns = {PRODUCT_READ}, loadOnStartup = 0)
public class SelectProductController extends HttpServlet {
    private List<Product> products = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Connection connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_DETECTORS);
            while (resultSet.next()) {
                Product product = new Product();
                product.setId((resultSet.getInt(1)));
                product.setBrand((resultSet.getString(2)));
                product.setModel(resultSet.getString(3));
                product.setSpecifications(resultSet.getString(4));
                product.setGuarantee(resultSet.getInt(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));
                products.add(product);
                req.setAttribute("products", products);
            }
            statement.close();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        req.getRequestDispatcher(PRODUCTS_PAGE)
                .forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
    }
}

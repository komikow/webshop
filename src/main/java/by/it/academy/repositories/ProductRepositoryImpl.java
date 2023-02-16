package by.it.academy.repositories;

import by.it.academy.entities.Product;
import by.it.academy.services.DBConnector;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.SELECT_DETECTORS;

public class ProductRepositoryImpl implements ProductRepository{
    List<Product> products;
    @Override
    public Product createProduct(String brand, String model, String specifications,
                                 int guaranteeInMonth, int price, int quantity) {
        return null;
    }

    @Override
    public List<Product> readProduct() {
        try (Connection connection = DBConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_DETECTORS);
            products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getInt(1));
                product.setBrand(resultSet.getString(2));
                product.setModel(resultSet.getString(3));
                product.setSpecifications(resultSet.getString(4));
                product.setGuaranteeInMonths(resultSet.getInt(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));
                products.add(product);
            }
            statement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
}

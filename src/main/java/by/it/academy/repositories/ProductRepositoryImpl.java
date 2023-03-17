package by.it.academy.repositories;

import by.it.academy.entities.Product;
import by.it.academy.services.DBConnector;

<<<<<<< HEAD
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
=======
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static by.it.academy.entities.Constants.*;

public class ProductRepositoryImpl implements ProductRepository {
    private List<Product> products;

    @Override
    public void createProduct(String model, String specifications,
                              int guarantee, int price, int quantity) {
        PreparedStatement preparedStatement;
        try (Connection connection = DBConnector.getConnection()) {
            preparedStatement = connection.prepareStatement(INSERT_DETECTORS);
            preparedStatement.setString(PARAMETER_ONE, model);
            preparedStatement.setString(PARAMETER_TWO, specifications);
            preparedStatement.setInt(PARAMETER_THREE, guarantee);
            preparedStatement.setInt(PARAMETER_FOUR, price);
            preparedStatement.setInt(PARAMETER_FIVE, quantity);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
>>>>>>> 3c6d791 (add fixed error code)
    }

    @Override
    public List<Product> readProduct() {
        try (Connection connection = DBConnector.getConnection()) {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(SELECT_DETECTORS);
            products = new ArrayList<>();
            while (resultSet.next()) {
                Product product = new Product();
<<<<<<< HEAD
                product.setId(resultSet.getInt(1));
                product.setBrand(resultSet.getString(2));
                product.setModel(resultSet.getString(3));
                product.setSpecifications(resultSet.getString(4));
                product.setGuaranteeInMonths(resultSet.getInt(5));
                product.setPrice(resultSet.getInt(6));
                product.setQuantity(resultSet.getInt(7));
=======
                product.setId(resultSet.getInt(PARAMETER_ONE));
                product.setModel(resultSet.getString(PARAMETER_TWO));
                product.setSpecifications(resultSet.getString(PARAMETER_THREE));
                product.setGuarantee(resultSet.getInt(PARAMETER_FOUR));
                product.setPrice(resultSet.getInt(PARAMETER_FIVE));
                product.setQuantity(resultSet.getInt(PARAMETER_SIX));
>>>>>>> 3c6d791 (add fixed error code)
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
<<<<<<< HEAD
=======

    @Override
    public void deleteProduct(String model) {
        PreparedStatement preparedStatement;
        try (Connection connection = DBConnector.getConnection()){
            preparedStatement = connection.prepareStatement(DELETE_PRODUCT +  model + QUOTATION_MARK);
            preparedStatement.executeUpdate();
            preparedStatement.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
>>>>>>> 3c6d791 (add fixed error code)
}

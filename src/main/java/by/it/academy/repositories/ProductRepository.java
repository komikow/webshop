package by.it.academy.repositories;

import by.it.academy.entities.Product;

import java.util.List;

public interface ProductRepository {
<<<<<<< HEAD
    Product createProduct(String brand, String model, String specifications,
                          int guaranteeInMonth, int price, int quantity);

    List<Product> readProduct();
=======
    void createProduct(String model, String specifications,
                       int guarantee, int price, int quantity);

    List<Product> readProduct();

    void deleteProduct(String model);
>>>>>>> 3c6d791 (add fixed error code)
}

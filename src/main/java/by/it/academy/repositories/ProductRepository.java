package by.it.academy.repositories;

import by.it.academy.entities.Product;

import java.util.List;

public interface ProductRepository {
    Product createProduct(String brand, String model, String specifications,
                          int guaranteeInMonth, int price, int quantity);

    List<Product> readProduct();
}

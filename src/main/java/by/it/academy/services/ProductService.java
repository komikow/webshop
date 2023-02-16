package by.it.academy.services;

import by.it.academy.entities.Product;

import java.util.List;

public interface ProductService {

    Product createProduct(String brand, String model, String specifications,
                          int guaranteeInMonth, int price, int quantity);

    List<Product> readProduct();
}

package by.it.academy.services;

import by.it.academy.entities.Product;
import by.it.academy.repositories.ProductRepository;
<<<<<<< HEAD
=======
import by.it.academy.repositories.ProductRepositoryImpl;
>>>>>>> 3c6d791 (add fixed error code)
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
<<<<<<< HEAD
    public Product createProduct(String brand, String model, String specifications,
                                 int guaranteeInMonth, int price, int quantity) {
        return productRepository.createProduct(brand, model, specifications,
                guaranteeInMonth, price, quantity);
=======
    public void createProduct(String model, String specifications, int guarantee, int price, int quantity) {
        productRepository.createProduct(model, specifications, guarantee, price, quantity);
>>>>>>> 3c6d791 (add fixed error code)
    }

    @Override
    public List<Product> readProduct() {
        return productRepository.readProduct();
    }
<<<<<<< HEAD
=======

    @Override
    public void deleteProduct(String model) {
//        ProductRepository productRepositoryToDelete = new ProductRepositoryImpl();
        productRepository.deleteProduct(model);
    }
>>>>>>> 3c6d791 (add fixed error code)
}

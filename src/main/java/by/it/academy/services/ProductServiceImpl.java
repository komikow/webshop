package by.it.academy.services;

import by.it.academy.entities.Product;
import by.it.academy.repositories.ProductRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public Product createProduct(String brand, String model, String specifications,
                                 int guaranteeInMonth, int price, int quantity) {
        return productRepository.createProduct(brand, model, specifications,
                guaranteeInMonth, price, quantity);
    }

    @Override
    public List<Product> readProduct() {
        return productRepository.readProduct();
    }
}

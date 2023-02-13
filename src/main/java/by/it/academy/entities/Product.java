package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String brand;
    private String model;
    private String specifications;
    private int guarantee;
    private int price;
    private int quantity;
}

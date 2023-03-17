package by.it.academy.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String model;
    private String specifications;
    private int guaranteeInMonths;
    private int price;
    private int quantity;
}

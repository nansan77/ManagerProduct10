package ru.netology.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;
import ru.netology.domain.Product;

@Data
@EqualsAndHashCode(callSuper = true)

public class Smartphone extends Product {
    private String manufacturer;

    public Smartphone() {
        super();
    }

    public Smartphone(int id, String name, int price, String manufacturer) {
        super(id, name, price);
        this.manufacturer = manufacturer;
    }


}

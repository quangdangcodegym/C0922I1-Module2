package com.codegym.treemap;

import java.util.Objects;

public class Product {
    private String name;
    private double price;

    public Product(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public boolean equals(Object o) {
        Product o1 = (Product) o;
        if (this.price == o1.getPrice() && this.name.equalsIgnoreCase(o1.getName())) {
            return true;
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public int hashCode() {
        return Objects.hash(price, name.toLowerCase());
    }
}

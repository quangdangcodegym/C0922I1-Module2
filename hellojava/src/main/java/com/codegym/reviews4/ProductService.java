package com.codegym.reviews4;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    public List<Product> products;

    public void init() {
        products = new ArrayList<>();
        Product product1 = new Product(1L, "Iphone 11", 1000.0, 10, 1);
        Product product2 = new Product(2L, "aaa 12", 1200.0, 10, 1);
        Product product3 = new Product(3L, "cc 13", 1300.0, 10, 1);
        Product product4 = new Product(4L, "Iphone 14", 1400.0, 10, 1);
        products.add(product1);
        products.add(product2);
        products.add(product3);
        products.add(product4);
    }

    public List<Product> searchByName(String nameSearch) {
        List<Product> productResults = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toUpperCase().contains(nameSearch.toUpperCase())) {
                productResults.add(p);
            }
        }
        return productResults;
    }
    public void addProduct(Product product) {
        products.add(product);
    }

    public Product findProductById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void editProduct(long id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.updateProduct(product);
            }
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}

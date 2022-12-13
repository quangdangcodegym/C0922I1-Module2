package com.codegym;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProductService {
    private List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(1670924820, "Iphone X", 23000, 1, new Date()));
        products.add(new Product(1670924821, "Iphone 19", 23000, 1, new Date()));
        products.add(new Product(1670924822, "Iphone 11", 23000, 1, new Date()));
        products.add(new Product(1670924823, "Iphone 12", 23000, 1, new Date()));
        products.add(new Product(1670924824, "Iphone 13", 23000, 1, new Date()));
    }
    public List<Product> getAllProducts() {
        return products;
    }

    public List<Product> searchProductsByKeyword(String keyword) {
        List<Product> productResults = new ArrayList<>();
        for (Product p : products) {
            if (p.getName().toUpperCase().contains(keyword.toUpperCase())) {
                productResults.add(p);
            }
        }
        return productResults;
    }
    public Product findProductById(long id) {
        for (Product p : products) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void updateProduct(long id, Product product) {
        for (Product p : products) {
            if (p.getId() == id) {
                p.setName(product.getName());
                p.setCreateAt(product.getCreateAt());
                p.setPrice(product.getPrice());
                p.setQuantity(product.getQuantity());
            }
        }
    }

    public void addProduct(Product product) {
        products.add(product);
    }
}

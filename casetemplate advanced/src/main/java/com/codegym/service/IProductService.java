package com.codegym.service;

import com.codegym.model.Product;

import java.util.List;

public interface IProductService {
    Product findProductById(long id);
    List<Product> getAllProduct();
    void editProduct(long id, Product product);
    List<Product> searchByName(String nameSearch);
    void addProduct(Product product);
}

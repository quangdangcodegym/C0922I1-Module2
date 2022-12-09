package com.codegym.service;

import com.codegym.model.Product;

public interface IProductService {
    Product findProductById(long id);
    public void editProduct(long id, Product product);
}

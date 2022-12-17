package com.codegym.repository;

import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository extends DatabaseContext<Product> {
    public ProductRepository() {
        super(Product.class);
        path = "./data/product.txt";
    }
//    @Override
//    public List<Product> getAll() {
//        return fileService.readData(path, Product.class);
//    }


}

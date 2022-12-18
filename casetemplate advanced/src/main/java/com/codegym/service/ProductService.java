package com.codegym.service;

import com.codegym.model.ECategory;
import com.codegym.model.EModel;
import com.codegym.model.ISearch;
import com.codegym.model.Product;
import com.codegym.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService implements IProductService{
    private ProductRepository productRepository;

    public ProductService() {
        productRepository = new ProductRepository();
    }

    public List<Product> getAllProduct() {
        return productRepository.getAll();
    }

    public List<Product> searchByName(String nameSearch) {
        ISearch<Product> productISearchName = new ISearch<Product>() {
            @Override
            public boolean searchByName(Product item, String name) {
                if (item.getName().toUpperCase().contains(name.toUpperCase())) {
                    return true;
                }
                return false;
            }
        };
        return productRepository.searchBy(productISearchName, nameSearch);
    }
    public void addProduct(Product product) {
        productRepository.add(product);
    }
    public boolean checkRemainProductQuantity(long idProduct, int quantity) {
        Product product = findProductById(idProduct);
        if(product.getQuantity() < quantity){
            return false;
        }
        return true;
    }
    @Override
    public Product findProductById(long id) {
        return productRepository.find(id);
    }
    @Override
    public void editProduct(long id, Product product) {
        productRepository.edit(id, product);

    }

}

package com.codegym.service;

import com.codegym.model.ECategory;
import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private FileService fileService;
    private final String pathProduct = "./data/product.txt";

    public ProductService() {
        fileService = new FileService();
    }

    public List<Product> getAllProduct() {
        List<String> productLines = fileService.readData(pathProduct);
        List<Product> products = convertProductLinesToProduct(productLines);
        return products;
    }

    public List<Product> searchByName(String nameSearch) {
        List<Product> productResults = new ArrayList<>();
        for (Product p : getAllProduct()) {
            if (p.getName().toUpperCase().contains(nameSearch.toUpperCase())) {
                productResults.add(p);
            }
        }
        return productResults;
    }
    public void addProduct(Product product) {
        List<Product> products = getAllProduct();
        products.add(product);

        List<String> productLines = convertProductToProductLines(products);
        fileService.writeData(pathProduct, productLines);

    }

    public List<String> convertProductToProductLines(List<Product> products) {
        List<String> productLines = new ArrayList<>();
        for (Product p : products) {
            productLines.add(p.toData());
        }
        return productLines;

    }

    public boolean checkRemainProductQuantity(long idProduct, int quantity) {
        Product product = findProductById(idProduct);
        if(product.getQuantity() < quantity){
            return false;
        }
        return true;
    }
    public List<Product> convertProductLinesToProduct(List<String> productLines) {
        List<Product> products = new ArrayList<>();
        for (String item : productLines) {
            //"1670310569,Iphone X,12000.0,5,3"
            String [] items = item.split(",");
            //[1670310569,Iphone X,12000.0,5,3]
            long idProduct = Long.parseLong(items[0]);
            double price = Double.parseDouble(items[2]);
            int quantity = Integer.parseInt(items[3]);
            int idCategory = Integer.parseInt(items[4]);
            ECategory eCategory = ECategory.findCategoryById(idCategory);
            Product product = new Product(idProduct, items[1], price, quantity,eCategory );
            products.add(product);
        }
        return products;
    }

    public Product findProductById(long id) {
        for (Product p : getAllProduct()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }

    public void editProduct(long id, Product product) {
        List<Product> products = getAllProduct();

        for (Product p : products) {
            if (p.getId() == id) {
                p.updateProduct(product);
            }
        }
        List<String> productLines = convertProductToProductLines(products);
        fileService.writeData(pathProduct, productLines);

    }

}

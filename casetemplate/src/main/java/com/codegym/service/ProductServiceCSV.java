package com.codegym.service;

import com.codegym.model.EModel;
import com.codegym.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductServiceCSV implements IProductService{
    private FileService fileService;
    private final String pathProduct = "./data/product.txt";

    public ProductServiceCSV() {
        fileService = new FileService();
    }

    public List<Product> getAllProduct() {
//        List<String> productLines = fileService.readData(pathProduct);
//        List<Product> products = convertProductLinesToProduct(productLines);
        List<Product> products = fileService.readData(pathProduct, EModel.PRODUCT);
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

        fileService.writeData(pathProduct, products);

    }



    public boolean checkRemainProductQuantity(long idProduct, int quantity) {
        Product product = findProductById(idProduct);
        if(product.getQuantity() < quantity){
            return false;
        }
        return true;
    }
//    public List<Product> convertProductLinesToProduct(List<String> productLines) {
//        List<Product> products = new ArrayList<>();
//        for (String item : productLines) {
//            //"1670310569,Iphone X,12000.0,5,3"
//            String [] items = item.split(",");
//            //[1670310569,Iphone X,12000.0,5,3]
//
//            //1670310571,Iphone 12,10000.0,5,NOKIA
//            long idProduct = Long.parseLong(items[0]);
//            double price = Double.parseDouble(items[2]);
//            int quantity = Integer.parseInt(items[3]);
//            ECategory eCategory = ECategory.valueOf(items[4]);
//            Product product = new Product(idProduct, items[1], price, quantity,eCategory );
//            products.add(product);
//        }
//        return products;
//    }

    @Override
    public Product findProductById(long id) {
        for (Product p : getAllProduct()) {
            if (p.getId() == id) {
                return p;
            }
        }
        return null;
    }
    @Override
    public void editProduct(long id, Product product) {
        List<Product> products = getAllProduct();

        for (Product p : products) {
            if (p.getId() == id) {
                p.updateProduct(product);
            }
        }
        fileService.writeData(pathProduct, products);

    }
}

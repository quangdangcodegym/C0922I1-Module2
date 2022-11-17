package com.codegym.oop;

public class Product {
    // name: là biến instance
    public String name;
    public static String color = "TRANG";

    public Product(String name) {
        this.name  = name;
    }
    public Product() {

    }

    public static void main(String[] args) {
        Product p1 = new Product("Iphone X");
        Product p2 = new Product("Iphone X");
        Product p3 = new Product("Iphone X");
        Product p4 = new Product("Iphone 13");


//        Product p1 = new Product("Phuoc");
    }
}

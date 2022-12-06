package com.codegym.model;

public class Product {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private ECategory category;

    public Product(long id, String name, double price, int quantity, ECategory eCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.category = eCategory;
    }
    public Product() {

    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ECategory getCategory() {
        return category;
    }

    public void setCategory(ECategory category) {
        this.category = category;
    }

    public void updateProduct(Product product) {
        this.setName(product.getName());
        this.setPrice(product.getPrice());
        this.setQuantity(product.getQuantity());
        this.setCategory(product.getCategory());
    }

    @Override
    public String toString() {
        return String.format("%-10s %-20s %-10s %-10s %-10s",
                this.id, this.name, this.price, this.quantity, category);
    }
    public String toData() {
        //1670310571,Iphone 12,12000.0,5,1
        return String.format("%s,%s,%s,%s,%s", this.id, this.name, this.price,this.quantity,category.getId() );
    }
}

package com.codegym.model;

public class Product implements IModel<Product>, ISearch<Product> {
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

    @Override
    public void update(Product objNew) {
        this.id = objNew.getId();
        this.name = objNew.getName();
        this.price = objNew.getPrice();
        this.category = objNew.getCategory();
        this.quantity = objNew.getQuantity();
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
        //1670313569,Iphone X,10000.0,5,3
        return String.format("%s,%s,%s,%s,%s",
                this.id, this.name, this.price, this.quantity, category);
    }
    public String toData() {
        //1670310571,Iphone 12,12000.0,5,1
        return String.format("%s,%s,%s,%s,%s", this.id, this.name, this.price,this.quantity,category.getId() );
    }

    public String toView() {
        return String.format("%-10s|%-20s|%-10s|%-5s|%-5s",
                this.id, this.name, this.price, this.quantity, category);
    }

    @Override
    public Product parseData(String line) {
        String [] items = line.split(",");

        long idProduct = Long.parseLong(items[0]);
        double price = Double.parseDouble(items[2]);
        int quantity = Integer.parseInt(items[3]);
        ECategory eCategory = ECategory.valueOf(items[4]);
        Product product = new Product(idProduct, items[1], price, quantity,eCategory );
        return product;
    }

    @Override
    public boolean searchByName(String name) {
        if (this.getName().toUpperCase().contains(name.toUpperCase())) {
            return true;
        }
        return false;
    }
}

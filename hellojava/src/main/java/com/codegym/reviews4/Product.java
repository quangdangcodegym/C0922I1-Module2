package com.codegym.reviews4;

public class Product {
    private long id;
    private String name;
    private double price;
    private int quantity;
    private int idCategory;

    public Product(long id, String name, double price, int quantity, int idCategory) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.idCategory = idCategory;
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

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    @Override
    public String toString() {


        Category c = AppMain.findCategoryById(this.idCategory);
        String categoryName = "";
        if (c != null) {
            categoryName = c.getName();
        }
        return String.format("%-10s %-20s %-10s %-10s %-10s",
                this.id, this.name, this.price, this.quantity, categoryName);
        /*return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", quantity=" + quantity +
                ", idCategory=" + idCategory +
                '}';*/
    }
}

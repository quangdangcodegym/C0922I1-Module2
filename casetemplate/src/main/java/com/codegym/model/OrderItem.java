package com.codegym.model;

public class OrderItem {
    private long id;
    private long idProduct;
    private long idOrder;

    private int amount;
    private double price;


    public OrderItem() {

    }

    public OrderItem(long id, long idProduct, long idOrder, int amount, double price) {
        this.id = id;
        this.idProduct = idProduct;
        this.idOrder = idOrder;
        this.amount = amount;
        this.price = price;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(long idProduct) {
        this.idProduct = idProduct;
    }

    public long getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(long idOrder) {
        this.idOrder = idOrder;
    }

    public String toData() {
        //1,1670310569,1,10000.0,2
        return String.format("%s,%s,%s,%s,%s", this.id, this.idProduct, this.idOrder, this.price, this.amount);
    }
}

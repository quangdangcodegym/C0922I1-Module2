package com.codegym.model;

public class OrderItem implements IModel<OrderItem> {
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

    @Override
    public void update(OrderItem objNew) {
        this.id = objNew.getId();
        this.idOrder = objNew.getIdOrder();
        this.price = objNew.getPrice();
        this.amount = objNew.getAmount();
        this.idProduct = objNew.getIdProduct();
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



    @Override
    public String toString() {
        //1670491174,1670310571,1670491168,10000.0,20
        return String.format("%s,%s,%s,%s,%s", this.id, this.idProduct, this.idOrder, this.price, this.amount);
    }

    @Override
    public OrderItem parseData(String line) {
        String [] items = line.split(",");
        OrderItem orderItem = new OrderItem();
        orderItem.setId(Long.parseLong(items[0]));
        orderItem.setIdProduct(Long.parseLong(items[1]));
        orderItem.setIdOrder(Long.parseLong(items[2]));
        orderItem.setPrice(Double.parseDouble(items[3]));
        orderItem.setAmount(Integer.parseInt(items[4]));
        return orderItem;
    }
}

package com.codegym.model;

import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order {
    private long id;
    private Date createAt;
    private double total;
    private List<OrderItem> orderItems;

    private EOrderStatus orderStatus;
    //New, Checkout, Paid, Failed, Shipped, Delivered, Returned, and Complete.
    // Thêm 1 thuộc tính là trạng thái order: Enum


    public void addOrderItem(OrderItem orderItem) {
        orderItems.add(orderItem);
    }

    public Order(long id, Date createAt, double total) {
        this.id = id;
        this.createAt = createAt;
        this.total = total;
    }

    public EOrderStatus getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(EOrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }

    public Order() {
        orderItems = new ArrayList<>();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public String toData() {
        //1,06-12-2022,70000
        return String.format("%s,%s,%s,%s", this.getId(), DateUtils.convertDateToString(this.createAt), this.total, this.orderStatus);
    }
}

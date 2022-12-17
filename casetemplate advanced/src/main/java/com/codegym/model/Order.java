package com.codegym.model;

import com.codegym.service.OrderItemService;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Order implements IModel<Order> {
    private long id;
    private Date createAt;
    private double total;
    private List<OrderItem> orderItems;

    private String address;
    private String customerName;
    private String phone;


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

    @Override
    public void update(Order objNew) {
        this.id = objNew.getId();
        this.total = objNew.getTotal();
        this.orderStatus = objNew.getOrderStatus();
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s,%s,%s", this.id, DateUtils.convertDateToString(this.createAt), this.total, this.orderStatus, this.getCustomerName(), this.getAddress(), this.getPhone());
    }

    @Override
    public Order parseData(String line) {
        String [] items = line.split(",");
        Order order = new Order();
        order.setId(Long.parseLong(items[0]));
        order.setCreateAt(DateUtils.convertStringToDate(items[1]));
        order.setTotal(Double.parseDouble(items[2]));
        // items[3]
        order.setOrderStatus(EOrderStatus.findEOrderStatusByName(items[3]));

        order.setCustomerName(items[4]);
        order.setAddress(items[5]);
        order.setPhone(items[6]);
        OrderItemService orderItemService = new OrderItemService();
        List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderId(order.getId());
        order.setOrderItems(orderItems);
        return order;
    }
}

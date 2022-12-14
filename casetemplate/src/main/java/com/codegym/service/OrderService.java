package com.codegym.service;

import com.codegym.model.EModel;
import com.codegym.model.EOrderStatus;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private String pathOrder = "./data/order.txt";
    private FileService fileService;
    private OrderItemService orderItemService;
    public OrderService() {

        fileService = new FileService();
        orderItemService = new OrderItemService();
    }

    public void createOrder(Order order) {
        List<Order> orders = getAllOrders();
        orders.add(order);
        //[1670321738,06-12-2022,0.0; 1670321738,06-12-2022,0.0; 1670321738,06-12-2022,0.0]
        fileService.writeData(pathOrder, orders);

        orderItemService.createOrderItem(order.getOrderItems());
    }



    public List<Order> getAllOrders() {
        List<Order> orders = fileService.readData(pathOrder, EModel.ORDER);
        return orders;
    }

    public Order getOrderById(long idOrder) {
        List<Order> orders = getAllOrders();
        for (Order order : orders) {
            if (order.getId() == idOrder) {
                return order;
            }
        }
        return null;
    }
}

package com.codegym.service;

import com.codegym.model.EModel;
import com.codegym.model.OrderItem;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService {

    private String pathOrderItem = "./data/orderitem.txt";
    private FileService fileService;
    public OrderItemService() {
        fileService = new FileService();
    }

    public List<OrderItem> findOrderItemsByOrderId(long id) {
        List<OrderItem> orderItems = getAllOrderItems();
        List<OrderItem> orderItemResults = new ArrayList<>();
        for (OrderItem orderItem : orderItems) {
            if (orderItem.getIdOrder() == id) {
                orderItemResults.add(orderItem);
            }
        }
        return orderItemResults;
    }

    public List<OrderItem> getAllOrderItems() {
        List<OrderItem> orderItems = fileService.readData(pathOrderItem, EModel.ORDERITEM);

        return orderItems;
    }

    public void createOrderItem(List<OrderItem> orderItem) {
        List<OrderItem> allOrderItems = getAllOrderItems();
        allOrderItems.addAll(orderItem);

        fileService.writeData(pathOrderItem, allOrderItems);
    }


}

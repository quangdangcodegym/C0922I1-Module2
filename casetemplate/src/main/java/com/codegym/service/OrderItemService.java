package com.codegym.service;

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
        List<OrderItem> orderItems = new ArrayList<>();
        List<String> orderItemLines = fileService.readData(pathOrderItem);
        for (String line : orderItemLines) {
            //1,1670310569,1,12000.0,2
            String [] items = line.split(",");
            OrderItem orderItem = new OrderItem();
            orderItem.setId(Long.parseLong(items[0]));
            orderItem.setIdProduct(Long.parseLong(items[1]));
            orderItem.setIdOrder(Long.parseLong(items[2]));
            orderItem.setPrice(Double.parseDouble(items[3]));
            orderItem.setAmount(Integer.parseInt(items[4]));
            orderItems.add(orderItem);
        }
        return orderItems;
    }

    public void createOrderItem(List<OrderItem> orderItem) {
        List<OrderItem> allOrderItems = getAllOrderItems();
        allOrderItems.addAll(orderItem);

        List<String> allOrderItemLines = convertOrderItemsToOrderItemLines(allOrderItems);
        fileService.writeData(pathOrderItem, allOrderItemLines);
    }

    private List<String> convertOrderItemsToOrderItemLines(List<OrderItem> allOrderItems) {
        List<String> orderItemLines = new ArrayList<>();
        for (OrderItem orderItem : allOrderItems) {
            orderItemLines.add(orderItem.toData());
        }
        return orderItemLines;
    }
}

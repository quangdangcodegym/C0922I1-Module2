package com.codegym.service;

import com.codegym.model.EModel;
import com.codegym.model.OrderItem;
import com.codegym.repository.OrderItemRepository;

import java.util.ArrayList;
import java.util.List;

public class OrderItemService {

    private OrderItemRepository orderItemRepository;
    public OrderItemService() {
        orderItemRepository = new OrderItemRepository();
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
        return orderItemRepository.getAll();
    }

    public void createOrderItem(List<OrderItem> orderItem) {
        List<OrderItem> allOrderItems = orderItemRepository.getAll();
        allOrderItems.addAll(orderItem);
        orderItemRepository.addList(allOrderItems);
    }


}

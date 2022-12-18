package com.codegym.repository;

import com.codegym.model.EModel;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.service.OrderItemService;

import java.util.List;

public class OrderItemRepository extends DatabaseContext<OrderItem> {
    public OrderItemRepository() {
        super(OrderItem.class);

        path = "./data/orderitem.txt";
    }

    public void createOrderItem(List<OrderItem> orderItem) {
        List<OrderItem> allOrderItems = getAll();
        allOrderItems.addAll(orderItem);

        addList(allOrderItems);
    }
}

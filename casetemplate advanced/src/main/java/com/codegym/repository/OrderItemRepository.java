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
//    @Override
//    public List<OrderItem> getAll() {
//        List<OrderItem> orderItems = fileService.readData(path, EModel.ORDERITEM);
//        return orderItems;
//    }

    public void createOrderItem(List<OrderItem> orderItem) {
//        List<OrderItem> allOrderItems = getAll();
//        allOrderItems.addAll(orderItem);
//
//        addList(allOrderItems);
    }
}

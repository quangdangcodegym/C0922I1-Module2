package com.codegym.service;

import com.codegym.model.EModel;
import com.codegym.model.EOrderStatus;
import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.repository.OrderItemRepository;
import com.codegym.repository.OrderRepository;
import com.codegym.utils.DateUtils;

import java.util.ArrayList;
import java.util.List;

public class OrderService {
    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;
    public OrderService() {
        orderRepository = new OrderRepository();
        orderItemRepository = new OrderItemRepository();
    }

    public void createOrder(Order order) {
        orderRepository.add(order);
        orderItemRepository.createOrderItem(order.getOrderItems());
    }
    public List<Order> getAllOrders() {
        return orderRepository.getAll();
    }

    public Order getOrderById(long idOrder) {
        return orderRepository.find(idOrder);
    }
}

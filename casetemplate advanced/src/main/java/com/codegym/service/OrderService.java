package com.codegym.service;

import com.codegym.model.*;
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

    public List<Order> searchOrderByCustomerName(String customerName) {
        ISearch<Order> orderISearch = new ISearch<Order>() {
            @Override
            public boolean searchByName(Order item, String name) {
                if (item.getCustomerName().toUpperCase().contains(name.toUpperCase())) {
                    return true;
                }
                return false;
            }
        };
        return orderRepository.searchBy(orderISearch, customerName);
    }
}

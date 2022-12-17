package com.codegym.repository;

import com.codegym.model.EModel;
import com.codegym.model.Order;

import java.util.List;

public class OrderRepository extends DatabaseContext<Order>{
    public OrderRepository() {
        super(Order.class);
        path = "./data/order.txt";
    }


}

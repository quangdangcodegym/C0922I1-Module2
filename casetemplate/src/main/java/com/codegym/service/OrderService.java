package com.codegym.service;

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
        List<String> orderLines = convertOrdersToOrderLines(orders);
        fileService.writeData(pathOrder, orderLines);

        orderItemService.createOrderItem(order.getOrderItems());
    }

    private List<String> convertOrdersToOrderLines(List<Order> orders) {
        List<String> orderLines = new ArrayList<>();
        for (Order order : orders) {
            orderLines.add(order.toData());
        }
        return orderLines;
    }

    public List<Order> getAllOrders() {
        List<String> orderLines = fileService.readData(pathOrder);
        List<Order> orders = new ArrayList<>();
        for (String line : orderLines) {
            // 1,Tue Dec 06 16:08:04 ICT 2022, 50000
            String [] items = line.split(",");
            Order order = new Order();
            order.setId(Long.parseLong(items[0]));
            order.setCreateAt(DateUtils.convertStringToDate(items[1]));
            order.setTotal(Double.parseDouble(items[2]));
            // items[3]
            order.setOrderStatus(EOrderStatus.findEOrderStatusByName(items[3]));
            List<OrderItem> orderItems = orderItemService.findOrderItemsByOrderId(order.getId());
            order.setOrderItems(orderItems);
            orders.add(order);
        }
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

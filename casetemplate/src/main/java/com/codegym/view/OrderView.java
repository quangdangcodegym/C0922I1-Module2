package com.codegym.view;

import com.codegym.model.Order;
import com.codegym.model.OrderItem;
import com.codegym.model.Product;
import com.codegym.service.OrderItemService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.Scanner;

public class OrderView {
    public OrderView() {
        productService = new ProductService();
        orderService = new OrderService();
        orderItemService = new OrderItemService();
    }
    private Scanner scanner = new Scanner(System.in);
    private ProductService productService;
    private OrderService orderService;
    private OrderItemService orderItemService;


    public void launch() {

        boolean checkMenuAction = false;
        do {
            System.out.println("Bạn hãy chọn chức năng:");
            System.out.println("Xem danh sách Order -->:                1");
            System.out.println("Thêm Order -->:                         2");
            System.out.println("Cap nhat don hang -->:                  3");

            int menuAction = Integer.parseInt(scanner.nextLine());
            switch (menuAction) {
                case 1:
                    showOrderDetailView();
                    checkMenuAction = checkContinueAction();
                    break;
                case 2:
                    createOrderView();
                    checkMenuAction = checkContinueAction();
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                    checkMenuAction = true;
                    break;
            }
        } while (checkMenuAction);
    }

    private void createOrderView() {

        Order order = new Order();
        order.setId(System.currentTimeMillis() / 1000);
        order.setCreateAt(new Date());

        boolean checkAddOrderItem = false;
        do{
            System.out.println("Danh sách sản phẩm: ");
            ProductView productView = new ProductView();
            productView.showProductsView(productService.getAllProduct());
            System.out.println("Nhập ID bạn muốn thêm");
            long id = Long.parseLong(scanner.nextLine());
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());

            Product product = productService.findProductById(id);
            // do while ở chỗ này để kiểm tra tồn tai product

            OrderItem orderItem =
                    new OrderItem(System.currentTimeMillis() / 1000, product.getId(), order.getId(), quantity, product.getPrice());

            order.addOrderItem(orderItem);
            checkAddOrderItem = checkContinueAction();

        }while (checkAddOrderItem);
        order.setTotal(getTotal(order));
        orderService.createOrder(order);

    }

    public double getTotal(Order order) {
        double total = 0;
        for (OrderItem orderItem : order.getOrderItems()) {
            total += orderItem.getPrice() * orderItem.getAmount();
        }
        return total;
    }
    public void showOrderView() {

    }
    public void showOrderDetailView() {
        showOrderView();
        System.out.println("Nhập ID order cần xem: ");
        long idOrder = Long.parseLong(scanner.nextLine());
        Order order = orderService.getOrderById(idOrder);
        System.out.println("Order ID: " + order.getId() + " Create at: " + DateUtils.convertDateToString(order.getCreateAt()));

        for (OrderItem orderItem : order.getOrderItems()) {
            Product p = productService.findProductById(orderItem.getIdProduct());
            String fmtOrderItem = String.format("%-20s|%-15s|%-10s", p.getName(), orderItem.getAmount(), orderItem.getPrice()*orderItem.getAmount());
            System.out.println(fmtOrderItem);
        }
        System.out.println("------------                        ");
        System.out.println("                        Total: " + order.getTotal());
    }

    public boolean checkContinueAction() {
        System.out.println("Bạn có muốn tiếp tục hay không Yes(Y)/No(N)");
        String continueAction = scanner.nextLine();
        switch (continueAction) {
            case "Y":
                return true;
            case "N":
                return false;
        }
        return false;
    }
}

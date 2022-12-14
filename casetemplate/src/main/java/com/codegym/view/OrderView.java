package com.codegym.view;

import com.codegym.model.*;
import com.codegym.service.OrderItemService;
import com.codegym.service.OrderService;
import com.codegym.service.ProductService;
import com.codegym.utils.DateUtils;

import java.util.Date;
import java.util.Scanner;

public class OrderView extends ScreenView{
    public OrderView() {
        productService = new ProductService();
        orderService = new OrderService();
        orderItemService = new OrderItemService();
    }

    private ProductService productService;
    private OrderService orderService;
    private OrderItemService orderItemService;


    @Override
    public void launch() {
        if(this.getUser().getRole()== ERole.ADMIN){
            boolean checkMenuAction = false;
            do {
                System.out.println("Bạn hãy chọn chức năng:");
                System.out.println("Xem danh sách Order -->:                1");
                System.out.println("Thêm Order -->:                         2");
                System.out.println("Cap nhat don hang -->:                  3");
                System.out.println("Tìm đơn hàng theo ngày -->:             4");

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
                    case 4:
                        chooseOrderByDateView();
                        checkMenuAction = checkContinueAction();
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                        checkMenuAction = true;
                        break;
                }
            } while (checkMenuAction);
        }


    }

    private  void chooseOrderByDateView() {
        System.out.println("Nhập ngày bạn muốn xem: (08-12-2022 07:00");
        String sDate = scanner.nextLine();
        Date date = DateUtils.convertStringToDate(sDate);

        Date startDate = DateUtils.convertStringToDate("08-12-2022 00:00");
        Date endDate = DateUtils.convertStringToDate("08-12-2022 23:00");

        System.out.println(isWithinRange(date, startDate, endDate));
    }


    public boolean isWithinRange(Date testDate, Date startDate, Date endDate) {
        return !(testDate.before(startDate) || testDate.after(endDate));
    }

    private void createOrderView() {

        Order order = new Order();
        order.setId(System.currentTimeMillis() / 1000);
        order.setCreateAt(new Date());
        order.setOrderStatus(EOrderStatus.NEW);

        boolean checkAddOrderItem;
        do{
            checkAddOrderItem = true;
            System.out.println("Danh sách sản phẩm: ");
            ProductView productView = new ProductView();
            productView.showProductsView(productService.getAllProduct());
            System.out.println("Nhập ID bạn muốn thêm");
            long id = Long.parseLong(scanner.nextLine());
            Product product = productService.findProductById(id);

            int quantity = inputQuantity(order, id);
            if (quantity == -1) {
                continue;
            }
            // do while ở chỗ này để kiểm tra tồn tai product
            /**
             Kiem tra IDProduct co trong OrderItem cua order chua
                + Neu co: -> Rồi so sánh với số lượng tồn, lay so luong ra va cong them so luong moi.
                + Neu chua: -> tạo ra order item mới với số lượng họ nhập vào.

             */
            OrderItem orderItem = null;
            if ( (orderItem = checkProductExistsInOrder(order, product.getId()))!=null) {
                    orderItem.setAmount(quantity + orderItem.getAmount());
            }else{
                orderItem =
                        new OrderItem(System.currentTimeMillis() / 1000, product.getId(), order.getId(), quantity, product.getPrice());
                order.addOrderItem(orderItem);
            }
            showOrderItemsByOrder(order);
            checkAddOrderItem = checkContinueAction();



        }while (checkAddOrderItem);
        order.setTotal(getTotal(order));
        orderService.createOrder(order);


    }

    private void showOrderItemsByOrder(Order order) {
        System.out.println("Danh sách các món bạn đang chọn");
        for (OrderItem orderItem : order.getOrderItems()) {
            Product p = productService.findProductById(orderItem.getIdProduct());
            String fmtOrderItem = String.format("%-20s|%-15s|%-10s", p.getName(), orderItem.getAmount(), orderItem.getPrice()*orderItem.getAmount());
            System.out.println(fmtOrderItem);
        }
    }

    private int inputQuantity(Order order, long idProduct) {
        boolean checkContinueAction = true;
        do {
            System.out.println("Nhập số lượng: ");
            int quantity = Integer.parseInt(scanner.nextLine());
            OrderItem orderItem = checkProductExistsInOrder(order, idProduct);
            if (orderItem != null) {
                if (productService.checkRemainProductQuantity(idProduct, orderItem.getAmount() + quantity)) {
                    return quantity;
                }
            }else{
                if (productService.checkRemainProductQuantity(idProduct, quantity)) {
                    return quantity;
                }
            }
            Product product = productService.findProductById(idProduct);
            System.out.printf("Số bạn order vượt quá số lượng (%s) trong kho", product.getQuantity());
            checkContinueAction = checkContinueAction();
        } while (checkContinueAction);
        return -1;

    }


    public OrderItem checkProductExistsInOrder(Order order, long idProduct) {
        for (OrderItem orderItem : order.getOrderItems()) {
            if (orderItem.getIdProduct() == idProduct) {
                return orderItem;
            }
        }
        return null;
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
        showOrderDetailViewById(order);
    }

    public void showOrderDetailViewById(Order order) {
        System.out.println("Order ID: " + order.getId() + " Create at: " + DateUtils.convertDateToString(order.getCreateAt()));
        System.out.println("Order status: " + order.getOrderStatus());
        for (OrderItem orderItem : order.getOrderItems()) {
            Product p = productService.findProductById(orderItem.getIdProduct());
            String fmtOrderItem = String.format("%-20s|%-15s|%-10s", p.getName(), orderItem.getAmount(), orderItem.getPrice()*orderItem.getAmount());
            System.out.println(fmtOrderItem);
        }
        System.out.println("------------                        ");
        System.out.println("                        Total: " + order.getTotal());
    }


}

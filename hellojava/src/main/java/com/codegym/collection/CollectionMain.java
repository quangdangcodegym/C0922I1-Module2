package com.codegym.collection;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CollectionMain {
    public static List<Product> products;
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /**
        // 1 biến thuộc kiểu dữ liệu của lớp cha có thể tham chiêu
        // tới 1 đối tượng của lớp con
        List<String> list = new ArrayList<>();
        list.add("Toan");
        list.add("Y");
        list.add("Long");
        list.add("Toan");

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }
         **/


        List<Product> products = initProducts();

        boolean checkMenuActionError;
        do{
            checkMenuActionError = false;
            System.out.println("Chọn chức năng: ");
            System.out.println("Nhấn 1: ----> Thêm sản phẩm");
            System.out.println("Nhấn 2: ----> Sửa sản phẩm");
            System.out.println("Nhấn 3:-----> Xem danh sách");
            System.out.println("Nhấn 4:-----> Tìm kiếm sản phẩm theo tên");
            System.out.println("Nhấn 5:-----> Sắp xếp sản phẩm theo tên");
            System.out.println("Nhấn 6:-----> Sắp xếp sản phẩm theo giá");
            int menuAction = Integer.parseInt(scanner.nextLine());
            switch (menuAction) {
                case 1:
                    addProductView();
                    checkMenuActionError = showMenuContinue();
                    break;
                case 2:
                    editProductView();
                    break;
                case 3:
                    printArrayList(products);
                    break;
                default:
                    checkMenuActionError = true;
                    System.out.println("Nhập sai. Vui lòng nhập lại");
            }
        }while (checkMenuActionError);

    }

    private static void editProductView() {
        System.out.println("Nhap ID cần sửa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        System.out.println("Bạn muốn sửa theo: ");
        System.out.println("Nhập 1: Sửa tên");
        System.out.println("Nhập 2: Sửa số lượng");

        boolean checkMenuEditError = false;
        do {
            int menuEditAction = Integer.parseInt(scanner.nextLine());
            switch (menuEditAction) {
                case 1:
                    System.out.println("Nhập tên sản phẩm mới: ");
                    String nameProductNew = scanner.nextLine();

                    for (int i = 0; i < products.size(); i++) {
                        if (idProduct == products.get(i).getId()) {
                            products.get(i).setName(nameProductNew);
                        }
                    }
                    printArrayList(products);
                    break;
                case 2:

                    break;
                default:
                    checkMenuEditError = true;

            }
        } while (checkMenuEditError);

    }

    public static boolean showMenuContinue() {
        boolean checkContinueActionError;
        do{
            checkContinueActionError = false;
            System.out.println("Bạn có muốn tiếp tục hay không: Y(Yes) / N(No)");
            String menuContinueAction = scanner.nextLine();
            switch (menuContinueAction) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    checkContinueActionError = true;
                    System.out.println("Nhập sai. Vui lòng nhập lại");

            }
        }while (checkContinueActionError);
        return false;
    }

    public static void addProductView() {

        printArrayList(products);
        System.out.println("THÊM SẢN PHẨM");
        System.out.println("Nhập ID:");
        long idProduct = Long.parseLong(scanner.nextLine());
        System.out.println("NHẬP tên");
        String name = scanner.nextLine();
        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());

        Product p = new Product(idProduct, name, quantity);
        products.add(p);

        printArrayList(products);
    }
    public static List<Product> initProducts() {
        products = new ArrayList<>();
        Product p1 = new Product(1L, "Iphone 11", 10);

        products.add(p1);
        products.add(new Product(2L, "Iphone 12", 50));
        products.add(new Product(3L, "Iphone 13", 10));
        products.add(new Product(4L, "Iphone 14", 20));
        return products;
    }
    public static int findIndexOfMaxQuantity(List<Product> products) {
        int maxIndex = 0;
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getQuantity() > products.get(maxIndex).getQuantity()) {
                maxIndex = i;
            }
        }
        return maxIndex;
    }
    public static void printArrayList(List<Product> products) {
        System.out.printf("|%-10s|%-20s|%-10s\n", "ID", "NAME", "PRICE");
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i));
        }
    }

    public static int getTotalInArrayList(List<Product> products) {
        int total = 0;
        for (int i = 0; i < products.size(); i++) {
            total += products.get(i).getQuantity();
        }
        return total;
    }
}

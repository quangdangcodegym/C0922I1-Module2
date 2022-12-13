package com.codegym;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ProductView {
    private ProductService productService;
    private Scanner scanner = new Scanner(System.in);

    public ProductView() {
        productService = new ProductService();
    }
    public void launch() {
        boolean checkMenuAction = true;
        do{
            System.out.println("Menu chương trình: ");
            System.out.println("Thêm sản phẩm:          -> Nhấn phím 1");
            System.out.println("Sửa sản phẩm:           -> Nhấn phím 2");
            System.out.println("Xóa sản phẩm:           -> Nhấn phím 3");
            System.out.println("Danh sách  sản phẩm:    -> Nhấn phím 4");
            System.out.println("Tìm kiếm sản phẩm:      -> Nhấn phím 5");

            try {
                int actionMenu = Integer.parseInt(scanner.nextLine());
                switch (actionMenu) {
                    case 1:
                        addProductView();
                        checkMenuAction = checkMenuActionContinue();
                        break;
                    case 2:
                        editProductView();
                        checkMenuAction = checkMenuActionContinue();
                        break;
                    case 4:
                        showProductsView(productService.getAllProducts());
                        checkMenuAction = checkMenuActionContinue();
                        break;
                    case 5:
                        showSearchProductView();
                        checkMenuAction = checkMenuActionContinue();
                        break;
                    default:
                        System.out.println("Nhập sai. Vui lòng nhập lại!!");
                        checkMenuAction = true;
                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập sai. Vui lòng nhập lại!!");
                checkMenuAction = true;
            }

        }while (checkMenuAction);

    }

    private void showSearchProductView() {
        boolean checkSearchMenu = true;
        do{
            try {
                System.out.println("Chọn chức năng bạn muốn tìm kiếm");
                System.out.println("1. Tìm kiếm theo tên");
                System.out.println("2. Tìm kiếm theo số lượng");
                System.out.println("2. Tìm kiếm theo giá");
                int actionMenuSearch = Integer.parseInt(scanner.nextLine());
                switch (actionMenuSearch) {
                    case 1:
                        System.out.println("Nhập từ khóa bạn muốn tìm kiếm: ");
                        String keyword = scanner.nextLine();
                        List<Product> productResults = productService.searchProductsByKeyword(keyword);
                        showProductsView(productResults);
                        checkSearchMenu = false;
                        break;
                    case 2:
                        checkSearchMenu = false;
                        break;
                    default:
                        System.out.println("Nhập sai. Vui lòng nhập lại");
                        checkSearchMenu = true;

                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập sai. Vui lòng nhập lại");
                checkSearchMenu = true;
            }

        }while (checkSearchMenu);

    }

    private void editProductView() {
        boolean checkEditMenu = true;

        do {
            System.out.println("Chọn chức năng bạn muốn sửa");
            System.out.println("1. Sửa theo tên");
            System.out.println("2. Sửa theo giá");
            System.out.println("3. Sửa theo số lượng");
            try {
                int actionMenuEdit = Integer.parseInt(scanner.nextLine());
                switch (actionMenuEdit) {
                    case 1:
                        editNameProductView();
                        checkEditMenu = false;
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    default:
                        System.out.println("Nhập sai. Vui lòng nhập lại");
                        checkEditMenu = true;

                }
            } catch (NumberFormatException numberFormatException) {
                System.out.println("Nhập sai. Vui lòng nhập lại");
                checkEditMenu = true;
            }

        }while (checkEditMenu);

    }

    private void editNameProductView() {
        showProductsView(productService.getAllProducts());
        System.out.println("Chọn ID muốn sửa: ");
        long idProduct = Long.parseLong(scanner.nextLine());
        Product product = productService.findProductById(idProduct);

        System.out.println("Nhập tên mới: ");
        String nameProduct = scanner.nextLine();
        product.setName(nameProduct);

        productService.updateProduct(idProduct, product);
        showProductsView(productService.getAllProducts());
    }

    private boolean checkMenuActionContinue() {
        boolean checkMenuActionContinue = true;
        do{
            System.out.println("Bạn có muốn tiêp tục hay không");
            System.out.println("Nhấn (Y) - tiếp tục");
            System.out.println("Nhấn (N) - dừng lại");
            String actionMenuContinue = scanner.nextLine();
            switch (actionMenuContinue) {
                case "Y":
                    return true;
                case "N":
                    return false;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lai");
                    checkMenuActionContinue = true;
            }
        }while (checkMenuActionContinue);
        return false;
    }

    private void showProductsView(List<Product> products) {
        for (Product p : products) {
            System.out.printf("%-15s|%-20s|%-10s|%-5s|%10s\n", p.getId(), p.getName(), p.getPrice(), p.getQuantity(), p.getCreateAt());
        }
    }

    private void addProductView() {
        System.out.println("Nhập tên sản phẩm: ");
        String nameProduct = scanner.nextLine();
        System.out.println("Nhập giá sản phẩm: ");
        double priceProduct = Double.parseDouble(scanner.nextLine());
        System.out.println("Nhập số lượng: ");
        int quantity = Integer.parseInt(scanner.nextLine());

        Date createAt = new Date();
        long idProduct = System.currentTimeMillis()/1000;
        Product product = new Product(idProduct, nameProduct, priceProduct, quantity, createAt);
        productService.addProduct(product);

        showProductsView(productService.getAllProducts());
    }
}

package com.codegym.reviews4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static final int ACTIONEDIT = 2;
    private static final int ACTIONADD = 1;


    private CategoryService categoryService;
    private ProductService productService;




    public AppMain() {
        categoryService = new CategoryService();
        productService = new ProductService();
        productService.init();
        categoryService.init();
    }
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        AppMain appMain = new AppMain();
        boolean checkMenuAction = false;
        do {
            System.out.println("Bạn hãy chọn chức năng:");
            System.out.println("Thêm sản phẩm -->:              1");
            System.out.println("Sửa sản phẩm -->:               2");
            System.out.println("Xóa sản phẩm -->:               3");
            System.out.println("Xem danh sách sản phẩm -->:     4");
            System.out.println("Sap xep san pham -->:           5");
            System.out.println("Tìm kiếm san pham -->:          6");
            int menuAction = Integer.parseInt(scanner.nextLine());
            switch (menuAction) {
                case 1:
                    appMain.addProductView();
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                case 2:
                    appMain.editProductView();
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                case 4:
                    appMain.showProductsView(appMain.productService.getProducts());
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                case 5:
                    appMain.sortProductView();
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                case 6:
                    appMain.searchProductView();
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                    checkMenuAction = true;
                    break;
            }
        } while (checkMenuAction);
    }

    private void searchProductView() {
        // chỉ làm tìm kiếm theo tên
        System.out.println("Tìm kiếm theo tên:");
        String nameSearch = scanner.nextLine();

        List<Product> productResults = productService.searchByName(nameSearch);

        showProductsView(productResults);
    }

    private void sortProductView() {

        boolean menuAction = false;
        do{

            System.out.println("Bạn sắp xếp theo: ");
            System.out.println("Sửa Giá:-->         1");
            System.out.println("Sửa Tên:-->         2");
            System.out.println("Sửa Số lượng:-->    3");
            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    sortByPrice();
                    break;
                case 2:
                    sortByName();
                    break;
                case 3:
                    break;
                default:
                    System.out.println("Nhập sai. Vui lòng nhập lai");
                    break;
            }
        }while (menuAction);



    }

    private void sortByName() {
        List<Product> products = productService.getProducts();
        Comparator<Product> comparatorBy;
        boolean menuSortAction = false;
        do{
            menuSortAction = false;
            // Thấy có trùng lặp code cần tối ưu
            System.out.println("Chọn 1 - Tăng dần theo tên");
            System.out.println("Chọn 2 - Giảm dần theo tên");
            int menuSort = Integer.parseInt(scanner.nextLine());
            switch (menuSort) {
                case 1:
                    comparatorBy = new CompartorNameASC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getProducts());
                    break;
                case 2:
                    comparatorBy = new ComparatorNameDESC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getProducts());
                    break;
                default:
                    menuSortAction = true;
                    break;
            }
        }while (menuSortAction);
    }

    private void sortByPrice() {
        List<Product> products = productService.getProducts();
        Comparator<Product> comparatorBy;
        boolean menuSortAction = false;
        do{
            menuSortAction = false;
            System.out.println("Chọn 1 - Tăng dần theo giá");
            System.out.println("Chọn 2 - Giảm dần theo giá");
            int menuSort = Integer.parseInt(scanner.nextLine());
            switch (menuSort) {
                case 1:
                    comparatorBy = new ComparatorPriceASC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getProducts());
                    break;
                case 2:
                    comparatorBy = new ComparatorPriceDESC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getProducts());
                    break;
                default:
                    menuSortAction = true;
                    break;
            }
        }while (menuSortAction);
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
    public void showProductsView(List<Product> products) {
        for (Product p : products) {
            System.out.println(p);
        }
    }

    public double inputPrice(ActionInput type) {
        double price = 0.0;
        boolean checkInputPrice = false;
        do {
            switch (type) {
                case ADD:
                    System.out.println("Nhập giá bạn muốn thêm: ");
                    break;
                case EDIT:
                    System.out.println("Nhập giá bạn muốn sửa: ");
                    break;
            }
            price = Double.parseDouble(scanner.nextLine());
            checkInputPrice = false;
            if (price < 0 || price > 10000000) {
                System.out.println("Giá phải lớn 0 và nhỏ hơn 10000000");
                checkInputPrice = true;
            }

        } while (checkInputPrice);
        return price;
    }
    public void addProductView() {
        System.out.println("Nhập tên: ");
        String name = scanner.nextLine();
        double price = inputPrice(ActionInput.ADD);

        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ID của danh mục");
        for (int i = 0; i < categoryService.getCategories().size(); i++) {
            System.out.println(categoryService.getCategories().get(i));
        }
        int idCategory = Integer.parseInt(scanner.nextLine());
        Product product  = new Product();
        product.setId(System.currentTimeMillis()/1000);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setIdCategory(idCategory);


        productService.addProduct(product);
        showProductsView(productService.getProducts());
    }
    public void editProductView() {
        System.out.println("Nhập ID sản phẩm: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Bạn muốn sửa: ");
        System.out.println("Sửa tên:-->         1");
        System.out.println("Sửa giá:-->         2");
        System.out.println("Sửa số lượng:-->    3");

        // Về làm chỗ này, do while đó nha
        double price = inputPrice(ActionInput.EDIT);
        for (Product p : productService.getProducts()) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
        showProductsView(productService.getProducts());

    }
}

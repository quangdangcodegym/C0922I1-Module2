package com.codegym.reviews4;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppMain {
    public static List<Product> products;
    public static List<Category> categories;

    public static Category findCategoryById(int id) {
        for (Category c : categories) {
            if (c.getId() == id) {
                return c;
            }
        }
        return null;
    }
    public AppMain() {
        categories = new ArrayList<>();
        categories.add(new Category(1, "Apple"));
        categories.add(new Category(2, "Samsung"));

        products = new ArrayList<>();
        // long id, String name, double price, int quantity, int idCategory)
        Product product1 = new Product(1L, "Iphone 11", 1000.0, 10, 1);
        Product product2 = new Product(2L, "Iphone 12", 1200.0, 10, 1);
        Product product3 = new Product(3L, "Iphone 13", 1300.0, 10, 1);
        Product product4 = new Product(4L, "Iphone 14", 1400.0, 10, 1);
        products.add(product1);

        products.add(new Product(5L, "Samsung Galaxy", 1500.0, 10, 2) );
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
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
                    appMain.showProductsView();
                    checkMenuAction = appMain.checkContinueAction();
                    break;
                default:
                    System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                    checkMenuAction = true;
                    break;
            }
        } while (checkMenuAction);
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
    public void showProductsView() {
        for (Product p : getProducts()) {
            System.out.println(p);
        }
    }

    public double inputPrice(int type) {
        double price = 0.0;
        boolean checkInputPrice = false;
        do {
            switch (type) {
                case 1:
                    System.out.println("Nhập giá bạn muốn thêm: ");
                    break;
                case 2:
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
        double price = inputPrice(1);

        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ID của danh mục");
        for (int i = 0; i < categories.size(); i++) {
            System.out.println(categories.get(i));
        }
        int idCategory = Integer.parseInt(scanner.nextLine());
        Product product  = new Product();
        product.setId(System.currentTimeMillis()/1000);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);
        product.setIdCategory(idCategory);


        AppMain.products.add(product);
        showProductsView();
    }
    public void editProductView() {
        System.out.println("Nhập ID sản phẩm: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Bạn muốn sửa: ");
        System.out.println("Sửa tên:-->         1");
        System.out.println("Sửa giá:-->         2");
        System.out.println("Sửa số lượng:-->    3");

        // Về làm chỗ này, do while đó nha
        double price = inputPrice(2);
        for (Product p : getProducts()) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
        showProductsView();

    }
}

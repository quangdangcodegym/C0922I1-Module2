package com.codegym.view;

import com.codegym.model.*;
import com.codegym.comparator.ComparatorNameDESC;
import com.codegym.comparator.ComparatorPriceASC;
import com.codegym.comparator.ComparatorPriceDESC;
import com.codegym.comparator.CompartorNameASC;
import com.codegym.service.IProductService;
import com.codegym.service.ProductService;
import com.codegym.utils.ValidateUtils;

import java.util.Comparator;
import java.util.List;

public class ProductView extends ScreenView{
    private IProductService productService;


    public ProductView() {
        productService = new ProductService();
    }



    @Override
    public void launch() {
        if (this.getUser().getRole() == ERole.ADMIN) {
            boolean checkMenuAction = false;
            do {
                System.out.println("Bạn hãy chọn chức năng:");
                System.out.println("Thêm sản phẩm -->:              1");
                System.out.println("Sửa sản phẩm -->:               2");
                System.out.println("Xóa sản phẩm -->:               3");
                System.out.println("Xem danh sách sản phẩm -->:     4");
                System.out.println("Sap xep san pham -->:           5");
                System.out.println("Tìm kiếm san pham -->:          6");
                System.out.println("Quay lại        -->             7");
                System.out.print("Nhập: ");
                int menuAction = Integer.parseInt(scanner.nextLine());
                switch (menuAction) {
                    case 1:
                        addProductView();
                        break;
                    case 2:
                        editProductView();
                        break;
                    case 4:
                        //showProductsView(productService.getAllProduct());
                        showProductsViewWithPagging(productService.getAllProduct());
                        break;
                    case 5:
                        sortProductView();
                        break;
                    case 6:
                        searchProductView();
                        break;
                    case 7:
                        checkMenuAction = false;
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                        checkMenuAction = true;
                        break;
                }
            } while (checkMenuAction);
        }else{
            boolean checkMenuAction = false;
            do {
                System.out.println("Bạn hãy chọn chức năng:");
                System.out.println("Xem danh sách sản phẩm -->:     1");
                System.out.println("Sap xep san pham -->:           2");
                System.out.println("Tìm kiếm san pham -->:          3");
                System.out.println("Quay lại        -->             7");
                System.out.print("Nhập: ");
                int menuAction = Integer.parseInt(scanner.nextLine());
                switch (menuAction) {
                    case 1:
                        //showProductsView(productService.getAllProduct());
                        showProductsViewWithPagging(productService.getAllProduct());
                        break;
                    case 2:
                        sortProductView();
                        break;
                    case 3:
                        searchProductView();
                        break;
                    case 7:
                        checkMenuAction = false;
                        break;
                    default:
                        System.out.println("Chức năng không hợp lệ. Vui long nhập lại");
                        checkMenuAction = true;
                        break;
                }
            } while (checkMenuAction);
        }

    }

    private void searchProductView() {
        // chỉ làm tìm kiếm theo tên
        System.out.println("Tìm kiếm theo tên:");
        System.out.print("Nhập: ");
        String nameSearch = scanner.nextLine();

        List<Product> productResults = productService.searchByName(nameSearch);

        showProductsView(productResults);
    }

    private void sortProductView() {

        boolean menuAction = false;
        do {

            System.out.println("Bạn sắp xếp theo: ");
            System.out.println("Sắp xếp theo Giá:-->         1");
            System.out.println("Sắp xếp theo Tên:-->         2");
            System.out.println("Sắp xếp theo Số lượng:-->    3");
            System.out.print("Nhập: ");
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
        } while (menuAction);


    }

    private void sortByName() {
        List<Product> products = productService.getAllProduct();
        Comparator<Product> comparatorBy;
        boolean menuSortAction = false;
        do {
            menuSortAction = false;
            // Thấy có trùng lặp code cần tối ưu
            System.out.println("Chọn 1 - Tăng dần theo tên");
            System.out.println("Chọn 2 - Giảm dần theo tên");
            System.out.print("Nhập: ");
            int menuSort = Integer.parseInt(scanner.nextLine());
            switch (menuSort) {
                case 1:
                    comparatorBy = new CompartorNameASC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getAllProduct());
                    break;
                case 2:
                    comparatorBy = new ComparatorNameDESC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getAllProduct());
                    break;
                default:
                    menuSortAction = true;
                    break;
            }
        } while (menuSortAction);
    }

    private void sortByPrice() {
        List<Product> products = productService.getAllProduct();
        Comparator<Product> comparatorBy;
        boolean menuSortAction = false;
        do {
            menuSortAction = false;
            System.out.println("Chọn 1 - Tăng dần theo giá");
            System.out.println("Chọn 2 - Giảm dần theo giá");
            System.out.print("Nhập: ");
            int menuSort = Integer.parseInt(scanner.nextLine());
            switch (menuSort) {
                case 1:
                    comparatorBy = new ComparatorPriceASC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getAllProduct());
                    break;
                case 2:
                    comparatorBy = new ComparatorPriceDESC();
                    products.sort(comparatorBy);
                    showProductsView(productService.getAllProduct());
                    break;
                default:
                    menuSortAction = true;
                    break;
            }
        } while (menuSortAction);
    }


    public void showProductsView(List<Product> products) {
        for (Product p : products) {
            System.out.println(p.toView());
        }
    }

    public void showProductsViewWithPagging(List<Product> products) {
        int numberOfPage = 3;
//        List<Product> products1 = products.subList(0, 3);
//        List<Product> products2 = products.subList(3, 6);
//        List<Product> products3 = products.subList(6, 9);
//        List<Product> products4 = products.subList(9, products.size());

        int pageSize = (int) (Math.ceil(products.size() / numberOfPage));

        for (int i = 0; i <= pageSize; i++) {
            List<Product> products1;
            if (i == pageSize) {
                products1 = products.subList(i * numberOfPage, products.size());
            }else{
                products1 = products.subList(i * numberOfPage, (i + 1) * numberOfPage);
            }
            for (Product p : products1) {
                System.out.println(p.toView());
            }
            scanner.nextLine();

        }
    }

    public String inputProductName() {
        String name;
        boolean checkInputNameProduct;
        do {
            checkInputNameProduct = true;
            System.out.println("Nhập tên (Phải bắt đầu chữ hoa): ");
            name = scanner.nextLine();
            if (ValidateUtils.validateProductName(name)) {
                checkInputNameProduct = false;
            }else{
                System.out.println("Nhập tên chưa đúng định dạng. Vui lòng nhập lại");
            }
        }while (checkInputNameProduct);
        return name;
    }
    public double inputPrice(EActionInput type) {
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
        String name = inputProductName();

        double price = inputPrice(EActionInput.ADD);

        System.out.println("Nhập số lượng");
        int quantity = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập ID của danh mục");
        for (ECategory eCategory : ECategory.values()) {
            System.out.println(eCategory + " nhap: " + eCategory.getId());
        }
        int idCategory = Integer.parseInt(scanner.nextLine());
        Product product = new Product();
        product.setId(System.currentTimeMillis() / 1000);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        product.setCategory(ECategory.findCategoryById(idCategory));


        productService.addProduct(product);
        showProductsView(productService.getAllProduct());
    }

    public void editProductView() {
        showProductsView(productService.getAllProduct());
        System.out.println("Nhập ID sản phẩm: ");
        long id = Long.parseLong(scanner.nextLine());

        System.out.println("Bạn muốn sửa: ");
        System.out.println("Sửa tên:-->         1");
        System.out.println("Sửa giá:-->         2");
        System.out.println("Sửa số lượng:-->    3");
        System.out.print("Nhập: ");

        // Về làm chỗ này, do while đó nha
        double price = inputPrice(EActionInput.EDIT);
        for (Product p : productService.getAllProduct()) {
            if (p.getId() == id) {
                p.setPrice(price);
            }
        }
        showProductsView(productService.getAllProduct());

    }
}

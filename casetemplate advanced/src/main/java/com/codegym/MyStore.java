package com.codegym;

import com.codegym.model.EMenuContinue;
import com.codegym.model.ERole;
import com.codegym.model.User;
import com.codegym.view.OrderView;
import com.codegym.view.ProductView;
import com.codegym.view.ScreenView;

import java.text.ParseException;
import java.util.Scanner;

public class MyStore {
    private static Scanner scanner = new Scanner(System.in);
    private ScreenView screenView;

    MyStore() {

    }
    public static void main(String[] args) throws ParseException {
        MyStore myStore = new MyStore();
        myStore.login();
    }
    public void login() {
        System.out.println("Login");
        System.out.println("Username: ");
        String username = scanner.nextLine();
        System.out.println("Password: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("123123")) {
           showMenuAdmin(username, password);
        }else{
            if(username.equals("user") && password.equals("123123")){
                showMenuUser(username, password);
            }
        }
    }

    private void showMenuUser(String username, String password) {
        screenView = new ProductView();
        screenView.setUser(new User(username, password, ERole.USER));
        screenView.launch();

        boolean checkMenuUser = true;
        do {
            System.out.println("Menu user");
            System.out.println("1. User");
            System.out.println("2. Product");
            System.out.println("3. Exit");
            System.out.print("Nhập: ");
            int actionMenuUser = Integer.parseInt(scanner.nextLine());
            switch (actionMenuUser) {
                case 1:
//                            screenView = new OrderView();
                    break;
                case 2:
                    screenView = new ProductView();
                    screenView.setUser(new User(username, password, ERole.USER));
                    screenView.launch();
                    break;
                case 3:
                    checkMenuUser = false;
                    break;
            }
            checkMenuUser = screenView.checkContinueAction(EMenuContinue.CONTINUE, EMenuContinue.MENU_USER);
        } while (checkMenuUser);
    }

    private void showMenuAdmin(String username, String password) {
        boolean checkMenuAdmin = true;
        do {
            System.out.println("Menu admin");
            System.out.println("1. Order");
            System.out.println("2. Product");
            System.out.println("3. Exit");
            System.out.print("Nhập: ");
            int actionMenuAdmin = Integer.parseInt(scanner.nextLine());
            switch (actionMenuAdmin) {
                case 1:
                    screenView = new OrderView();
                    screenView.setUser(new User(username, password, ERole.ADMIN));
                    screenView.launch();
                    break;
                case 2:
                    screenView = new ProductView();
                    screenView.setUser(new User(username, password, ERole.ADMIN));
                    screenView.launch();
                    break;
                case 3:
                    checkMenuAdmin = false;
                    break;
            }
            if(!checkMenuAdmin)
                checkMenuAdmin = screenView.checkContinueAction(EMenuContinue.CONTINUE, EMenuContinue.MENU_ADMIN);
        } while (checkMenuAdmin);
    }
}

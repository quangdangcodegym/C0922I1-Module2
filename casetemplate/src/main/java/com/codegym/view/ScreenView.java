package com.codegym.view;

import com.codegym.model.EMenuContinue;
import com.codegym.model.User;

import java.util.Scanner;

public abstract class ScreenView {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void launch();
    public boolean checkContinueAction(EMenuContinue eMenuContinue) {
        String strMenuContinue = String.format("Bạn có muốn tiếp tục %s hay không Yes(Y)/No(N)", eMenuContinue.getValue());
        System.out.println(strMenuContinue);
        String continueAction = scanner.nextLine();
        switch (continueAction) {
            case "Y":
                return true;
            case "N":
                return false;
        }
        return false;
    }

    private User user;

    public Scanner getScanner() {
        return scanner;
    }

    public void setScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

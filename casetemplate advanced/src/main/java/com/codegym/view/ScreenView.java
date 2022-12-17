package com.codegym.view;

import com.codegym.model.EMenuContinue;
import com.codegym.model.User;

import java.util.Scanner;

public abstract class ScreenView {
    protected Scanner scanner = new Scanner(System.in);

    public abstract void launch();
    public boolean checkContinueAction(EMenuContinue eActionMenuContinue, EMenuContinue eMenuContinue) {
        String strMenuContinue = String.format("Bạn có muốn %s %s hay không Yes(Y)/No(N)", eActionMenuContinue.getValue(), eMenuContinue.getValue());
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

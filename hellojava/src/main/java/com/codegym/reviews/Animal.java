package com.codegym.reviews;

public abstract class Animal {
    protected static String name;
    public abstract void getName();

    public static void showInfo() {
        System.out.println(name);
    }
    public void getFulName(){
        System.out.println("Animal fullName: " + name);
    }
}

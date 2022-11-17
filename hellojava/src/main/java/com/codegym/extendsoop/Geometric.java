package com.codegym.extendsoop;

public class Geometric {
    private String color = "white";

    public String getColor() {
        return color;
    }
    public Geometric() {
        super();
        System.out.println("Khoi tao khong tham so Geometric");
    }

    public Geometric(String color) {
        this.color = color;
    }
}

package com.codegym.extendsoop;

public class Rectangle extends Geometric{

    private double  width;
    private double height;
    public Rectangle() {

    }

    public Rectangle(double width, double height) {
        super();
        System.out.println("Khoi tao khong tham so Rectangle");
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }



}

package com.codegym.comparatoroop;

public class Rectangle extends Geometric{

    private double  width;
    private double height;
    public Rectangle() {

    }

    @Override
    public double getArea() {
        return this.height * this.width;
    }

    @Override
    public double getPerimeter() {
        return  (this.height + this.width)*2;
    }

    public Rectangle(double width, double height) {
        super();
        this.width = width;
        this.height = height;
    }

    public Rectangle(double width, double height, String color) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public String toString() {
        return String.format("{w: %s,h: %s}", this.width, this.height);
    }


}

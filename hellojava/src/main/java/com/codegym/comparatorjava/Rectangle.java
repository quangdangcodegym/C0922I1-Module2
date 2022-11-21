package com.codegym.comparatorjava;

public class Rectangle extends Geometric implements Comparable<Rectangle>{

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


    @Override
    public int compareTo(Rectangle o) {
        if (this.getArea() > o.getArea()) {
            return 1;
        }else {
            if (this.getArea() == o.getArea()) {
                return 0;
            }
            return -1;
        }
    }
}

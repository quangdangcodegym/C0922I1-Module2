package com.codegym.cylinder;

public class Cylinder extends  Circle{
    private double height;
    public Cylinder() {
        super();
    }

    public Cylinder(double radius, double height, String color) {
        super(radius, color);
        this.height = height;

    }

    @Override
    public String toString() {
        return "{" + this.radius + "," +  this.color + "," + this.height + "}";
    }
}

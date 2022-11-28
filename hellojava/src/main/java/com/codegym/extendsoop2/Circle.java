package com.codegym.extendsoop2;

public class Circle {
    public Circle() {

    }

    public Circle(double radius) {
        this.radius = radius;
    }
    private double radius;

    public double getRadius() {
        return radius;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public double getArea(){
        return Math.PI * radius * radius;
    }
}

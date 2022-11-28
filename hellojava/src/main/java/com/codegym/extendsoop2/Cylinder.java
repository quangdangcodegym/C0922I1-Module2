package com.codegym.extendsoop2;

public class Cylinder extends Circle {
    private double height;

   public Cylinder() {

   }

   public Cylinder(double height, double r) {
       this.height = height;
       setRadius(r);
   }

    @Override
    public double getArea() {
        return Math.PI * 2 * this.getRadius() * (super.getRadius() + this.height);
    }

    public double getTheTich() {
        return super.getArea() * height;
    }

    @Override
    public double getRadius() {
        return  1.0;
    }
}

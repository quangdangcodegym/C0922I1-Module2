package com.codegym.abstractopp;

public class Circle extends Geometry{
    private double r;
    public Circle(){}
    public Circle(Point toaDo, double r) {
        this.r = r;
    }
//    abstract getArea(){} loi bien dich vi Circle khong phai la abstract class

    public double getR() {
        return r;
    }

    public void setR(double r) {
        this.r = r;
    }

    @Override
    public double Area() {
        return Math.PI*this.r*this.r;
    }   // Ghi de lai phuong thuc abstract
}

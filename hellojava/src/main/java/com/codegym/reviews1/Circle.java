package com.codegym.reviews1;

public class Circle extends Hinhhoc {
    private int radius;

    public Circle(int radius) {
        this.radius = radius;
    }

    @Override
    public String toString() {
        return "I am a Circle, my radius is " + this.radius;

    }

    public Circle() {
        System.out.println(super.toString());
    }

    public int getRadius() {
        return radius;
    }

    public static void main(String[] args) {
//        Circle circle = new Circle();
//        System.out.println(circle.toString());
        Hinhhoc c = new Circle(3);
        Circle d = (Circle)c;
        System.out.println(d.getRadius());
        System.out.println(c.toString());
    }
}


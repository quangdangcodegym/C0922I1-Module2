package com.codegym.comparatoroop;

public abstract class Geometric {
    private String color = "white";

    public String getColor() {
        return color;
    }
    public Geometric() {
        super();
    }

    public Geometric(String color) {
        this.color = color;
    }

    public abstract double getArea();

    public abstract double getPerimeter();

    @Override
    public String toString() {
        return " " + this.color;
    }
}

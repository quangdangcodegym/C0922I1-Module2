package com.codegym.extendsoop;

public class My_class2 {

    public static void main(String args[]) {
        // Instantiating the outer class
        Outer_Demo outer = new Outer_Demo();

        // Instantiating the inner class
        Outer_Demo.Inner_Demo inner = outer.new Inner_Demo();

        System.out.println(inner.getNum());
    }
}
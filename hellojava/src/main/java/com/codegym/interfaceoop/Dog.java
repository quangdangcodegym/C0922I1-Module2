package com.codegym.interfaceoop;

public class Dog implements Move{
    @Override
    public void dichuyen(int distance) {
        System.out.println("Con cho di chuyen " + distance);
    }
}

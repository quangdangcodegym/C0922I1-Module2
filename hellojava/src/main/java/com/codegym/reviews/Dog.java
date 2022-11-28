package com.codegym.reviews;

public class Dog extends Animal{
    @Override
    public void getName() {
          System.out.println("Con cho ten: " + Animal.name);
    }

    @Override
    public void getFulName() {
        System.out.println("Con cho FullName: " + name);
    }
}

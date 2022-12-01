package com.codegym.reviews6;

public class MainApp {
    public static void main(String[] args) {
        Animal[] animals = new Animal[3];
        animals[0] = new Chicken("Ga da ");
        animals[1] = new Tiger();
        animals[2] = new Chicken("Ga kien ");

        for (int i = 0; i < animals.length; i++) {
            System.out.println(animals[i].makeSound());
        }
    }
}

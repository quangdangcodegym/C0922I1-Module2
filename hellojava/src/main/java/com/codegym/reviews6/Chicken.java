package com.codegym.reviews6;

public class Chicken extends Animal implements Edible{


    public Chicken() {
        super();
    }

    public Chicken(String tenConGa) {
        super(tenConGa);
    }
    @Override
    public String makeSound() {
        return this.name + " O o o";
    }

    @Override
    public String howtoEat() {
        return "Luộc chấm muối tiêu";
    }
}

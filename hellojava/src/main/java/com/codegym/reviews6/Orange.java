package com.codegym.reviews6;

public class Orange extends Fruit implements Edible{
    @Override
    public void sayKho() {
        System.out.println("Sấy mất 1 ngày");
    }

    @Override
    public String howtoEat() {
        return "Lột vỏ, bóc múi, ăn";
    }
}

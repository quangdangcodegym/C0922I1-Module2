package com.codegym.reviews6;

public class Apple extends Fruit implements Edible{
    @Override
    public void sayKho() {
        System.out.println("Sấy khô mất nửa ngày");
    }

    @Override
    public String howtoEat() {
        return "Gọt vỏ, ăn";
    }
}

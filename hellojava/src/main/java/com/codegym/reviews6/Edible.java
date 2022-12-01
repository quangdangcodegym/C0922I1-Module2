package com.codegym.reviews6;

public interface Edible {
    // Chỉ chứa các hằng só và phương thức abstract
    public abstract String howtoEat();

    // Mặc định hằng số trong interface là public final nên mình khong can khai bao
    public final int maxDate = 5;
}

package com.codegym.reviews3.cau10;

public class TestOverriding {
    public static void main(String[] args) {
        Super superRef = new Sub();
        Sub subRef = new Sub();
        Super suRef = new Super();

        superRef.tests();
        subRef.tests();
        suRef.tests();
    }
}

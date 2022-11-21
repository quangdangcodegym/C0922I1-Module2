package com.codegym.mylist;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private final int DEFAUTL_SIZE = 5;
    private Object elements [];

    public MyList() {
        elements = new Object[DEFAUTL_SIZE];
        size = 0;
    }

    public void add(E e) {
        if (size >= DEFAUTL_SIZE) {
            ensureCapa();
        }
        elements[size] = e;
        size++;
    }

    private void ensureCapa() {
        elements = Arrays.copyOf(elements, DEFAUTL_SIZE*2);
    }

    public static void main(String[] args) {
        MyList<Integer> objs = new MyList<>();
        objs.add(3);
        objs.add(1);
        objs.add(3);
        objs.add(1);
        objs.add(7);
    }
}

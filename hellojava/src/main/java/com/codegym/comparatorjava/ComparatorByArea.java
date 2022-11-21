package com.codegym.comparatorjava;

import java.util.Comparator;

public class ComparatorByArea implements Comparator<Geometric> {
    @Override
    public int compare(Geometric r1, Geometric r2) {
//        Rectangle r1 = (Rectangle) o1;
//        Rectangle r2 = (Rectangle) o2;

        if (r1.getArea() > r2.getArea()) {
            return 1;
        }else {
            if (r1.getArea() == r2.getArea()) {
                return 0;
            }
            return -1;
        }
    }
}

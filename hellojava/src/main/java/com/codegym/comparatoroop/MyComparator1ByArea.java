package com.codegym.comparatoroop;

import java.util.Comparator;

public class MyComparator1ByArea implements Comparator<Rectangle> {
    @Override
    public int compare(Rectangle r1, Rectangle r2) {
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

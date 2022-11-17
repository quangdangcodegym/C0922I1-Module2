package com.codegym.comparatoroop;

public class MyComparatorByArea implements MyComparator{
    @Override
    public int compareTo(Object obj1, Object obj2) {
        Rectangle r1 = (Rectangle) obj1;
        Rectangle r2 = (Rectangle) obj2;

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

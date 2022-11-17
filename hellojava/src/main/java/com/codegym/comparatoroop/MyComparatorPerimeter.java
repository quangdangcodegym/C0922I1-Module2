package com.codegym.comparatoroop;

public class MyComparatorPerimeter implements MyComparator{
    @Override
    public int compareTo(Object obj1, Object obj2) {
        Rectangle r1 = (Rectangle) obj1;
        Rectangle r2 = (Rectangle) obj2;

        if (r1.getPerimeter() > r2.getPerimeter()) {
            return 1;
        }else {
            if (r1.getPerimeter() == r2.getPerimeter()) {
                return 0;
            }
            return -1;
        }
    }
}

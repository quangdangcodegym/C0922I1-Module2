package com.codegym.comparatorjava;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {
        sudungcomparablecobanSAICUAJAVA();
    }
    public static void sudungcomparablecobanSAICUAJAVA() {
        Geometric[] geometrics = new Geometric[5];

        geometrics[0] = new Rectangle(4, 6);
        geometrics[1] = new Rectangle(1, 6);
        geometrics[2] = new Rectangle(3, 6);
        geometrics[3] = new Rectangle(1, 1);
        geometrics[4] = new Rectangle(2, 2);

        System.out.println(Arrays.toString(geometrics));
        Comparator<Geometric> c = new ComparatorByArea();

//        Arrays.sort(geometrics, c);


        System.out.println(Arrays.toString(geometrics));

    }
}

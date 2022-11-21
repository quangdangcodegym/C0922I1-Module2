package com.codegym.comparatoroop;

import java.util.Arrays;
import java.util.Comparator;

public class App {
    public static void main(String[] args) {

    }
    public static void hieuvethuattoansapxep(){
        int[] arr = {5, 6, 7, 1, 3};
        for (int i = 0; i<arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] < arr[j]) {
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    public static void sudungcomparator() {
        Geometric[] geometrics = new Geometric[5];
        MyComparator myComparator = new MyComparatorPerimeter();

        geometrics[0] = new Rectangle(4, 6);
        geometrics[1] = new Rectangle(1, 6);
        geometrics[2] = new Rectangle(3, 6);
        geometrics[3] = new Rectangle(1, 1);
        geometrics[4] = new Rectangle(2, 2);

        System.out.println(Arrays.toString(geometrics));
        for (int i = 0; i<geometrics.length - 1; i++) {
            for (int j = i + 1; j < geometrics.length; j++) {
                if (myComparator.compareTo(geometrics[i], geometrics[j]) == 1) {
                    Geometric temp = geometrics[i];
                    geometrics[i] = geometrics[j];
                    geometrics[j] = temp;
                }
            }
        }
        System.out.println(Arrays.toString(geometrics));
    }

    public static void sudungcomparablecoban() {




        Geometric[] geometrics = new Geometric[5];

        geometrics[0] = new Rectangle(4, 6);
        geometrics[1] = new Rectangle(1, 6);
        geometrics[2] = new Rectangle(3, 6);
        geometrics[3] = new Rectangle(1, 1);
        geometrics[4] = new Rectangle(2, 2);

        System.out.println(Arrays.toString(geometrics));
        for (int i = 0; i<geometrics.length - 1; i++) {
            for (int j = i + 1; j < geometrics.length; j++) {
                Rectangle r1 = (Rectangle) geometrics[i];
                Rectangle r2 = (Rectangle) geometrics[j];

            }
        }
        System.out.println(Arrays.toString(geometrics));

    }
    public static void sudungcomparablecobanSAICUAJAVA() {
        Geometric[] geometrics = new Geometric[5];

        geometrics[0] = new Rectangle(4, 6);
        geometrics[1] = new Rectangle(1, 6);
        geometrics[2] = new Rectangle(3, 6);
        geometrics[3] = new Rectangle(1, 1);
        geometrics[4] = new Rectangle(2, 2);

        System.out.println(Arrays.toString(geometrics));
        System.out.println(Arrays.toString(geometrics));

    }
}

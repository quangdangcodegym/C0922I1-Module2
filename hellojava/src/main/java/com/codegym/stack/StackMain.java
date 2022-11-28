package com.codegym.stack;

import java.util.Arrays;
import java.util.Stack;

public class StackMain {
    public static void main(String[] args) {
        int number = 5;
        Stack<Integer> decimal =new Stack<>();

       while (number!=0){
           decimal.push(number%2);
           number= number/2;
       }

        String binary = "";
        while (!decimal.isEmpty()) {
            binary += decimal.pop();
        }
        System.out.println(binary);

    }
    public void chuyendoinhiphanStack() {
        int number = 5;
        Stack<Integer> decimal =new Stack<>();
        int division = number;
        do{
            decimal.push(division%2);
            division = division/2;
        }while (division!=0);

        String binary = "";
        while (!decimal.isEmpty()) {
            binary += decimal.pop();
        }
        System.out.println(binary);
    }
    public void daonguocmangdungStack() {
        int [] arr = {1,2,3,4,5};
        Stack<Integer> stack = new Stack<>();
        for (int i=0; i<arr.length;i++){
            stack.push(arr[i]);
        }
        System.out.println(Arrays.toString(arr));
        int[] reverseArr = new int[arr.length];
        int counter = 0;
        while (!stack.isEmpty()) {
            reverseArr[counter] = stack.pop();
            counter++;
        }
        System.out.println(Arrays.toString(reverseArr));
    }
}

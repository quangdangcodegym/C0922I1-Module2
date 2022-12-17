package com.codegym.thread.runable;

import com.codegym.thread.ThreadNumber;
import com.codegym.thread.ThreadPrintChar;
import com.codegym.thread.runable.PrintChar;
import com.codegym.thread.runable.PrintNumber;

public class Main {
    public static void main(String[] args) {

//        PrintChar printCharA = new PrintChar('a', 100);
//        PrintNumber printNumber = new PrintNumber(100);
//        PrintChar printCharB = new PrintChar('b', 100);
//
//        Thread thread1 = new Thread(printCharA);
//        Thread thread2 = new Thread(printCharB);
//        Thread thread3 = new Thread(printNumber);
//
//        thread1.start();
//        // a:
//        thread2.start();
//        thread3.start();

        Runnable temp;
        Thread thread4 = new Thread(temp = new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 50; i++) {
                    System.out.println("C09.........");
                }
            }
        });

        PrintC09 printC09 = new PrintC09();
        Thread thread5 = new Thread(printC09);

        Thread thread6 = new Thread(temp);
        thread6.start();




        /**
        ThreadNumber threadNumber = new ThreadNumber(100);
        ThreadPrintChar threadPrintChar = new ThreadPrintChar('a', 100);
        threadPrintChar.start();
        threadNumber.start();
         **/


    }
}

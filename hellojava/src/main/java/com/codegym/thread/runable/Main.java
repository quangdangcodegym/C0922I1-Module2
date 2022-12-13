package com.codegym.thread;

public class Main {
    public static void main(String[] args) {
        PrintChar printCharA = new PrintChar('a', 100);
        PrintNumber printNumber = new PrintNumber(100);
        PrintChar printCharB = new PrintChar('b', 100);

        Thread thread1 = new Thread(printCharA);
        Thread thread2 = new Thread(printCharB);
        Thread thread3 = new Thread(printNumber);
        
        thread1.start();
        thread2.start();
        thread3.start();
    }
}

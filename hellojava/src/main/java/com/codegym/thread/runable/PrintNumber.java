package com.codegym.thread;

public class PrintNumber implements Runnable{
    private int number;

    public PrintNumber(int number) {
        this.number = number;
    }
    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println("i: " + i);
        }
    }
}

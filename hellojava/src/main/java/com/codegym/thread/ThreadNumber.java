package com.codegym.thread;

public class ThreadNumber extends Thread{
    private int number;

    public ThreadNumber(int number) {
        this.number = number;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println("i: " + i);
        }
    }
}

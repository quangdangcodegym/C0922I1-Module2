package com.codegym.thread;

public class ThreadPrintChar extends Thread{
    private char charToPrint;
    private int number;

    public ThreadPrintChar(char c, int number) {
        this.number = number;
        this.charToPrint = c;
    }

    @Override
    public void run() {
        for (int i = 0; i < number; i++) {
            System.out.println(charToPrint + " i: " + i);
        }
    }
}

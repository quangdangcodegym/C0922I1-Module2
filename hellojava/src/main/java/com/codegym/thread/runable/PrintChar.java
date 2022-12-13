package com.codegym.thread;

public class PrintChar implements Runnable{
    private char charToPrint;
    private int number;

    PrintChar(char c, int number) {
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

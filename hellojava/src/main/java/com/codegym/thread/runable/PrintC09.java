package com.codegym.thread.runable;

public class PrintC09 implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 50; i++) {
            System.out.println("C09.........");
        }
    }
}

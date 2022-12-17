package com.codegym.ThreadCount;

public class Main {
    public static void main(String[] args) {
        Count count = new Count();
        while (count.getThread().isAlive()) {
            System.out.println("Main will be alive until child thread end");
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                System.out.println("Main thread interupted");
            }
        }
        System.out.println("Main thread ended");
    }
}

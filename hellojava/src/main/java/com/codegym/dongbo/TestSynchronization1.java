package com.codegym.dongbo;

public class TestSynchronization1 {
    public static void main(String args[]) throws InterruptedException {
        Table obj = new Table();// tao mot object
        MyThread1 t1 = new MyThread1(obj);

        MyThread2 t2 = new MyThread2(obj);


        t1.start();
        t2.start();

    }
}

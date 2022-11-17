package com.codegym.oop;

public class Application {
    public static void main(String[] args) throws InterruptedException {
        StopWatch stopWatch = new StopWatch();

        // Chay mat het 10s
        Thread.sleep(5000);
        stopWatch.setEndTime();
        System.out.println(stopWatch.getTime());
    }
}

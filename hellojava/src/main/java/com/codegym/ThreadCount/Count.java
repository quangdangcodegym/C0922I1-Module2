package com.codegym.ThreadCount;

import com.codegym.thread.ThreadNumber;

public class Count implements Runnable{
    private  Thread thread;

    public Count() {
        thread = new Thread(this, "count thread");
        System.out.println("Count thread created "+ thread);
        thread.start();
    }

    public Thread getThread() {
        return thread;
    }

    @Override
    public void run() {
        try {
            for (int i = 0; i < 10; i++) {
                System.out.println("Count thread counting " + (i + 1));
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("Count thread interupted");
        }
        System.out.println("Count thread ended");
    }
}

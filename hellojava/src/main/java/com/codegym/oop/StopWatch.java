package com.codegym.oop;

public class StopWatch {
     private long startTime, stopTime;

     public StopWatch() {
         this.startTime = System.currentTimeMillis();
     }

    public void setEndTime() {
         this.stopTime = System.currentTimeMillis();
    }

    public double getTime() {
         return stopTime - startTime;
    }

    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(long startTime) {
        this.startTime = startTime;
    }

    public long getStopTime() {
        return stopTime;
    }

    public void setStopTime(long stopTime) {
        this.stopTime = stopTime;
    }


}

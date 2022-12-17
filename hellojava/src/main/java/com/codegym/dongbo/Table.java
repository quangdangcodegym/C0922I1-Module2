package com.codegym.dongbo;

public class Table {
      void printTable(int n) {// method không synchronized
          System.out.println(" ---------- " + n);
          synchronized (this) {
              for (int i = 1; i <= 5; i++) {
                  System.out.println(n * i);
                  try {
                      Thread.sleep(400);
                  } catch (Exception e) {
                      System.out.println(e);
                  }
              }
          }


    }
}

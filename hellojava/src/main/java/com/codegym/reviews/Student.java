package com.codegym.reviews;

public class Student {
    int age;



    public Student(int age) {
        this.age = age++;

        Student c1 = new Student(42);
    }

    public static void main(String[] args) {



        Student c = new Student(42);
        c.go();

    }
    void go() {
        System.out.println(++age);
    }
}

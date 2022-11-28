package com.codegym.accessmodifier1;

public class Student {
    private int rollno;
    private String name;
    private static String college = "BBDIT";

//    constructor to initialize the variable
    public Student(int r, String n) {
        rollno = r;
        name = n;
    }

    //static method to change the value of static variable
    public static void change() {
        college = "CODEGYM";
    }

    //method to display values
    public void display() {
        System.out.println(rollno + " " + name + " " + college);
    }


}

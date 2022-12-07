package com.codegym;

public class Student {
    private long id;
    private String name;
    public Student() {

    }

    public Student(long id, String name) {
        this.id = id;
        this.name = name;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("%-10s|  %-20s", this.id, this.name);
    }
}

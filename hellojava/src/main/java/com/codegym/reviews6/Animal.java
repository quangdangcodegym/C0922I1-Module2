package com.codegym.reviews6;

// lớp abstract thì không thể final
public abstract class Animal {
    // lớp abstract có thể thuộc tính và phương thức bình thường
    protected String name;
    public String getName() {
        return this.name;
    }

    public Animal(String name) {
        this.name = name;
    }
    public Animal() {

    }

    // Nếu trong 1 lớp mà có 1 phương thuc la abstract thì lớp đó phải là abstract
    // Phương thức abstract không thể là final
    public abstract String makeSound();


}

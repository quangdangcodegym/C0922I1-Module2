package com.codegym.accessmodifier1;

public class Car {
    private String name;

    private String engine;


    public Car() {

    }
    public Car(String name, String engine) {
        this.name = name;
        this.engine = engine;
        Company.numberOfCars++;
    }

    public void doXang() {
        if (engine.contains("v1")) {
            System.out.println("Do 50k xang");
        }
        if (engine.contains("v5")) {
            System.out.println("Do 10k xang");
        }
    }

    public static void main(String[] args) {
        Car car1 = new Car("Mazda 3","Skyactiv 3");
        System.out.println(Company.numberOfCars);
        Car car2 = new Car("Mazda 6","Skyactiv 6");
        System.out.println(Company.numberOfCars);
        Car car3 = new Car("sdf", "gggg");
        System.out.println(Company.numberOfCars);

    }

}

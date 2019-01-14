package com.app;

public class Car extends Vehicle {
    private int wheels;
    private int gear = 0;
    String model;

    public Car(String model, int passengers, int wheels) {
        super(passengers);
        this.model = model;
        this.wheels = wheels;
    }

    public void changeGear(int gear) {
        this.gear = gear;
        System.out.println("Now in " + gear + " gear");
    }
}

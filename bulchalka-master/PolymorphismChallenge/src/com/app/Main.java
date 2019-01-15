package com.app;

class Car {
    private String name;
    private int cylinders;
    private int engine;
    private int wheels;

    public Car(String name, int cylinders) {
        this.name = name;
        this.cylinders = cylinders;
        this.engine = 1;
        this.wheels = 4;
    }

    public void startEngine() {
        System.out.println("Engine started!");
    }

    public void accelerate() {
        System.out.println("Speed increasing!");
    }

    public void brake() {
        System.out.println("Speed decreasing!");
    }
}

class Fit extends Car {
    public Fit() {
        super("Fit", 4);
    }

    @Override
    public void startEngine() {
        System.out.println("Fits engine started!");
    }

    @Override
    public void accelerate() {
        System.out.println("Fits speed increasing!");
    }

    @Override
    public void brake() {
        System.out.println("Fits speed decreasing!");
    }
}

class Tiguan extends Car {
    public Tiguan() {
        super("Tiguan", 6);
    }

    @Override
    public void startEngine() {
        System.out.println(getClass().getSimpleName() + " engine started!");
    }

    @Override
    public void accelerate() {
        System.out.println(getClass().getSimpleName() + " speed increasing!");
    }

    @Override
    public void brake() {
        System.out.println(getClass().getSimpleName() + " speed decreasing!");
    }
}


public class Main {

    public static void main(String[] args) {
        Car fit = new Fit();
        Car tiguan = new Tiguan();
        fit.startEngine();
        tiguan.startEngine();
        fit.accelerate();
        tiguan.accelerate();
        fit.brake();
        tiguan.brake();
    }
}

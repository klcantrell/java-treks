package com.app;

public class Dog extends Animal {
    private int eyes;
    private int legs;
    private int tail;
    private int teeth;
    private String breed;

    public Dog(String name, int size, int weight, int eyes, int legs, int tail, int teeth, String breed) {
        super(name, 1, 1, size, weight);
        this.eyes = eyes;
        this.legs = legs;
        this.tail = tail;
        this.teeth = teeth;
        this.breed = breed;
    }

    private void chew() {
        System.out.println("Dog.chew called");
    }

    @Override
    public void eat() {
        System.out.println("Dog.eat called");
        chew();
        super.eat();
    }

    public void walk() {
        System.out.println("Dog.walk called");
        super.move(5); // skip dogs overridden method can go straight to super
    }

    public void run() {
        System.out.println("Dog.run called");
        move(10);
    }

    private void moveLegs() {
        System.out.println("Dog.moveLegs called");
    }

    @Override
    public void move(int speed) {
        System.out.println("Dog.move called");
        moveLegs();
        super.move(5);
    }
}

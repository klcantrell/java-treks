package com.app;

public class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Dog " + getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Dog " + getName() + " is breathing");
    }
}

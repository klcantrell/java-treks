package com.app;

public abstract class Bird extends Animal {
    public Bird(String name) {
        super(name);
    }

    @Override
    public void eat() {
        System.out.println("Bird " + getName() + " is eating");
    }

    @Override
    public void breathe() {
        System.out.println("Bird " + getName() + " is breathing");
    }

    public abstract void fly();
}

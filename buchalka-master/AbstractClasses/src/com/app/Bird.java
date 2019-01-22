package com.app;

// when to use interfaces vs inheritance?  consider is-a vs has-a relationships.
// if "is-a", then inheritance.  if "has-a", then composition with the help of interfaces.

public abstract class Bird extends Animal implements CanFly {
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

    public void fly() {
        System.out.println("Flapping wings");
    };
}

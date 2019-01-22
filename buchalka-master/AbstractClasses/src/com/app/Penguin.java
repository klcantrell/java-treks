package com.app;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        super.fly();
        System.out.println(getName() + " is not very good at that....I wonder if this was the best way to create reusable bird code");
    }
}

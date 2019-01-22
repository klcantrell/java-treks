package com.app;

public class Penguin extends Bird {
    public Penguin(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("I'm not very good at that....I wonder if this was the best way to create reusable bird code");
    }
}

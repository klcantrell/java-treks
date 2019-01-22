package com.app;

public class Parrot extends Bird {
    public Parrot(String name) {
        super(name);
    }

    @Override
    public void fly() {
        System.out.println("Parrot " + getName() + " flitting from branch to branch");
    }
}

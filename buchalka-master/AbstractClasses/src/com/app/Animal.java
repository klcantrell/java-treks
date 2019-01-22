package com.app;

// when to use interfaces vs inheritance?  consider is-a vs has-a relationships.
// if "is-a", then inheritance.  if "has-a", then composition with the help of interfaces.
// check out Bird

public abstract class Animal {
    private String name;

    public Animal(String name) {
        this.name = name;
    }

    public abstract void eat();
    public abstract void breathe();

    public String getName() {
        return name;
    }
}

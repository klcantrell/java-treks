package com.app;

public class Light {
    private String name;

    public Light(String name) {
        this.name = name;
    }

    public void on() {
        System.out.println(this.name + " light is on!");
    }

    public void off() {
        System.out.println(this.name + " light is off!");
    }
}

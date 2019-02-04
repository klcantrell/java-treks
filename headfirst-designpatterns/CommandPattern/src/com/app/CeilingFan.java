package com.app;

public class CeilingFan {
    private String name;
    private Speed speed;

    public CeilingFan(String name) {
        this.name = name;
    }

    public enum Speed {
        HIGH,
        MEDIUM,
        LOW,
        OFF
    }

    public void high() {
        System.out.println("Ceiling fan at high");
        this.speed = Speed.HIGH;
    }

    public void medium() {
        this.speed = Speed.MEDIUM;
    }

    public void low() {
        this.speed = Speed.LOW;
    }

    public void off() {
        System.out.println("Ceiling fan off");
        this.speed = Speed.OFF;
    }

    public Speed getSpeed() {
        return speed;
    }
}

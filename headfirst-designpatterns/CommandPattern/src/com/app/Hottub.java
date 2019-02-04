package com.app;

public class Hottub {
    private int temperature;

    public void jetsOn() {
        System.out.println("Hottub jets are bubbling");
    }

    public void jetsOff() {
        System.out.println("Hottub is off");
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
        if (temperature < 0) {
            System.out.println("Hottub cooling down");
        } else {
            System.out.println("Temperature set to " + temperature);
        }
    }
}

package com.app;

public class Light {
    private int watts;
    private int lumens;
    private String colorTemperature;
    private boolean on;

    public Light(int watts, int lumens, String colorTemperature) {
        this.watts = watts;
        this.lumens = lumens;
        this.colorTemperature = colorTemperature;
        this.on = false;
    }

    public void togglePower() {
        on = !on;
        if (on) {
            System.out.println("Lights on!");
        } else {
            System.out.println("Lights off!");
        }
    }
}

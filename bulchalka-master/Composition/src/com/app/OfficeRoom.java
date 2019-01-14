package com.app;

public class OfficeRoom {
    private Desk desk;
    private Light light;

    public OfficeRoom(Desk desk, Light light) {
        this.desk = desk;
        this.light = light;
    }

    public Desk getDesk() {
        return desk;
    }

    public void hitLightSwitch() {
        light.togglePower();
    }
}

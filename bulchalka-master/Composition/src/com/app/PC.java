package com.app;

public class PC {
    private Chassis chassis;
    private Monitor monitor;
    private Motherboard motherboard;

    public PC(Chassis chassis, Monitor monitor, Motherboard motherboard) {
        this.chassis = chassis;
        this.monitor = monitor;
        this.motherboard = motherboard;
    }

    private void drawLogo() {
        monitor.drawPixelAt(1200, 50, "blue");
    }

    public void powerUp() {
        chassis.pressPowerButton();
        motherboard.loadProgram("Windows 1.0");
        drawLogo();
    }
}

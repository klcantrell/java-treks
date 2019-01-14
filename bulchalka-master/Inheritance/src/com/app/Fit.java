package com.app;

public class Fit extends Car {
    String trim;

    public Fit(int passengers, String trim) {
        super("Fit", passengers, 4);
        this.trim = trim;
    }

    public void getInfo() {
        System.out.println("I'm a " + model + " with " + trim + " trim.");
        System.out.println("I'm currently going " + getSpeed() + " fast and have " + getPassengers() + " passengers");
    }

    @Override
    public void stop() {
        super.stop();
        transmissionUpdate();
        System.out.println("I'm a Fit and I've stopped");
    }

    @Override
    public void accelerate(int speedDelta) {
        super.accelerate(speedDelta);
        transmissionUpdate();
    }

    @Override
    public void deccelerate(int speedDelta) {
        super.deccelerate(speedDelta);
        transmissionUpdate();
    }

    public void transmissionUpdate() {
        int speed = getSpeed();
        if (speed == 0) {
            changeGear(0);
        } else if (speed > 0 && speed <= 10) {
            changeGear(1);
        } else if (speed > 10 && speed <= 20) {
            changeGear(2);
        }
    }
}

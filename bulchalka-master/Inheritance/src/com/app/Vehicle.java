package com.app;

public class Vehicle {
    private int passengers;
    private int speed = 0;
    private String direction = "forward";

    public Vehicle(int passengers) {
        this.passengers = passengers;
    }

    int getSpeed() {
        return speed;
    }

    String getDirection() {
        return direction;
    }

    public void accelerate(int speedDelta) {
        this.speed += speedDelta;
        System.out.println("Sped up by " + speedDelta);
    }

    public void deccelerate(int speedDelta) {
        this.speed -= speedDelta;
        System.out.println("Slowed down by " + speedDelta);
    }

    public void stop() {
        setSpeed(0);
        System.out.println("We've stopped");
    }

    public void turn(String direction) {
        this.direction = direction;
        System.out.println("Turned " + direction);
    }

    int getPassengers() {
        return passengers;
    }


    void setSpeed(int speed) {
        this.speed = speed;
    }

    void setDirection(String direction) {
        this.direction = direction;
    }
}

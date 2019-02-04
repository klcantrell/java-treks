package com.app;

public class SimpleRemoteMain {
    public static void main(String[] args) {
        System.out.println("Simple remote");
        Light light = new Light("Test");
        Command lightOnCommand = new LightOnCommand(light);

        GarageDoor testGarageDoor = new GarageDoor();
        Command garageDoorCommand = new GarageDoorOpenCommand(testGarageDoor);

        SimpleRemoteControl simpleRemoteControl = new SimpleRemoteControl();
        simpleRemoteControl.setCommand(lightOnCommand);
        simpleRemoteControl.buttonWasPressed();
        simpleRemoteControl.setCommand(garageDoorCommand);
        simpleRemoteControl.buttonWasPressed();
    }
}

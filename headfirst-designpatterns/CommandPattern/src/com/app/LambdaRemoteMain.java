package com.app;

public class LambdaRemoteMain {
    public static void main(String[] args) {
        LambdaRemote remoteControl = new LambdaRemote();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        FunctionalCommand stereoOn = () -> {
          stereo.on();
          stereo.setCd();
          stereo.setVolume(11);
        };

        remoteControl.setCommand(0, livingRoomLight::on, livingRoomLight::off);
        remoteControl.setCommand(1, kitchenLight::on, kitchenLight::off);
        remoteControl.setCommand(2, ceilingFan::high, ceilingFan::off);
        remoteControl.setCommand(3, garageDoor::up, garageDoor::down);
        remoteControl.setCommand(4, stereoOn, stereo::off);

        remoteControl.onButtonWasPushed(1);
        remoteControl.onButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.undoButtonWasPushed();
    }
}

package com.app;

public class Main {

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

        System.out.println("Remote");
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Light kitchenLight = new Light("Kitchen");
        CeilingFan ceilingFan = new CeilingFan("Living Room");
        GarageDoor garageDoor = new GarageDoor();
        Stereo stereo = new Stereo();

        LightOnCommand livingRoomLightOn = new LightOnCommand(livingRoomLight);
        LightOffCommand livingRoomLightOff = new LightOffCommand(livingRoomLight);
        LightOnCommand kitchenLightOn = new LightOnCommand(kitchenLight);
        LightOffCommand kitchenLightOff = new LightOffCommand(kitchenLight);

        CeilingFanOnCommand ceilingFanOn = new CeilingFanOnCommand(ceilingFan);
        CeilingFanOffCommand ceilingFanOff = new CeilingFanOffCommand(ceilingFan);

        GarageDoorOpenCommand garageDoorOpen = new GarageDoorOpenCommand(garageDoor);
        GarageDoorCloseCommand garageDoorClose = new GarageDoorCloseCommand(garageDoor);

        StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
        StereoOffCommand stereoffCommand = new StereoOffCommand(stereo);

        remoteControl.setCommand(0, livingRoomLightOn, livingRoomLightOff);
        remoteControl.setCommand(1, kitchenLightOn, kitchenLightOff);
        remoteControl.setCommand(2, ceilingFanOn, ceilingFanOff);
        remoteControl.setCommand(3, stereoOnWithCd, stereoffCommand);

        System.out.println(remoteControl);

        remoteControl.onButtonWasPushed(0);
        remoteControl.offButtonWasPushed(0);
        remoteControl.onButtonWasPushed(1);
        remoteControl.offButtonWasPushed(1);
        System.out.println(remoteControl);
        remoteControl.undoButtonWasPushed();
        remoteControl.onButtonWasPushed(2);
        remoteControl.offButtonWasPushed(2);
        remoteControl.onButtonWasPushed(3);
        remoteControl.offButtonWasPushed(3);
    }
}

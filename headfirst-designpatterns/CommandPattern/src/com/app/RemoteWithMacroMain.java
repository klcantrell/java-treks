package com.app;

public class RemoteWithMacroMain {
    public static void main(String[] args) {
        RemoteControl remoteControl = new RemoteControl();

        Light livingRoomLight = new Light("Living Room");
        Tv tv = new Tv();
        Stereo stereo = new Stereo();
        Hottub hottub = new Hottub();

        LightOnCommand lightOn = new LightOnCommand(livingRoomLight);
        TvOnCommand tvOn = new TvOnCommand(tv);
        StereoOnWithCdCommand stereoOnWithCd = new StereoOnWithCdCommand(stereo);
        HottubOnCommand hottubOn = new HottubOnCommand(hottub);

        LightOffCommand lightOff = new LightOffCommand(livingRoomLight);
        TvOffCommand tvOff = new TvOffCommand(tv);
        StereoOffCommand stereoOff = new StereoOffCommand(stereo);
        HottubOffCommand hottubOff = new HottubOffCommand(hottub);

        Command[] partyOn = { lightOn, stereoOnWithCd, tvOn, hottubOn };
        Command[] partyOff = { lightOff, stereoOff, tvOff, hottubOff };
        MacroCommand partyOnMacro = new MacroCommand(partyOn);
        MacroCommand partyOffMacro = new MacroCommand(partyOff);

        remoteControl.setCommand(0, partyOnMacro, partyOffMacro);

        System.out.println(remoteControl);
        System.out.println("--- Pushing Macro On ---");
        remoteControl.onButtonWasPushed(0);
        System.out.println("--- Pushing Macro Off ---");
        remoteControl.offButtonWasPushed(0);
    }
}

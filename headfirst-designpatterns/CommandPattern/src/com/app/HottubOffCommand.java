package com.app;

public class HottubOffCommand implements Command {
    private Hottub hottub;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.jetsOff();
        hottub.setTemperature(-1);
    }
}

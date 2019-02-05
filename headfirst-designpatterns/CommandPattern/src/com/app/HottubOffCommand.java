package com.app;

public class HottubOffCommand implements Command {
    private Hottub hottub;
    private int prevTemperature;

    public HottubOffCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        this.prevTemperature = hottub.getTemperature();
        hottub.jetsOff();
        hottub.setTemperature(98);
    }

    public void undo() {
        hottub.jetsOn();
        hottub.setTemperature(this.prevTemperature);
    }
}

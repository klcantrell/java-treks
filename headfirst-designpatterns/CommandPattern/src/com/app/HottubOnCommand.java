package com.app;

public class HottubOnCommand implements Command {
    private Hottub hottub;

    public HottubOnCommand(Hottub hottub) {
        this.hottub = hottub;
    }

    public void execute() {
        hottub.jetsOn();
        hottub.setTemperature(104);
    }

    public void undo() {
        hottub.jetsOff();
        hottub.setTemperature(98);
    }
}

package com.app;

public class CeilingFanOffCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFan.Speed prevSpeed;

    public CeilingFanOffCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        this.prevSpeed = ceilingFan.getSpeed();
        this.ceilingFan.off();
    }

    public void undo() {
        switch (this.prevSpeed) {
            case HIGH:
                ceilingFan.high();
                break;
            case MEDIUM:
                ceilingFan.medium();
                break;
            case LOW:
                ceilingFan.low();
                break;
            default:
                ceilingFan.medium();
                break;
        }
    }
}

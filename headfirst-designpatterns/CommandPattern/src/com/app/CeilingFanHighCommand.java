package com.app;

public class CeilingFanHighCommand implements Command {
    private CeilingFan ceilingFan;
    private CeilingFan.Speed prevSpeed;

    public CeilingFanHighCommand(CeilingFan ceilingFan) {
        this.ceilingFan = ceilingFan;
    }

    public void execute() {
        this.prevSpeed = ceilingFan.getSpeed();
        ceilingFan.high();
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
            case OFF:
                ceilingFan.off();
                break;
            default:
                ceilingFan.off();
                break;
        }
    }
}

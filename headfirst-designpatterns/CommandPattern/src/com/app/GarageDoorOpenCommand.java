package com.app;

public class GarageDoorOpenCommand implements Command {
    private GarageDoor garageDoor;

    public GarageDoorOpenCommand(GarageDoor garageDoor) {
        this.garageDoor = garageDoor;
    }

    public void execute() {
        this.garageDoor.up();
    }
}

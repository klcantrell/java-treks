package com.app;

public class StereoOffCommand implements Command {
    private Stereo stereo;

    public StereoOffCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        this.stereo.off();
    }

    public void undo() {
        this.stereo.on();
    }
}

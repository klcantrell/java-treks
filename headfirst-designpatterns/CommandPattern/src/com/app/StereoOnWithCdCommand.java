package com.app;

public class StereoOnWithCdCommand implements Command {
    private Stereo stereo;

    public StereoOnWithCdCommand(Stereo stereo) {
        this.stereo = stereo;
    }

    public void execute() {
        this.stereo.on();
        this.stereo.setCd();
        stereo.setVolume(11);
    }
}

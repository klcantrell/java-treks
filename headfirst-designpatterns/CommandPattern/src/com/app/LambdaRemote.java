package com.app;

public class LambdaRemote {
    private FunctionalCommand[] onCommands;
    private FunctionalCommand[] offCommands;
    private FunctionalCommand undoCommand;

    public LambdaRemote() {
        onCommands = new FunctionalCommand[7];
        offCommands = new FunctionalCommand[7];

        for (int i = 0; i < 7; i++) {
            onCommands[i] = () -> { };
            offCommands[i] = () -> { };
        }
        undoCommand = () -> { };
    }

    public void setCommand(int slot, FunctionalCommand onCommand, FunctionalCommand offCommand) {
        onCommands[slot] = onCommand;
        offCommands[slot] = offCommand;
    }

    public void onButtonWasPushed(int slot) {
        onCommands[slot].execute();
        undoCommand = offCommands[slot];
    }

    public void offButtonWasPushed(int slot) {
        offCommands[slot].execute();
        undoCommand = onCommands[slot];
    }

    public void undoButtonWasPushed() {
        undoCommand.execute();
    }

    public String toString() {
        StringBuffer stringBuff = new StringBuffer();
        stringBuff.append("\n ------- Remote Control ------- \n");
        for (int i = 0; i < onCommands.length; i++) {
            stringBuff.append("[slot " + i + "] " + onCommands[i].getClass().getName()
                    + "    " + offCommands[i].getClass().getName() + "\n");
        }
        stringBuff.append("undo button " + undoCommand.getClass().getName() + "\n");
        return stringBuff.toString();
    }
}

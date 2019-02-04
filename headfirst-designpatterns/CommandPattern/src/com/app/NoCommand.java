package com.app;

public class NoCommand implements Command {
    public void execute() {
        System.out.println("Empty command");
    }
}

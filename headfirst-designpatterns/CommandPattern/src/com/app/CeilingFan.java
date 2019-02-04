package com.app;

public class CeilingFan {
    private String name;

    public CeilingFan(String name) {
        this.name = name;
    }

    public void medium() {
        System.out.println(this.name + " ceiling fan on at medium.");
    }

    public void off() {
        System.out.println(this.name + " ceiling fan is off");
    }
}

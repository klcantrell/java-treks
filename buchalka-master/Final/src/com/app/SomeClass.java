package com.app;

// constants are usually stored as static final

public class SomeClass {
    private static int classCounter;
    public final int instanceNumber;
    private final String name;

    public SomeClass(String name) {
        // instanceNumber = 1; // can't reassign a final variable
        this.name = name;
        classCounter++;
        instanceNumber = classCounter;
        System.out.println(name + " created, instance is " + instanceNumber);
    }

    public int getInstanceNumber() {
        return instanceNumber;
    }
}

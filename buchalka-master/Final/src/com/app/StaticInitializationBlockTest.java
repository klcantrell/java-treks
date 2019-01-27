package com.app;

public class StaticInitializationBlockTest {
    public static final String owner;

    static {
        owner = "Kal";
        System.out.println("Static Initialization Block called");
    }

    public StaticInitializationBlockTest() { // constructor actually called after all static inits,
                                            // so this placement is misleading
        System.out.println("Constructor called");
    }

    static {
        System.out.println("2nd initialization block called");
    }

    public void someMethod() {
        System.out.println("someMethod called");
    }
}

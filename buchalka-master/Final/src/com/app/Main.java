package com.app;

public class Main {

    public static void main(String[] args) {
	    SomeClass one = new SomeClass("one");
	    SomeClass two = new SomeClass("two");
	    SomeClass three = new SomeClass("three");

		System.out.println(one.getInstanceNumber());
		System.out.println(two.getInstanceNumber());
		System.out.println(three.getInstanceNumber());

		// one.instanceNumber = 4; // can't reassign final variables

		// constants are usually stored as static final
		System.out.println(Math.PI);

		// Math m = new Math(); // math class is marked as final

		int pw = 674312;
		Password password = new ExtendedPassword(pw);
		password.storePassword();

		password.letMeIn(1);
		password.letMeIn(523266);
		password.letMeIn(9773);
		password.letMeIn(0);
		password.letMeIn(-1);
		password.letMeIn(674312);

		System.out.println("Main method called");
		StaticInitializationBlockTest sibTest = new StaticInitializationBlockTest();
		sibTest.someMethod();
		System.out.println("Owner is " + sibTest.owner);
    }
}

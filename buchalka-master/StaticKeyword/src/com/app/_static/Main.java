package com.app._static;

public class Main {

    public int multiplier = 7;

    public static void main(String[] args) {
	    StaticTest firstInstance = new StaticTest("First Instance");
        System.out.println(firstInstance.getName() + " is instance number " + StaticTest.getNumInstances());
	    StaticTest secondInstance = new StaticTest("Second Instance");
        System.out.println(secondInstance.getName() + " is instance number " + StaticTest.getNumInstances());
	    StaticTest thirdInstance = new StaticTest("Third Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstances());

        // can't access non static members and methods of its own class
        // int answer = multiply(6);
        // System.out.println("The answer is " + answer);
    }
    public int multiply(int num) {
        return num * this.multiplier;
    }
}

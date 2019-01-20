package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        // width of int = 32 (8 bytes)
        int myIntValue = 5 / 3;
        // width of float = 32 (8 bytes)
        float myFloatValue = 5f / 3f;
        // width of double = 64 (8 bytes)
        double myDoubleValue = 5d / 3d;
        System.out.println("myIntValue = " + myIntValue);
        System.out.println("myFloatValue = " + myFloatValue);
        System.out.println("myDoubleValue = " + myDoubleValue);

        // challenge
        double poundsToKgRatio = 0.45359237d;
        double pounds = 200d;
        double kilograms = pounds * poundsToKgRatio;
        System.out.println("myDoubleValue = " + kilograms);

        // underscores to make decimal types cleaner
        double myUnderscoredDouble = 3.123_456_78f;
    }
}

package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        // integar has a width of 32
        int myMinValue = -2_147_483_648;
        int myMaxValue = 2_147_483_647;
        int myTotal = myMinValue / 2;

        // byte has a width of 8
        byte myByte = -128;
        byte myNewByte = (byte) (myByte / 2);

        // byte has width of 16
        short myShort = -32768;
        short myNewShort = (short) (myShort / 2);

        // long has a width of 64
        long myLong = 100L;

        // challenge
        byte byteChallenge = 32;
        short shortChallenge = 10000;
        int intChallenge = 40000;
        long longChallenge = 50000L + 10L * (byteChallenge * shortChallenge * intChallenge);
        System.out.println(longChallenge);
    }
}

package com.kalcantrell;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysChallenge {
    private static Scanner scanner = new Scanner(System.in);
    public void run() {
        int[] myIntegers = getIntegersForArray(5);
        System.out.println(Arrays.toString(myIntegers));
    }
    public int[] getIntegersForArray(int length) {
        int[] values = new int[length];
        System.out.println("Enter 5 numbers to sort\r");
        for (int i = 0; i < values.length; i++) {
            int currentNumberChoice = i + 1;
            System.out.print("Number " + currentNumberChoice + ": ");
            boolean validResponse = false;
            while (!validResponse) {
                if (scanner.hasNextInt()) {
                    values[i] = scanner.nextInt();
                    validResponse = true;
                } else {
                    System.out.println("You need to enter a number.\r");
                }
            }
        }
        return values;
    }
}

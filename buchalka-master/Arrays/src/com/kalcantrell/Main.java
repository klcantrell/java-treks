package com.kalcantrell;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

//        int[] myIntArray = new int[10];
//        myIntArray[5] = 50;
//        System.out.println(Arrays.toString(myIntArray));
//
//        double[] myDoubleArray = new double[10];
//
//        int[] anotherIntArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
//        System.out.println(Arrays.toString(anotherIntArray));
//
//        int[] yetAnotherIntArray = new int[15];
//        for (int i = 0; i < yetAnotherIntArray.length; i++) {
//            yetAnotherIntArray[i] = i * 10;
//        }
//        printArray(yetAnotherIntArray);
//
//        // using scanner
//        int[] myIntegers = getIntegers(5);
//        printArray(myIntegers);
//        System.out.println("The average is " + getAverage(myIntegers));

        ArraysChallenge arraysChallenge = new ArraysChallenge();
//        arraysChallenge.runAverageChallenge();
//        arraysChallenge.runFindMinChallenge();
        arraysChallenge.runReverseArrayChallenge();
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int elementOrder = i + 1;
            System.out.println("Element " + elementOrder + ", value is " + arr[i]);
        }
    }

    public static int[] getIntegers(int number) {
        System.out.println("Enter " + number + " integer values.\r");
        int[] values = new int[number];

        for (int i = 0; i < values.length; i++) {
            values[i] = scanner.nextInt();
        }
        return values;
    }

    public static double getAverage(int[] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        return (double) sum / (double) arr.length;
    }
}

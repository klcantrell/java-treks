package com.kalcantrell;

import java.util.Arrays;
import java.util.Scanner;

public class ArraysChallenge {
    private static Scanner scanner = new Scanner(System.in);

    public void runAverageChallenge() {
        int[] myIntegers = getIntegersForArray(5);
        int[] sortedIntegers = arraySortDescending(myIntegers);
        printArray(sortedIntegers);
    }

    public void runFindMinChallenge() {
        int[] myIntegers = getIntegersForArray(5);
        int min = findMin(myIntegers);
        System.out.println("Min is: " + min);
    }

    public void runReverseArrayChallenge() {
        int[] arrToReverse = {1, 2, 3, 4, 5, 6, 7};
        reverse(arrToReverse);
        System.out.println(Arrays.toString(arrToReverse));
    }

    public int[] getIntegersForArray(int length) {
        int[] values = new int[length];
        System.out.println("Enter 5 numbers to sort\r");
        for (int i = 0; i < values.length; i++) {
            int currentNumberChoice = i + 1;
            boolean validResponse = false;
            while (!validResponse) {
                System.out.print("Number " + currentNumberChoice + ": ");
                if (scanner.hasNextInt()) {
                    values[i] = scanner.nextInt();
                    validResponse = true;
                } else {
                    System.out.println("You need to enter a number.\r");
                }
                scanner.nextLine();
            }
        }
        scanner.close();
        return values;
    }

    public void printArray(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int elementOrder = i + 1;
            System.out.println("Element " + elementOrder + " is " + arr[i]);
        }
    }

    public int[] arraySortDescending(int[] arr) {
        int[] sortedArr = arr.clone();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length; j++) {
                if (sortedArr[j - 1] < sortedArr[j]) {
                    int temp = sortedArr[j - 1];
                    sortedArr[j - 1] = sortedArr[j];
                    sortedArr[j] = temp;
                }
            }
        }
        return sortedArr;
    }

    public int findMin(int[] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min)
                min = arr[i];
        }
        return min;
    }

    public void reverse(int[] arr) {
        int i = arr.length - 1;
        int j = 0;
        int temp;
        while (i >= arr.length / 2) {
            temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            i--;
            j++;
        }
    }

}

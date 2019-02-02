package com.kalcantrell;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class ThrowsKeywordExample {
    public int divide() throws NoSuchElementException, ArithmeticException {
        int x, y;
        x = getInt();
        y = getInt();
        System.out.println("x is " + x + ", y is " + y);
        return x / y;
    }

    public int getInt() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter an int");
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                scanner.nextLine();
                System.out.println("Please enter a number using only characters 0 - 9");
            }
        }
    }
}

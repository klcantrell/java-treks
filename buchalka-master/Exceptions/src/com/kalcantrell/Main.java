package com.kalcantrell;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        int x = 98;
//        int y = 0;
//        System.out.println(divideLBYL(x, y));
//        System.out.println(divideEAFP(x, y));
//        System.out.println(divideNoCatching(x, y));

//        int x = getInt();

//        int x = getIntLBYL();

        int x = getIntEAFP();
        System.out.println("x is " + x);
    }

    private static int getInt() {
        System.out.println("Enter an int");
        Scanner scanner = new Scanner(System.in);
        scanner.close();
        return scanner.nextInt();
    }

    private static int getIntLBYL() {
        System.out.println("Enter an int");
        Scanner scanner = new Scanner(System.in);
        boolean isValid = true;
        String input = scanner.next();
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                isValid = false;
                break;
            }
        }
        if (isValid) {
            return Integer.parseInt(input);
        }
        return 0;
    }

    private static int getIntEAFP() {
        System.out.println("Enter an int");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) { // Exception e would have worked too
            return 0;
        }
    }

    private static int divideLBYL(int x, int y) {
        if (y != 0) {
            return x / y;
        } else {
            return 0;
        }
    }

    private static int divideEAFP(int x, int y) {
        try {
            return x / y;
        } catch (ArithmeticException e) {
            return 0;
        }
    }

    private static int divideNoCatching(int x, int y) {
        return x / y;
    }
}

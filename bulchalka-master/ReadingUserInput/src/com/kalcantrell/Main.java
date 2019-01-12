package com.kalcantrell;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
//        intro();
//        userInputChallenge();

        // Min and Max challenge

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter a number - we'll give you the current min and max:");
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int userInput = scanner.nextInt();
                min = Math.min(min, userInput);
                max = Math.max(max, userInput);
                System.out.println("Current min is " + min
                        + " and current max is " + max);
            } else {
                System.out.println("You're done...");
                System.out.println("Final min is " + min
                        + " and final max is " + max);
                break;
            }
            scanner.nextLine();
        }
        scanner.close();
    }

    public static void intro() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your year of birth");
        boolean hasNextInt = scanner.hasNextInt();
        if (hasNextInt) {
            int yearOfBirth = scanner.nextInt();


            // need to add this so that pressing enter doesn't skip the nextLine asking for name
            scanner.nextLine();

            System.out.println("Enter your name: ");
            String name = scanner.nextLine();

            int age = 2019 - yearOfBirth;

            if (age >= 0 && age <= 100) {
                System.out.println("Your name is: " + name);
                System.out.println("Your age is: " + age);
            } else {
                System.out.println("Invalid year of birth");
            }
        } else {
            System.out.println("You need to enter a valid number");
        }

        scanner.close();
    }

    public static void userInputChallenge() {
        Scanner scanner = new Scanner(System.in);
        int validChoices = 0;
        int sum = 0;

        System.out.println("Let's get 10 numbers from you to add up");

        while (validChoices < 10) {
            int currentNumber = validChoices + 1;
            System.out.println("Enter number " + currentNumber);
            boolean hasNextInt = scanner.hasNextInt();
            if (hasNextInt) {
                int term = scanner.nextInt();
                sum += term;
                validChoices++;
            } else {
                System.out.println("Sorry, you need to enter a number");
            }
            scanner.nextLine();
        }
        System.out.println("Your sum is: " + sum);
        scanner.close();
    }
}

package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        for (int i = 1; i < 6; i++) {
            System.out.println(calculateInterest(10000.00, i));
        }

        // ************ challenge

        int count = 0;
        for (int i = 50; i < 101; i++) {
            if (isPrime(i)) {
                System.out.println(i + " is prime!");
                count++;
            }
            if (count == 3)
                break;
        }
        System.out.println("We found " + count + " prime numbers between 50 and 100!");
    }

    public static double calculateInterest(double amount, double interestRate) {
        return amount * (interestRate / 100);
    }

    public static boolean isPrime(int n) {
        if (n == 1)
            return false;
        for (int i = 2; i <= n / 2; i++) {
            if (n % i == 0)
                return false;
        }
        return true;
    }
}

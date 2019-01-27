package com.challenge;

public class Series {
    public static int nSum(int n) {
        int sum = 0;
        int count = 0;
        while (count <= n) {
            sum += count;
            count++;
        }
        return sum;
    }

    public static int factorial(int n) {
        if (n == 1 || n == 0) {
            return n;
        }
        return n * factorial(n - 1);
    }

    public static int fibonacci(int n) {
        if (n == 1 || n == 2 || n == 0) {
            return 1;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
}

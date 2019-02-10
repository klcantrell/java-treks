package com.app;

import java.util.function.Function;

public class Challenge2 {
    public static void main(String[] args) {
        Function<String, String> everySecondCharLambda = source -> {
            StringBuilder value = new StringBuilder();
            for (int i = 0; i < source.length(); i++) {
                if (i % 2 == 1) {
                    value.append(source.charAt(i));
                }
            }
            return value.toString();
        };

        System.out.println(everySecondCharLambda.apply("KALALAU"));
        System.out.println(everySecondChar("KALALAU"));
    }

    // turn this into a lambda
    public static String everySecondChar(String source) {
        StringBuilder value = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (i % 2 == 1) {
                value.append(source.charAt(i));
            }
        }
        return value.toString();
    }
}

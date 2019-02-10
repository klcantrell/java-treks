package com.app;

import java.util.function.Function;

public class Challenge4 {
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

        System.out.println(everySecondCharacter(everySecondCharLambda, "1234567890"));
    }

    public static String everySecondCharacter(Function<String, String> fn, String arg) {
        return fn.apply(arg);
    }

}

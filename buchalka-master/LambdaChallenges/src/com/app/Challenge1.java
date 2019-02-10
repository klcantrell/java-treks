package com.app;

import java.util.stream.Stream;

public class Challenge1 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                String myString = "Let's split this up into an array";
                String[] parts = myString.split(" ");
                for (String part : parts) {
                    System.out.println(part);
                }
            }
        };

        Runnable lambdaRunnable = () -> {
            String myString = "Let's split this up into an array";
            Stream.of(myString.split(" "))
                    .forEach(System.out::println);
        };

        new Thread(runnable).start();
        new Thread(lambdaRunnable).start();
    }
}

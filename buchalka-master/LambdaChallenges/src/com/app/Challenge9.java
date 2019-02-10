package com.app;

import java.util.Arrays;
import java.util.List;

public class Challenge9 {
    public static void main(String[] args) {
        List<String> topNames2015 = Arrays.asList(
                "Amelia",
                "Oliva",
                "emily",
                "Isla",
                "Ava",
                "oliver",
                "Jack",
                "Charlie",
                "harry",
                "Jacob"
        );

        topNames2015
                .stream()
                .sorted()
                .map(name ->
                        name.substring(0, 1).toUpperCase() + name.substring(1))
                .forEach(System.out::println);

        System.out.println("Names that start with 'A': ");
        System.out.println(
            topNames2015
                    .stream()
                    .map(name ->
                            name.substring(0, 1).toUpperCase() + name.substring(1))
                    .filter(name -> name.startsWith("A"))
                    .peek(System.out::println) // not a terminal operation
                    .count()
        );
        System.out.println("\n");
    }

}

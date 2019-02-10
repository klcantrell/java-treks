package com.app;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Main {

    public static void main(String[] args) {
        List<String> someBingoNumbers = Arrays.asList(
                "N40", "N36",
                "B12", "B6",
                "G53", "G49", "G60", "G50", "g64",
                "I26", "I17", "I29",
                "O71");
        // without streams
//        List<String> gNumbers = new ArrayList<>();
//        someBingoNumbers.forEach(number -> {
//            if (number.toUpperCase().startsWith("G")) {
//                gNumbers.add(number);
//            }
//        });
//        gNumbers.sort((s1, s2) -> s1.compareTo(s2));
//        gNumbers.forEach(number -> System.out.println(number));

        // with streams
        someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                .forEach(System.out::println); // terminal operation

        System.out.println("creating our own streams");
        Stream<String> iAndOStream = Stream.of("I26", "I17", "I29", "O71");
        Stream<String> iAndNStream = Stream.of("N40", "N36", "I26", "I17", "I29", "O71");
        Stream<String> concatStream = Stream.concat(iAndOStream, iAndNStream);
        System.out.println(
            concatStream
                .distinct()
                .peek(System.out::println)
                .count()
        );
    }
}

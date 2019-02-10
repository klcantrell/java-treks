package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
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
//        List<String> sortedGNumbers = someBingoNumbers
//                .stream()
//                .map(String::toUpperCase)
//                .filter(s -> s.startsWith("G"))
//                .sorted()
//                // .forEach(System.out::println); // terminal operation
//                .collect(Collectors.toList());

        List<String> sortedGNumbers = someBingoNumbers
                .stream()
                .map(String::toUpperCase)
                .filter(s -> s.startsWith("G"))
                .sorted()
                // .forEach(System.out::println); // terminal operation
                .collect(ArrayList::new, ArrayList::add, ArrayList::addAll);

        for (String s : sortedGNumbers) {
            System.out.println(s);
        }


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

        Employee john = new Employee("John Doe", 30);
        Employee jane = new Employee("Jane Deer", 25);
        Employee jack = new Employee("Jack Hill", 40);
        Employee snow = new Employee("Snow White", 22);

        Department hr = new Department("Human Resources");
        hr.addEmployee(jane);
        hr.addEmployee(jack);
        hr.addEmployee(snow);
        Department accounting = new Department("Accounting");
        accounting.addEmployee(john);

        List<Department> departments = new ArrayList<>();
        departments.add(hr);
        departments.add(accounting);

        // flat map basics
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .forEach(System.out::println);

        // reduce
        System.out.println("\nYoungest employee with reduce");
        departments
                .stream()
                .flatMap(department -> department.getEmployees().stream())
                .reduce((e1, e2) -> e1.getAge() < e2.getAge() ? e1 : e2)
                .ifPresent(System.out::println);

        // lazy evaluation of streams (no terminal operation)
        Stream.of("ABC", "AC", "BAA", "CCCC", "XY", "ST")
                .filter(s -> {
                    System.out.println(s);
                    return s.length() == 3;
                })
                .count();
    }
}





















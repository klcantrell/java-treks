package com.kalcantrell;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class SetMain {
    public static void main(String[] args) {
        Set<Integer> squares = new HashSet<>();
        Set<Integer> cubes = new HashSet<>();

        for (int i = 1; i <= 100; i++) {
            squares.add(i * i);
            cubes.add(i * i * i);
        }

        System.out.println("There are " + squares.size() + " squares and " + cubes.size() + " cubes");

        Set<Integer> union = new HashSet<>(squares);
        union.addAll(cubes);

        System.out.println("Union contains " + union.size() + " elements");

        Set<Integer> intersection = new HashSet<>(squares);
        intersection.retainAll(cubes);
        for (int i : intersection) {
            System.out.println(i + " is the square of " + Math.sqrt(i) + " and the cube of "
                + Math.cbrt(i));
        }

        Set<String> words = new HashSet<>();
        String sentence = "one day in the year of the fox";
        String[] arrayWords = sentence.split(" ");
        words.addAll(Arrays.asList(arrayWords));

        for (String s : words) {
            System.out.println(s);
        }

        Set<String> nature = new HashSet<>();
        Set<String> divine = new HashSet<>();

        String[] natureWords = "all nature is but art unknown to thee".split(" ");
        nature.addAll(Arrays.asList(natureWords));

        String[] divineWords = "to err is human to forgive divine".split(" ");
        divine.addAll(Arrays.asList(divineWords));

        System.out.println("Asymmetric difference");
        System.out.println("---------------------");

        System.out.println("nature - divine");
        Set<String> natureMinusDivine = new HashSet<>(nature);
        natureMinusDivine.removeAll(divine);
        printSet(natureMinusDivine);
        
        System.out.println("divine - nature");
        Set<String> divineMinusNature = new HashSet<>(divine);
        divineMinusNature.removeAll(nature);
        printSet(divineMinusNature);

        System.out.println("Symmetric difference");
        System.out.println("---------------------");

        Set<String> natureDivineUnion = new HashSet<>(nature);
        natureDivineUnion.addAll(divine);
        Set<String> natureDivineIntersection = new HashSet<>(nature);
        natureDivineIntersection.retainAll(divine);
        Set<String> natureDivineSymmetricDifference = new HashSet<>(natureDivineUnion);
        natureDivineSymmetricDifference.removeAll(natureDivineIntersection);
        printSet(natureDivineSymmetricDifference);

        // containsAll
        if (nature.containsAll(divine)) {
            System.out.println("divine is a subset of nature");
        }

        if (nature.containsAll(natureDivineIntersection)) {
            System.out.println("natureDivineIntersection is a subset of nature");
        }

        if (divine.containsAll(natureDivineIntersection)) {
            System.out.println("natureDivineIntersection is a subset of divine");
        }


    }

    public static void printSet(Set<String> set) {
        System.out.print("\t");
        for (String s : set) {
            System.out.print(s + " ");
        }
        System.out.println();
    }
}



















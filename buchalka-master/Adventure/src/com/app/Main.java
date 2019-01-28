package com.app;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Integer, Location> locations = new HashMap<>();
    private static final Map<String, String> locationsVocabulary = new HashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        locationsVocabulary.put("WEST", "W");
        locationsVocabulary.put("NORTH", "N");
        locationsVocabulary.put("EAST", "E");
        locationsVocabulary.put("SOUTH", "S");
        locationsVocabulary.put("QUIT", "Q");


        Map<String, Integer> tempExit = new HashMap<>();
        locations.put(0, new Location(0, "You are sitting in front of a computer learning Java", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("E", 3);
        tempExit.put("S", 4);
        tempExit.put("N", 5);
        locations.put(1, new Location(1, "You are standing at the end of a road before a small brick building", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("N", 5);
        locations.put(2, new Location(2, "You are at the top of a hill", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 1);
        locations.put(3, new Location(3, "You are inside a building, a well house for a small spring", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("W", 2);
        tempExit.put("N", 1);
        locations.put(4, new Location(4, "You are in a valley beside a stream", tempExit));

        tempExit = new HashMap<>();
        tempExit.put("S", 1);
        tempExit.put("W", 2);
        locations.put(5, new Location(5, "You are in the forest", tempExit));


        int loc = 1;
        while (true) {
            System.out.println(locations.get(loc).getDescription());
            if (loc == 0) {
                break;
            }

            Map<String, Integer> exits = locations.get(loc).getExits();
            System.out.print("Available exits are ");
            for (String exit : exits.keySet()) {
                System.out.print(exit + ", ");
            }
            System.out.println();

            String direction = scanner.nextLine().toUpperCase();
            if (exits.containsKey(direction)) {
                loc = exits.get(direction);
            } else {
                String validWord = validUserInput(direction);
                if (validUserInput(direction) != null) {
                    loc = exits.get(locationsVocabulary.get(validWord));
                } else {
                    System.out.println("You cannot go in that direction");
                }
            }

            if (!locations.containsKey(loc)) {
                System.out.println("triggered");
                System.out.println(locations.toString());
                System.out.println("You cannot go in that direction");
            }
        }
    }

    private static String validUserInput(String userInput) {
        String[] userInputWords = userInput.split(" ");
        for (String word : userInputWords) {
            if (locationsVocabulary.containsKey(word)) {
                return word;
            }
        }
        return null;
    }
}

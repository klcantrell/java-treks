package com.kalcantrell;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static List<List<String>> memory = new ArrayList<>();

    public static void main(String[] args) {
        Saveable cloudStrife = new Character("Cloud Strife", "Buster Sword", "Midgar");
        Saveable  tonberry = new Monster("Tonberry", "Kitchen Knife", "Northern Cave");

        save(cloudStrife);
        save(tonberry);

        showSaves();

        Saveable squallLeonhart = new Character();
        squallLeonhart.load(readValues());

        save(squallLeonhart);

        showSaves();

        Saveable cloudStrifeCopy = new Character();
        cloudStrifeCopy.load(memory.get(0));
        System.out.println(cloudStrifeCopy.toString());
    }

    public static void save(Saveable gameObject) {
        memory.add(gameObject.serialize());
    }

    public static void showSaves() {
        int gameObjectIndexCount = 1;
        for (List<String> gameObjectProperties : memory) {
            System.out.println("Game object " + gameObjectIndexCount);
            for (String property : gameObjectProperties) {
                System.out.println("\t" + property);
            }
            gameObjectIndexCount += 1;
        }
    }

    public static ArrayList<String> readValues() {
        ArrayList<String> values = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        int index = 0;
        System.out.println("Choose\n" +
                "1 to enter a string\n" +
                "0 to quit");

        while (!quit) {
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    System.out.print("Enter a string: ");
                    String stringInput = scanner.nextLine();
                    values.add(index, stringInput);
                    index++;
                    break;
            }
        }
        return values;
    }
}

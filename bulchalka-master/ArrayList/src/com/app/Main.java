package com.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static GroceryList groceryList= new GroceryList();

    public static void main(String[] args) {
        boolean quit = false;
        int choice = 0;
        printInstructions();
        while (!quit) {
            System.out.println("Enter your choice: ");
            choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 0:
                    printInstructions();
                    break;
                case 1:
                    groceryList.printGroceryList();
                    break;
                case 2:
                    addItem();
                    break;
                case 3:
                    modifyItem();
                    break;
                case 4:
                    removeItem();
                    break;
                case 5:
                    searchForItem();
                    break;
                case 6:
                    quit = true;
                    break;
                case 7:
                    processArrayList();
                    break;
            }
        }
    }

    public static void printInstructions() {
        System.out.println("\nPress ");
        System.out.println("\t0 - To print choice of options.");
        System.out.println("\t1 - To print the list of grocery items.");
        System.out.println("\t2 - To add an item to the list.");
        System.out.println("\t3 - To modify an item to the list.");
        System.out.println("\t4 - To remove an item in the list.");
        System.out.println("\t5 - To search for an item in the list.");
        System.out.println("\t6 - To quit the application.");
    }

    public static void addItem() {
        System.out.println("Please enter the grocery item: ");
        groceryList.addGroceryItem(scanner.nextLine());
    }

    public static void modifyItem() {
        System.out.println("Enter original item: ");
        String originalItem = scanner.nextLine();
        System.out.println("Enter new item");
        String newItem = scanner.nextLine();
        groceryList.modifyGroceryItem(originalItem, newItem);
    }

    public static void removeItem() {
        System.out.println("Enter item to be removed: ");
        String itemToBeDeleted = scanner.nextLine();
        groceryList.removeGroceryItem(itemToBeDeleted);
    }

    public static void searchForItem() {
        System.out.println("Enter your choice: ");
        String searchItem = scanner.nextLine();
        if (groceryList.onFile(searchItem)) {
            System.out.println("Found " + searchItem + " in our grocery list.");
        } else {
            System.out.println(searchItem + " is not on the shopping list.");
        }
    }

    public static void processArrayList() {
        // option 1
        ArrayList<String> newArr = new ArrayList<String>();
        newArr.addAll(groceryList.getGroceryList());

        //option 2
        ArrayList<String> nextArr = new ArrayList<String>(groceryList.getGroceryList());

        //convert arraylist to array
        String[] myStringArray = new String[groceryList.getGroceryList().size()];
        myStringArray = groceryList.getGroceryList().toArray(myStringArray);

        System.out.println("My string is now " + Arrays.toString(myStringArray));
    }
}

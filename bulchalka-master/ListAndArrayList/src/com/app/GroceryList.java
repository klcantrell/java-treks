package com.app;

import java.util.ArrayList;

public class GroceryList {
    private ArrayList<String> groceryList = new ArrayList<String>();

    public void addGroceryItem(String item) {
        groceryList.add(item);
    }

    public void printGroceryList() {
        System.out.println("You've currently got " + groceryList.size() + " item in your grocery list");
        for (int i = 0; i < groceryList.size(); i++) {
            System.out.println((i + 1) + ". " + groceryList.get(i));
        }
    }

    public void modifyGroceryItem (int position, String newItem) {
        groceryList.set(position, newItem);
        System.out.println("Grocery item " + position + " has been modified");
    }

    public void removeGroceryItem(int position) {
        String theItems = groceryList.get(position);
        groceryList.remove(position);
    }

    public String findItem(String searchItem) {
        int position = groceryList.indexOf(searchItem);
        if (position >= 0) {
            return groceryList.get(position);
        }
        return null;
    }
}

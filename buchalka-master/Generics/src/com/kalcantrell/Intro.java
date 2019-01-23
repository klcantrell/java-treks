package com.kalcantrell;

import java.util.ArrayList;

public class Intro {
    public static void run() {
        // without type parameters
        ArrayList items = new ArrayList();
        items.add(1);
        items.add(2);
        items.add(3);
        items.add(4);
        // items.add("5"); // this would break things but comes in as valid while writing code
        printDoubled(items);

        // with type parameters
        ArrayList<Integer> itemsWithTypeParams = new ArrayList<>();
        itemsWithTypeParams.add(1);
        itemsWithTypeParams.add(2);
        itemsWithTypeParams.add(3);
        itemsWithTypeParams.add(4);
        // itemsWithTypeParams.add("5"); // compile time warning
        printDoubled(itemsWithTypeParams);
    }


    private static void printDoubled(ArrayList<Integer> n) {
        for (Integer i : n) {
            System.out.println(i * 2);
        }
    }
}

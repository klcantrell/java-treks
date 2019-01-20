package com.app;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> myIntArray = new ArrayList<>();

        // the long way of autoboxing of an int primitive using valueOf
        myIntArray.add(Integer.valueOf(55));

        // the long way of unboxing of an int primitive using intValue
        System.out.println(myIntArray.get(0).intValue());

        // short way of autoboxing
        Integer myIntValue = 56; // Integer.valueOf(56);

        // short way of unboxing
        int myInt = myIntValue; // myIntValue.intValue();

        // using the short cut and doubles
        ArrayList<Double> myDoubleValues = new ArrayList<>();
        for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
            myDoubleValues.add(dbl);
        }
        for (int i = 0; i < myDoubleValues.size(); i++) {
            double myDbl = myDoubleValues.get(i);
            System.out.println(myDbl);
        }
    }
}

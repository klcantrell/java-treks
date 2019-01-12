package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
	    String numberAsString = "2019";
        System.out.println("numberAsString = " + numberAsString);

        int number = Integer.parseInt(numberAsString);
        System.out.println("number = " + number);

        numberAsString += 1;
        number += 1;

        System.out.println("auto string concatenation = " + numberAsString);
        System.out.println("what we probably intended = " + number);

        numberAsString = "2019.125";
        double myDouble = Double.parseDouble(numberAsString);
        System.out.println("Parsed double = " + myDouble);
    }
}

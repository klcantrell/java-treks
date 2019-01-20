package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        System.out.println(dayOfTheWeek((0)));
    }

    public static String dayOfTheWeek(int day) {
        switch (day) {
            case 0:
                return "Monday";
            case 1:
                return "Tuesday";
            case 2:
                return "Wednesday";
            case 3:
                return "Thursday";
            case 4:
                return "Friday";
            case 5:
                return "Saturday";
            case 6:
                return "Sunday";
            default:
                return "Not a day of the week";
        }
    }
}

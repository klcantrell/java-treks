package com.kalcantrell;

public class Main {
    private static final String INVALID_VALUE_MESSAGE = "Invalid Value";

    public static void main(String[] args) {
        System.out.println(getDurationString(120, 40));
        System.out.println(getDurationString(1000));
    }

    public static String getDurationString(int minutes, int seconds) {
        if (minutes < 0 || seconds > 59 || seconds < 0)
            return INVALID_VALUE_MESSAGE;
        String hoursStr = String.format("%02d", minutes / 60);
        String minutesStr = String.format("%02d", minutes % 60);
        String secondsStr = String.format("%02d", seconds);
        return String.format("%sh %sm %ss", hoursStr, minutesStr, secondsStr);
    }

    public static String getDurationString(int seconds) {
        if (seconds < 0)
            return INVALID_VALUE_MESSAGE;
        int minutes = seconds / 60;
        int secondsRemainder = seconds % 60;
        return getDurationString(minutes, secondsRemainder);
    }
}

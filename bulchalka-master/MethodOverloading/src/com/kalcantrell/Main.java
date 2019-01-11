package com.kalcantrell;

// overloading allows you to create the same method with different behavior
// by changing the parameter signature ONLY
public class Main {

    public static void main(String[] args) {
	    int newScore = calculateScore("Cloud", 500);
        System.out.println("New score is " + newScore);
        calculateScore(75);
        calculateScore();

        // challenge
        System.out.println(calcFeetAndInchesToCentimeters(2, 8));
        System.out.println(calcFeetAndInchesToCentimeters(1, 20));
        System.out.println(calcFeetAndInchesToCentimeters(7, 5));
        System.out.println(calcFeetAndInchesToCentimeters(48));
        System.out.println(calcFeetAndInchesToCentimeters(-20));

    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }


    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points.");
        return score * 1000;
    }

    public static int calculateScore() {
        System.out.println("No player name, no player score.");
        return 0;
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || inches < 0 || inches > 12)
            return -1;
        return (feet * 12 + inches) * 2.54;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0)
            return -1;
        return inches * 2.54;
    }
}

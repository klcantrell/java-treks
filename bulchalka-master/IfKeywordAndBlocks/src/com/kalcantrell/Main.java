package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        boolean gameOver = true;
        int score = 5000;
        int levelCompleted = 5;
        int bonus = 100;

        if (score == 5000) // only one statement can be processed after if without {}
            System.out.println("Your score was 5000");

        if (score <= 5000 && score > 1000) {
            System.out.println("Your score was less than or equal to 5000 and greater than 1000");
        } else if (score <= 1000) {
            System.out.println("Your score was less thn 1000");
        } else {
            System.out.println("Got here");
        }

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }

        score = 10000;
        levelCompleted = 8;
        bonus = 200;

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            System.out.println("Your final score was " + finalScore);
        }
    }
}

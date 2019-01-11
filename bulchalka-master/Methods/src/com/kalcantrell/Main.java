package com.kalcantrell;


public class Main {

    public static void main(String[] args) {
        int highScore;

//        highScore = calculateScore(true, 800, 5, 100);


        displayHighScorePosition("Kal", calculateHighScorePosition(1500));

        displayHighScorePosition("Cloud", calculateHighScorePosition(900));

        displayHighScorePosition("Squall", calculateHighScorePosition(400));

        displayHighScorePosition("Noctis", calculateHighScorePosition(50));


    }

    public static int calculateScore(boolean gameOver, int score, int levelCompleted, int bonus) {

        if (gameOver) {
            int finalScore = score + (levelCompleted * bonus);
            finalScore += 2000;
            return finalScore;
        } else {
            return -1;
        }
    }

    public static void displayHighScorePosition(String playerName, int position) {
        System.out.println(playerName + ", your position on the high score table is " + position);
    }

    public static int calculateHighScorePosition(int score) {
        int position;
        if (score >= 1000) {
            position = 1;
        } else if (score >= 500) {
            position = 2;
        } else if (score >= 100) {
            position = 3;
        } else {
            position = 4;
        }
        return position;
    }
}

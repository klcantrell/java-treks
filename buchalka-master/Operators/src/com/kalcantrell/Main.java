package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
	    // = and +
        int result = 1 + 2;

        // -
        int previousResult = result;
        result = result - 1;
        System.out.println(previousResult + " - 1 = " + result);

        // *
        previousResult = result;
        result = result * 10;
        System.out.println(previousResult + " * 10 = " + result);

        // /
        previousResult = result;
        result = result / 5;
        System.out.println(previousResult + " / 5 = " + result);

        // %
        previousResult = result;
        result = result % 3;
        System.out.println(previousResult + " % 3 = " + result);

        // operator short hand
        result = result + 1;
        System.out.println("Result is now " + result);
        result++;
        System.out.println("Result is now " + result);
        result --;
        System.out.println("Result is now " + result);
        result -= 2;
        System.out.println("Result is now " + result);

        // ==
        boolean isAlien = false;

        if (isAlien == false) {
            System.out.println("It is not an alien!");
        }

        // !=
        int topScore = 100;
        if (topScore != 20) {
            System.out.println("Not equal to 20");
        }

        // >
        if (topScore > 20) {
            System.out.println("Greater than 20");
        }

        // <
        if (topScore > 20 && topScore < 101) {
            System.out.println("Greater than 20 but less than 101");
        }

        boolean isCar = false;
        if (isCar == true) {
            System.out.println("This is not supposed to happen");
        }

        isCar = true;
        boolean isCarAgain = isCar ? true : false;
        if (isCarAgain) {
            System.out.println("isCarAgain is true");
        }

        // challenge

        double challengeValue1 = 20d;
        double challengeValue2 = 80d;
        double challengeResult = (challengeValue1 + challengeValue2) * 25 % 40;
        if (challengeResult <= 20) {
            System.out.println("Total was over the limit!");
        }
    }
}

package com.kalcantrell;

public class Hamburger {
    private static double lettuceCost = .20;
    private static double tomatoCost = .20;
    private static double onionsCost = .20;
    private static double cheeseCost = .50;

    private String bread;
    private String meat;
    private boolean withLettuce;
    private boolean withTomato;
    private boolean withOnions;
    private boolean withCheese;
    private double cost;

    public Hamburger(String bread, String meat, double cost) {
        this.bread = bread;
        this.meat = meat;
        this.cost = cost;
    }

    public void addLettuce() {
        withLettuce = true;
    }

    public void addTomato() {
        withTomato = true;
    }

    public void addOnions() {
        withOnions = true;
    }

    public void addCheese() {
        withCheese = true;
    }

    public void showOrder() {
        System.out.println("Your burger started off at " + cost);
        if (withLettuce)
            System.out.println("Added lettuce for an extra " + lettuceCost);
            cost += lettuceCost;
        if (withTomato)
            System.out.println("Added tomato for an extra " + tomatoCost);
            cost += tomatoCost;
        if (withOnions)
            System.out.println("Added onions for an extra " + onionsCost);
            cost += onionsCost;
        if (withCheese)
            System.out.println("Added cheese for an extra " + cheeseCost);
            cost += cheeseCost;
        System.out.println("Your burger is coming with " + bread
                + " bread and a " + meat + " patty.");
        System.out.println(String.format("Your total is %.2f", cost));
    }
}

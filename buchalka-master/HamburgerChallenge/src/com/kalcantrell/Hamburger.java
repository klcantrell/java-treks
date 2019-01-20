package com.kalcantrell;

public class Hamburger {
    private static double baseCost;
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
    protected double cost;

    public Hamburger(String bread, String meat, double cost) {
        this.bread = bread;
        this.meat = meat;
        this.cost = cost;
        this.baseCost = cost;
    }

    public void addLettuce() {
        withLettuce = true;
        cost += lettuceCost;
    }

    public void addTomato() {
        withTomato = true;
        cost += tomatoCost;
    }

    public void addOnions() {
        withOnions = true;
        cost += onionsCost;
    }

    public void addCheese() {
        withCheese = true;
        cost += cheeseCost;
    }

    protected void showToppings() {
        if (withLettuce)
            System.out.println("Added lettuce for an extra " + lettuceCost);

        if (withTomato)
            System.out.println("Added tomato for an extra " + tomatoCost);

        if (withOnions)
            System.out.println("Added onions for an extra " + onionsCost);

        if (withCheese)
            System.out.println("Added cheese for an extra " + cheeseCost);
    }

    public void showOrder() {
        System.out.println(String.format("Your burger started off at %.2f", baseCost));
        showToppings();
        System.out.println("Your burger is coming with " + bread
                + " bread and a " + meat + " patty.");
        System.out.println(String.format("Your total is %.2f", cost));
    }
}

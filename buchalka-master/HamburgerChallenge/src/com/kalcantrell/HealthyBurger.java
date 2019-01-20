package com.kalcantrell;

public class HealthyBurger extends Hamburger {
    private static double picklesCost = 0.40;
    private static double saladCost = 1.00;

    private boolean withPickles;
    private boolean withSalad;


    public HealthyBurger(double cost) {
        super("rye", "turkey", cost);

    }

    public void addPickles() {
        withPickles = true;
        cost += picklesCost;
    }

    public void addSalad() {
        withSalad = true;
        cost += saladCost;
    }

    @Override
    protected void showToppings() {
        super.showToppings();
        if (withPickles)
            System.out.println("Added pickles for " + picklesCost);
        if (withSalad)
            System.out.println("Added salad for " + saladCost);
    }
}

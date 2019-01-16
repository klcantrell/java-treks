package com.app;

public class Soy extends CondimentDecorator {

    public Soy(Beverage beverage) {
        this.beverage = beverage;
    }

    public String getDescription() {
        return beverage.getDescription() + ", Soy";
    }

    public double cost() {
        double cost = beverage.cost();
        Size beverageSize = beverage.getSize();
        if (beverageSize == Size.TALL)
            cost += .10;
        if (beverageSize == Size.GRANDE)
            cost += .15;
        if (beverageSize == Size.VENTI)
            cost += .20;

        return cost;
    }
}

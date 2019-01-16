package com.kalcantrell;

public class DeluxeHamburger extends Hamburger {

    public DeluxeHamburger(String bread, String meat) {
        super(bread, meat, 4.00);
    }

    @Override
    public void addLettuce() {
        System.out.println("You cannot order lettuce with a deluxe burger");;
    }

    @Override
    public void addTomato() {
        System.out.println("You cannot order tomato with a deluxe burger");
    }

    @Override
    public void addOnions() {
        System.out.println("You cannot order onions with a deluxe burger");
    }

    @Override
    public void addCheese() {
        System.out.println("You cannot order cheese with a deluxe burger");
    }

    @Override
    public void showToppings() {
        System.out.println("Your burger comes with chips and a drink");
    }
}

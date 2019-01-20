package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        System.out.println("Hamburger order");
        Hamburger myBurger = new Hamburger("white", "beef", 1.00d);
        myBurger.addCheese();
        myBurger.addLettuce();
        myBurger.showOrder();

        System.out.println();

        System.out.println("Healthy burger order");
        HealthyBurger healthyBurger = new HealthyBurger(2.00d);
        healthyBurger.addLettuce();
        healthyBurger.addPickles();
        healthyBurger.addCheese();
        healthyBurger.showOrder();

        System.out.println();

        System.out.println("Deluxe burger order");
        DeluxeHamburger deluxeHamburger = new DeluxeHamburger("sourdough", "bison");
        deluxeHamburger.addCheese();
        deluxeHamburger.showOrder();
    }
}

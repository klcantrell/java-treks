package com.app;

public class Main {

    public static void main(String[] args) {
        Pizza pizzaForKal = new NewYorkPizzaStore().orderPizza("pepperoni");
        Pizza pizzaForJordan = new ChicagoPizzaStore().orderPizza("veggie");
        System.out.println(pizzaForKal.toString());
        System.out.println(pizzaForJordan.toString());
    }
}

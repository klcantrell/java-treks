package com.kalcantrell;

public class Main {

    public static void main(String[] args) {
        Hamburger myBurger = new Hamburger("white", "beef", 1.00);
        myBurger.addCheese();
        myBurger.addLettuce();
        myBurger.showOrder();
    }
}

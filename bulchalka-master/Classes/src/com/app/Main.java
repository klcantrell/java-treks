package com.app;

public class Main {

    public static void main(String[] args) {
	    Car honda = new Car();
	    honda.setModel("FIT");
	    String model = honda.getModel();
        System.out.println("Model is " + model);
    }
}

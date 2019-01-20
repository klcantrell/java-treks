package com.app;

public class Car {
    private int doors;
    private int wheels;
    private String model;
    private String engine;
    private String color;

    public void setModel(String model) {
        String carModel = model.toLowerCase();
        if (carModel.equals("fit") || carModel.equals("tiguan")) {
            this.model = carModel;
        } else {
            this.model = "Unknown";
        }
    }

    public String getModel() {
        return this.model;
    }
}

package com.app;

public class ThickCrustDough implements Dough {
    private String name;

    public ThickCrustDough() {
        bake();
    }

    public void bake() {
        System.out.println("Baked thick crust dough");
    }

}

package com.app;

public class Desk {
    private int height;
    private int width;
    private int depth;
    private String material;

    public Desk(int height, int width, int depth, String material) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.material = material;
    }

    public void openDrawer() {
        System.out.println("Opened desk drawer");
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public int getDepth() {
        return depth;
    }

    public String getMaterial() {
        return material;
    }
}

package com.kalcantrell;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantityStock() {
        return quantityStock;
    }

    public void setPrice(double price) {
        if (price > 0d) {

        }
        this.price = price;
    }
}

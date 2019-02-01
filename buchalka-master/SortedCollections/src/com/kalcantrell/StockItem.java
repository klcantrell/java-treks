package com.kalcantrell;

public class StockItem implements Comparable<StockItem> {
    private final String name;
    private double price;
    private int quantityStock;
    private int reservedStock;

    public StockItem(String name, double price) {
        this.name = name;
        this.price = price;
        this.quantityStock = 0;
        this.reservedStock = 0;
    }

    public StockItem(String name, double price, int quantityStock) {
        this.name = name;
        this.price = price;
        this.quantityStock = quantityStock;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int quantityInStock() {
        return quantityStock;
    }

    public int quantityReserved() {
        return reservedStock;
    }

    public void setPrice(double price) {
        if (price > 0d) {
            this.price = price;
        }
        this.price = price;
    }

    public int reserveStock(int quantity) {
        if (quantity <= 0) {
            System.out.println("You must reserve at least one item");
            return 0;
        }
        if (quantity + this.reservedStock > this.quantityStock) {
            System.out.println("We don't have enough " + this.name + "s" + "\n" +
                    "You can reserve up to " + (this.quantityStock - this.reservedStock));
            return 0;
        }
        this.reservedStock += quantity;
        return quantity;
    }

    public int unreserveStock(int quantity) {
        if (quantityStock <= 0) {
            System.out.println("You must unreserve at least one item");
            return 0;
        }
        if (this.reservedStock - quantity < 0) {
            System.out.println("It's not possible for your to have this many items in your basket");
            return 0;
        }
        this.reservedStock -= quantity;
        return quantity;
    }

    public void adjustReserved(int quantity) {
        int newQuantity = this.reservedStock + quantity;
        if (newQuantity <= this.quantityStock && newQuantity > 0) {
            this.reservedStock = newQuantity;
        }
    }

    public void adjustStock(int quantity) {
        int newQuantity = this.quantityStock + quantity;
        if (newQuantity >= 0) {
            this.quantityStock = newQuantity;
        }
    }

    @Override
    public boolean equals(Object obj) {
        System.out.println("Entering StockItem.equals");
        if (obj == this) {
            return true;
        }
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }

        String objName = ((StockItem) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() {
        return this.name.hashCode() + 31;
    }

    @Override
    public int compareTo(StockItem o) {
        System.out.println("Entering StockItem.compareTo");
        if (this == o) {
            return 0;
        }
        if (o != null) {
            return this.name.compareTo(o.getName());
        }
        throw new NullPointerException("You need to pass in a StockItem");
    }

    @Override
    public String toString() {
        return this.name + ": " + this.price;
    }
}

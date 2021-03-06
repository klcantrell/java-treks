package com.kalcantrell;

import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class Basket {
    private final String name;
    private Map<StockItem, Integer> list;

    public Basket(String name) {
        this.name = name;
        this.list = new TreeMap<>(); // sorts items as added using compareTo
    }

    public int addToBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            list.put(item, inBasket + quantity);
            return inBasket;
        }
        return 0;
    }

    public int removeFromBasket(StockItem item, int quantity) {
        if (item != null && quantity > 0) {
            int inBasket = list.getOrDefault(item, 0);
            if (inBasket == 0) {
                System.out.println("You have no items to remove");
                return 0;
            }
            if (inBasket - quantity < 0) {
                System.out.println("You can only remove " + inBasket + " items");
                return 0;
            }
            list.put(item, inBasket - quantity);
            return quantity;
        }
        return 0;
    }

    public void emptyBasket() {
        this.list.clear();
    }

    public Map<StockItem, Integer> getItems() {
        return Collections.unmodifiableMap(list);
    }

    @Override
    public String toString() {
        String s = "\nShopping basket " + this.name + " contains " + list.size() + " product(s)\n";
        double totalCost = 0d;
        for (Map.Entry<StockItem, Integer> item : list.entrySet()) {
            s = s + item.getKey() + ": " + item.getValue() + " purchased\n";
            totalCost += item.getKey().getPrice() * item.getValue();
        }
        return s + "Total cost: " + totalCost;
    }
}

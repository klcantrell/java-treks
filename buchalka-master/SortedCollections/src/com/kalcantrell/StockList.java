package com.kalcantrell;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class StockList {
    private final Map<String, StockItem> list;

    public StockList() {
        this.list = new LinkedHashMap<>(); // maintains order of when map is created
    }

    public int addStock(StockItem item) {
        if (item != null) {
            StockItem inStock = list.getOrDefault(item.getName(), item);
            if (inStock != item) {
                inStock.adjustStock(item.quantityInStock());
            }
            list.put(item.getName(), inStock);
            return item.quantityInStock();
        }
        return 0;
    }

    public int reserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock != null &&
                inStock.quantityReserved() + quantity <= inStock.quantityInStock() &&
                quantity > 0) {
            inStock.adjustReserved(quantity);
            return quantity;
        }
        return 0;
    }

    public int unreserveStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock != null &&
                inStock.quantityReserved() - quantity > 0 &&
                quantity > 0) {
            inStock.adjustReserved(-quantity);
            return quantity;
        }
        return 0;
    }

    public int sellStock(String item, int quantity) {
        StockItem inStock = list.getOrDefault(item, null);
        if (inStock != null && inStock.quantityInStock() >= quantity && quantity > 0) {
            inStock.adjustStock(-quantity);
            inStock.adjustReserved(-quantity);
            return quantity;
        }
        return 0;
    }

    public StockItem getItem (String name) {
        return list.get(name);
    }

    public Map<String, StockItem> getItems() {
        return Collections.unmodifiableMap(list);
    }

    public Map<String, Double> priceList() {
        Map<String, Double> prices = new LinkedHashMap<>();
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            prices.put(item.getKey(), item.getValue().getPrice());
        }
        return Collections.unmodifiableMap(prices);
    }

    @Override
    public String toString() {
        String s = "\nStock List\n";
        double totalCost = 0d;
        for (Map.Entry<String, StockItem> item : list.entrySet()) {
            StockItem stockItem = item.getValue();

            double itemValue = stockItem.getPrice() * stockItem.quantityInStock();
            s = s + stockItem + ".  There are " + stockItem.quantityInStock() + " in stock.  Value of items: ";
            s = s + String.format("%.2f", itemValue) + "\n";
            totalCost += itemValue;
        }
        return s + "Total stock value " + String.format("%.2f", totalCost);
    }
}

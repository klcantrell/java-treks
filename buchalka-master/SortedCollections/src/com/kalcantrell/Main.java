package com.kalcantrell;

import java.util.Map;

public class Main {
    private static StockList stockList = new StockList();

    public static void main(String[] args) {
        StockItem temp = new StockItem("bread", 0.86, 100);
        stockList.addStock(temp);

        temp = new StockItem("cake", 1.10, 7);
        stockList.addStock(temp);

        temp = new StockItem("car", 12.50, 2);
        stockList.addStock(temp);

        temp = new StockItem("chair", 62.00, 10);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.50, 200);
        stockList.addStock(temp);

        temp = new StockItem("cup", 0.0, 7);
        stockList.addStock(temp);

        temp = new StockItem("door", 72.95, 4);
        stockList.addStock(temp);

        temp = new StockItem("juice", 2.50, 36);
        stockList.addStock(temp);

        temp = new StockItem("phone", 99.99, 35);
        stockList.addStock(temp);

        temp = new StockItem("towel", 2.40, 80);
        stockList.addStock(temp);

        temp = new StockItem("vase", 8.76, 40);
        stockList.addStock(temp);

        System.out.println(stockList);

        Basket kalsBasket = new Basket("Kal");
        reserveItem(kalsBasket, "car", 1);
        System.out.println(kalsBasket);
        reserveItem(kalsBasket, "car", 1);
        reserveItem(kalsBasket, "car", 1);
        unreserveItem(kalsBasket, "car", 1);
        reserveItem(kalsBasket, "spanner", 5);
        System.out.println(kalsBasket);
        reserveItem(kalsBasket, "juice", 4);
        reserveItem(kalsBasket, "cup", 12);
        reserveItem(kalsBasket, "bread", 1);
        unreserveItem(kalsBasket, "bread", 20);
        unreserveItem(kalsBasket, "cool whip", 20);
        unreserveItem(kalsBasket, "door", 20);
        System.out.println(kalsBasket);
        System.out.println(stockList);

        temp = new StockItem("pen", 1.12);
        //stockList.getItems().put(temp.getName(), temp); // won't work because map is unmodifiable

        // stockList.getItems().get("car").adjustStock(1000);
        // System.out.println(stockList); // although map is unmodifiable, individual items can be modified

        System.out.println();
        for (Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

        checkout(kalsBasket);

        System.out.println(stockList);
        System.out.println(kalsBasket);
    }

    public static int reserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item + "s");
            return 0;
        }
        if (stockList.reserveStock(item, quantity) != 0) {
            return basket.addToBasket(stockItem, quantity);
        }
        System.out.println("We don't have enough " + item + "s to sell");
        return 0;
    }

    public static int unreserveItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item + "s");
            return 0;
        }
        if (stockList.unreserveStock(item, quantity) != 0) {
            return basket.removeFromBasket(stockItem, quantity);
        }
        System.out.println("You must not have that many " + item + "s in your cart");
        return 0;
    }

    public static void checkout(Basket basket) {
        double totalCost = 0d;
        System.out.println("\nPurchased:\n");
        for (Map.Entry<StockItem, Integer> item : basket.getItems().entrySet()) {
            String itemName = item.getKey().getName();
            stockList.sellStock(itemName, item.getValue());
            System.out.println("\t" + item.getKey() + " (" + item.getValue() + ")");
            totalCost += item.getValue() * item.getKey().getPrice();
        }
        basket.emptyBasket();
        System.out.println("\nTotal cost: " + String.format("%.2f" ,totalCost));
    }


}

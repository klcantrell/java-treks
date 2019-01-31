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
        sellItem(kalsBasket, "car", 1);
        System.out.println(kalsBasket);
        sellItem(kalsBasket, "car", 1);
        sellItem(kalsBasket, "car", 1);
        sellItem(kalsBasket, "spanner", 5);
        System.out.println(kalsBasket);
        sellItem(kalsBasket, "juice", 4);
        sellItem(kalsBasket, "cup", 12);
        sellItem(kalsBasket, "bread", 1);
        System.out.println(kalsBasket);
        System.out.println(stockList);

        temp = new StockItem("pen", 1.12);
        //stockList.getItems().put(temp.getName(), temp); // won't work because map is unmodifiable

        stockList.getItems().get("car").adjustStock(1000);
        // System.out.println(stockList); // although map is unmodifiable, individual items can be modified

        for (Map.Entry<String, Double> price : stockList.priceList().entrySet()) {
            System.out.println(price.getKey() + " costs " + price.getValue());
        }

    }

    public static int sellItem(Basket basket, String item, int quantity) {
        StockItem stockItem = stockList.getItem(item);
        if (stockItem == null) {
            System.out.println("We don't sell " + item + "s");
            return 0;
        }
        if (stockList.sellStock(item, quantity) != 0) {
            basket.addToBasket(stockItem, quantity);
            return quantity;
        }
        System.out.println("We don't have enough " + item + "s to sell");
        return 0;
    }

}

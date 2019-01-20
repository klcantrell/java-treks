package com.app;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions;

    public Customer(String name, double initialTransaction) {
        this.name = name;
        this.transactions = new ArrayList<Double>();
        this.transactions.add(initialTransaction);
    }

    public String getName() {
        return name;
    }

    public void addTransaction(double transaction) {
        transactions.add(transaction);
    }

    public void printTransactions() {
        for (int i = 0; i < transactions.size(); i++) {
            double transaction = transactions.get(i);
            System.out.println("\t\t" + transaction);
        }
    }
}

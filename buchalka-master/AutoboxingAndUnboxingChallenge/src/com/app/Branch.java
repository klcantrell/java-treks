package com.app;

import java.util.ArrayList;

public class Branch {
    private String name;
    private ArrayList<Customer> customers;

    public Branch(String name) {
        this.customers = new ArrayList<Customer>();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public boolean addCustomer(String name, double initialTransaction) {
        if (findCustomer(name) == null) {
            Customer newCustomer = new Customer(name, initialTransaction);
            customers.add(newCustomer);
            return true;
        }
        return false;
    }

    public boolean addTransaction(String customerName, double transaction) {
        Customer customer = findCustomer(customerName);
        if (customer != null) {
            customer.addTransaction(transaction);
            return true;
        }
        return false;
    }

    public void showCustomers() {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            System.out.println("\t" + customer.getName());
            customer.printTransactions();
        }
    }

    private Customer findCustomer(String name) {
        for (int i = 0; i < customers.size(); i++) {
            Customer customer = customers.get(i);
            if (customer.getName().equals(name)) {
                return customer;
            }
        }
        return null;
    }

}

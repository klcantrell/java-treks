package com.app;

public class Main {

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.addBranch("Indianapolis");
        bank.addCustomer("Indianapolis", "Kal");
        bank.addCustomer("Midgar", "Cloud");
        bank.addTransaction("Indianapolis", "Kal", 10.00);
        bank.addTransaction("Indianapolis", "Kal", -15.00);
        bank.addTransaction("Indianapolis", "Cloud", -15.00);
        bank.addBranch("Midgar");
        bank.addCustomer("Midgar", "Cloud", 20.00);
        bank.addTransaction("Midgar", "Cloud", 200.00);
        bank.addBranch("Midgar");
        bank.showCustomers();
    }
}

package com.app;

public class Bank {
    private String number;
    private double balance = 0;
    private String customerName;
    private String customerEmail;
    private String customerPhoneNumber;


    public Bank() {
        this("000", 1, "noemail", "noname", "nophone");
        System.out.println("empty constructor");
    }

    public Bank(String customerEmail, String customerName, String customerPhoneNumber) {
        this("000", 0, customerEmail, customerName, customerPhoneNumber);
    }

    public Bank(String number, double balance, String customerEmail, String customerName, String customerPhoneNumber) {
        this.number = number;
        this.balance = balance;
        this.customerEmail = customerEmail;
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        System.out.println("constructor with parameters");
    }

    public void deposit(double amount) {
        this.balance += amount;
        System.out.println("YOU JUST DEPOSITED " + amount + ". " + "BALANCE: " + this.balance + ".");
    }

    public void withraw(double amount) {
        if (amount > this.balance) {
            System.out.println("NOT ENOUGH FUNDS" + ". " + "BALANCE: " + this.balance + ".");
        } else {
            this.balance -= amount;
            System.out.println("YOU JUST WITHDREW " + amount + ". " + "BALANCE: " + this.balance + ".");
        }
    }

    public double getBalance() {
        return balance;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }
}

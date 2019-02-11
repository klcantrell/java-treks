package com.app;

public class BankAccount {
    private String firstName;
    private String lastName;
    private double balance;
    private AccountType accountType;

    public enum AccountType {
        CHECKING,
        SAVING
    }

    public BankAccount(String firstName, String lastName, double balance, AccountType accountType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.balance = balance;
        this.accountType = accountType;
    }

    // branch is true if customer performs transaction with teller
    public double deposit(double amount, boolean branch) {
        balance += amount;
        return balance;
    }

    public double withdraw(double amount, boolean branch) {
        balance -= amount;
        return balance;
    }

    public double getBalance() {
        return balance;
    }

    public boolean isChecking() {
        return this.accountType == AccountType.CHECKING;
    }
}

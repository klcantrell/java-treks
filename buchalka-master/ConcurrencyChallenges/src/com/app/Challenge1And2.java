package com.app;

public class Challenge1And2 {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount("12345-678", 1000.00);

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300.00);
                bankAccount.withdraw(50.00);
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100.00);
            }
        }).start();
    }
}

class BankAccount {
    private double balance;
    private String accountNumber;

    public BankAccount(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
    }

    public synchronized void deposit(double amount) {
        balance += amount;
        System.out.println("Deposited " + amount + ". Balance is " + balance);
    }

    public synchronized void withdraw(double amount) {
        balance -= amount;
        System.out.println("Withdrew " + amount + ". Balance is " + balance);
    }
}
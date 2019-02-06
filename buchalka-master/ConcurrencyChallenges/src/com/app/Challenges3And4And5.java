package com.app;

public class Challenges3And4And5 {
    public static void main(String[] args) {
        BankAccount3And4And5 bankAccount = new BankAccount3And4And5("12345-678", 1000.00);

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(300.00);
                bankAccount.withdraw(50.00);
                bankAccount.printAccountNumber();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                bankAccount.deposit(203.75);
                bankAccount.withdraw(100.00);
                bankAccount.printAccountNumber();
            }
        }).start();
    }
}

class BankAccount3And4And5 {
    private double balance;
    private String accountNumber;

    public BankAccount3And4And5(String accountNumber, double initialBalance) {
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

    // no need to synchronize... just reading.  this would introduce unnecessary performance issues.{
    public String getAccountNumber() {
        return accountNumber;
    }

    // no need to synchronize... just reading.  this would introduce unnecessary performance issues.{
    public void printAccountNumber() {
        System.out.println("Account number is " + this.accountNumber);
    }
}

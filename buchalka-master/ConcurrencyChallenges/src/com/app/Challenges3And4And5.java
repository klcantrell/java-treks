package com.app;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

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
    private Lock lock;

    public BankAccount3And4And5(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    balance += amount;
                    System.out.println("Deposited " + amount + ". Balance is " + balance);
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Could not get the lock");
        }
    }

    public void withdraw(double amount) {
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    balance -= amount;
                    System.out.println("Withdrew " + amount + ". Balance is " + balance);
                } finally {
                    this.lock.unlock();
                }
            } else {
                System.out.println("Could not get the lock");
            }
        } catch (InterruptedException e) {
            System.out.println("Something went wrong");
        }
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is " + this.accountNumber);
    }
}

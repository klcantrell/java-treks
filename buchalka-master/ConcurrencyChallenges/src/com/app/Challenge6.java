package com.app;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Challenge6 {
    public static void main(String[] args) {
        BankAccount6 bankAccount = new BankAccount6("12345-678", 1000.00);

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

class BankAccount6 {
    private double balance;
    private String accountNumber;
    private Lock lock;

    public BankAccount6(String accountNumber, double initialBalance) {
        this.accountNumber = accountNumber;
        this.balance = initialBalance;
        this.lock = new ReentrantLock();
    }

    public void deposit(double amount) {
        boolean status = false; // thread safe because already on the thread stack
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    status = true;
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
        System.out.println("Transaction status = " + status);
    }

    public void withdraw(double amount) {
        boolean status = false; // thread safe because already on the thread stack
        try {
            if (lock.tryLock(100, TimeUnit.MILLISECONDS)) {
                try {
                    status = true;
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
        System.out.println("Transaction status = " + status);
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void printAccountNumber() {
        System.out.println("Account number is " + this.accountNumber);
    }
}

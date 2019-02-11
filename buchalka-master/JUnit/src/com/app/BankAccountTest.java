package com.app;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import com.app.BankAccount.AccountType;

class BankAccountTest {

    @Test
    void deposit() {
        BankAccount account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.CHECKING);
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @Test
    void withdraw() {
        fail("This test needs to be implemented");
    }

    @Test
    void getBalance_deposit() {
        BankAccount account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.CHECKING);
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw() {
        BankAccount account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.CHECKING);
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @Test
    void isChecking() {
        BankAccount account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.SAVING);
        assertTrue(account.isChecking(), "The account is not a checking account");
    }
}
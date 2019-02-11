package com.app;

import com.app.BankAccount.AccountType;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class BankAccountTest {
    private BankAccount account;
    private static int count;

    @BeforeAll
    static void beforeAll() {
        System.out.println("Executes before all test cases. Count = " + count++);
    }

    @BeforeEach
    public void setup() {
        System.out.println("Running a test");
        account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.CHECKING);
    }

    @Test
    void deposit() {
        double balance = account.deposit(200.00, true);
        assertEquals(1200, balance, 0);
    }

    @Test
    void withdraw_branch() {
        double balance = account.withdraw(600.00, true);
        assertEquals(400.00, balance, 0);
    }

    @Test
    void withdraw_notBranch() {
        assertThrows(IllegalArgumentException.class, () -> account.withdraw(600.00, false));
    }

    @Test
    void getBalance_deposit() {
        account.deposit(200.00, true);
        assertEquals(1200, account.getBalance(), 0);
    }

    @Test
    void getBalance_withdraw() {
        account.withdraw(200.00, true);
        assertEquals(800, account.getBalance(), 0);
    }

    @Test
    void isChecking() {
        assertTrue(account.isChecking(), "The account is not a checking account");
    }

    @AfterEach
    void teardown() {
        System.out.println("This executes after each test case.  Count = " + count++);
    }

    @AfterAll
    static void afterAll() {
        System.out.println("Executes after all test cases. Count = " + count);
    }
}
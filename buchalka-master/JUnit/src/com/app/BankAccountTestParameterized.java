package com.app;

import org.junit.jupiter.api.BeforeEach;
import com.app.BankAccount.AccountType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTestParameterized {
    private BankAccount account;

    static Stream<Arguments> deposit_Parameters() {
        return Stream.of(
                Arguments.of(100.00, true, 1100.00),
                Arguments.of(200.00, true, 1200.00),
                Arguments.of(325.14, true, 1325.14),
                Arguments.of(489.33, true, 1489.33),
                Arguments.of(1000.00, true, 2000.00)
        );
    }

    @BeforeEach
    void setup() {
        account = new BankAccount("Kal", "Cantrell", 1000.00, AccountType.CHECKING);
    }

    @ParameterizedTest(name="Run {index}: amount={0}, branch={1}, expected={2}")
    @MethodSource("deposit_Parameters")
    void deposit(double amount, boolean branch, double expected) {
        double balance = account.deposit(amount, branch);
        assertEquals(expected, balance, 0.001);
    }
}

package com.app;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MyMathTest {

    MyMath myMath;

    public MyMathTest() {
        myMath = new MyMath();
    }

    @BeforeAll
    public void beforeAll() {
        System.out.println("Before all");
    }

    @BeforeEach
    public static void beforeEach() {
        System.out.println("Before each");
    }

    @Test
    public void sum_with1Number() {
        int result = myMath.sum(new int[]{ 3 });
        assertEquals(3, result);
        System.out.println("Test 1");
    }

    @Test
    public void sum_with3Numbers() {
        int result = myMath.sum(new int[]{ 1, 2, 3 });
        assertEquals(6, result);
        System.out.println("Test 2");
    }

    @AfterEach
    public static void afterEach() {
        System.out.println("After each");
    }

    @AfterAll
    public void afterAll() {
        System.out.println("After all");
    }

}
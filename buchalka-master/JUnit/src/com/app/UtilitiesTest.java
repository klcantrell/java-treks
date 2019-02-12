package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

class UtilitiesTest {
    static Utilities utils;

    @BeforeEach
    void setup() {
        utils = new Utilities();
    }

    @Test
    void everyNthChar() {
        fail("Test must be implemented");
    }

    @Test
    void removePairs() {
        String case1 = utils.removePairs("AABCDDEFF");
        String case2 = utils.removePairs("ABCCABDEEF");

        assertEquals("ABCDEF", case1);
        assertEquals("ABCABDEF", case2);
    }

    @Test
    void converter() {
        fail("Test must be implemented");
    }

    @Test
    void nullIfOddLength() {
        fail("Test must be implemented");
    }
}
package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
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
        String testCase1 = utils.removePairs("AABCDDEFF");
        String testCase2 = utils.removePairs("ABCCABDEEF");

        assertEquals("ABCDEF", testCase1);
        assertEquals("ABCABDEF", testCase2);
    }

    @Test
    void removePairs_sourceLengthTwoNonPair() {
        String testCase = utils.removePairs("AB");

        assertEquals("AB", testCase);
    }

    @Test
    void removePairs_sourceLengthTwoPair() {
        String testCase = utils.removePairs("AA");

        assertEquals("A", testCase);
    }

    @Test
    void removePairs_sourceLengthOne() {
        String testCase = utils.removePairs("A");

        assertEquals("A", testCase);
    }

    @Test
    void removePairs_sourceLengthEmpty() {
        String testCase = utils.removePairs("");

        assertEquals("", testCase);
    }

    @Test
    void removePairs_sourceNull() {
        assertNull(utils.removePairs(null));
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
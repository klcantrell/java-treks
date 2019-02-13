package com.app;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

class UtilitiesTest {
    static Stream<Arguments> removePairs_Parameters() {
        return Stream.of(
                Arguments.of("ABCDEFF", "ABCDEF"),
                Arguments.of("AB88EFFG", "AB8EFG"),
                Arguments.of("112233445566", "123456"),
                Arguments.of("ZYZQQB", "ZYZQB"),
                Arguments.of("A", "A")
        );
    }

    private Utilities utils;

    @BeforeEach
    void setup() {
        utils = new Utilities();
    }

    @Test
    void everyNthChar() {
        char[] actual = utils.everyNthChar(new char[] {'h', 'e', 'l', 'l', 'o'}, 2);

        assertArrayEquals(new char[] {'e', 'l'}, actual);
    }

    @Test
    void everyNthChar_nGreaterThanArray() {
        char[] source = new char[] {'h', 'e', 'l', 'l', 'o'};
        char[] actual = utils.everyNthChar(source, 6);

        assertArrayEquals(source, actual);
    }

    @Test
    void removePairs() {
        String actual1 = utils.removePairs("AABCDDEFF");
        String actual2 = utils.removePairs("ABCCABDEEF");

        assertEquals("ABCDEF", actual1);
        assertEquals("ABCABDEF", actual2);
    }

    @ParameterizedTest(name="Run {index}: source={0}, expected={1}")
    @MethodSource("removePairs_Parameters")
    void removePairs_parameterized(String source, String expected) {
        String actual = utils.removePairs(source);
        assertEquals(expected, actual);
    }

    @Test
    void removePairs_sourceLengthTwoPair() {
        String actual = utils.removePairs("AA");

        assertEquals("A", actual);
    }

    @Test
    void removePairs_sourceLengthOne() {
        String actual = utils.removePairs("A");

        assertEquals("A", actual);
    }

    @Test
    void removePairs_sourceLengthEmpty() {
        String actual = utils.removePairs("");

        assertEquals("", actual);
    }

    @Test
    void removePairs_sourceNull() {
        assertNull(utils.removePairs(null));
    }

    @Test
    void converter_a10b5() {
        int actual = utils.converter(10, 5);
        assertEquals(300, actual);
    }

    @Test
    void converter_a10b0() {
        assertThrows(ArithmeticException.class, () -> utils.converter(10, 0)) ;
    }

    @Test
    void nullIfOddLength_sourceEven() {
        String source = "hi";
        String actual = utils.nullIfOddLength(source);

        assertEquals(source, actual);
    }

    @Test
    void nullIfOddLength_sourceOdd() {
        String source = "why";
        String actual = utils.nullIfOddLength(source);

        assertNull(actual);
    }
}
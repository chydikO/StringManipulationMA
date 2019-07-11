package com.company.util;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomazerTest {

    @Test
    void testGetRandomNumber() {
        Integer testNumber = Randomazer.getRandomNumber( 50, 100);
        assertNotNull(testNumber);
        assertTrue(testNumber >= 50 & testNumber <= 100);
    }

    @Test
    void testGetRandomString() {
        String  testString = Randomazer.getRandomString(20);
        assertNotNull(testString);
        assertEquals(20, testString.length());
    }
}
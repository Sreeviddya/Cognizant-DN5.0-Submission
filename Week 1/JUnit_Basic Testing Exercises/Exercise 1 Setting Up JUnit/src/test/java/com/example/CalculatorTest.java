package com.example;

import org.junit.Test;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void testAddition() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testSubtraction() {
        assertEquals(2, 5 - 3);
    }
}

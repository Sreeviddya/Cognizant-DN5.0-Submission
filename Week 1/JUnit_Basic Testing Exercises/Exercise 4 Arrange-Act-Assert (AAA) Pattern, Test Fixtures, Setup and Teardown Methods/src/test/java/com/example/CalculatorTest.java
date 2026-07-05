package com.example;

import org.junit.*;
import static org.junit.Assert.*;

public class CalculatorTest {

    @Before
    public void setUp() {
        System.out.println("Setup: initializing test resources");
    }

    @After
    public void tearDown() {
        System.out.println("Teardown: cleaning up test resources");
    }

    @Test
    public void testAddition() {
        // Arrange
        int a = 2, b = 3;

        // Act
        int result = a + b;

        // Assert
        assertEquals(5, result);
    }

    @Test
    public void testSubtraction() {
        // Arrange
        int a = 5, b = 3;

        // Act
        int result = a - b;

        // Assert
        assertEquals(2, result);
    }
}

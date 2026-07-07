package com.cognizant;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AAATest {

    private int num1;
    private int num2;

    @BeforeAll
    static void setupBeforeAll() {
        System.out.println("Before all tests");
    }

    @AfterAll
    static void cleanupAfterAll() {
        System.out.println("After all tests");
    }

    @BeforeEach
    void setupBeforeEach() {
        System.out.println("Before each test");
        num1 = 2;
        num2 = 3;
    }

    @AfterEach
    void cleanupAfterEach() {
        System.out.println("After each test");
    }

    @Test
    void testAddTwoNumbers() {

        // Arrange
        int expected = 5;

        // Act
        int result = num1 + num2;

        // Assert
        assertEquals(expected, result, "The sum should be 5");
    }

    @Test
    void testAnotherMethod() {
        System.out.println("Another test method");
    }
}

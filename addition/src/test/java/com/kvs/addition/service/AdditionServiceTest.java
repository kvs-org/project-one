package com.kvs.addition.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class AdditionServiceTest {

    private final AdditionService additionService = new AdditionService();

    @Test
    void testAddPositiveNumbers() {
        int result = additionService.add(5, 3);
        assertEquals(8, result, "5 + 3 should equal 8");
    }

    @Test
    void testAddNegativeNumbers() {
        int result = additionService.add(-5, -3);
        assertEquals(-8, result, "-5 + -3 should equal -8");
    }

    @Test
    void testAddPositiveAndNegativeNumber() {
        int result = additionService.add(5, -3);
        assertEquals(2, result, "5 + -3 should equal 2");
    }

    @Test
    void testAddWithZero() {
        int result = additionService.add(5, 0);
        assertEquals(5, result, "5 + 0 should equal 5");
    }
}
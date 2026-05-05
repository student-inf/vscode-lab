package com.lab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import static org.junit.jupiter.api.Assertions.*;


class CalculatorTest {

    private Calculator calculator;

    @BeforeEach
    void setUp() {
        calculator = new Calculator();
    }

    @Test
    void testCalculateSumProductRatio_basicCase() {
        double result = calculator.calculateSumProductRatio(4, 2);
        assertEquals(0.75, result, 0.001);
    }

    @Test
    void testCalculateSumProductRatio_withOne() {
        double result = calculator.calculateSumProductRatio(5, 1);
        assertEquals(1.2, result, 0.001);
    }

    @Test
    void testCalculateSumProductRatio_equalNumbers() {
        double result = calculator.calculateSumProductRatio(3, 3);
        assertEquals(0.6666, result, 0.001);
    }

    @Test
    void testCalculateSumProductRatio_largeNumbers() {
        double result = calculator.calculateSumProductRatio(10, 5);
        assertEquals(0.3, result, 0.001);
    }
}
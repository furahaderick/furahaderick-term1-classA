package com.derrick.demo.service;

import com.derrick.demo.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MathOperatorImplTest {
    private final MathOperator mathOperator = new MathOperatorImpl();

    //    addition test
    @Test
    void givenTwoNumbers_whenAdded_Returns_Sum() throws InvalidOperationException {
        assertEquals(9.0, mathOperator.calculate(5.0, 4.0, "+"));
    }
    @Test
    void givenZeroValues_whenAdded_returnZero() throws InvalidOperationException {
        assertEquals(0, mathOperator.calculate(0.0, 0.0, "+"));
    }
    // division tests
    @Test
    void givenTwoNumbers_whenDivided_returnQuotient () throws InvalidOperationException {
        assertEquals(2.0, mathOperator.calculate(10.0, 5.0, "/"));
    }
    @Test
    void throwException_whenDivisorIsZero() throws InvalidOperationException {
        Exception exception = assertThrows(InvalidOperationException.class, () -> {
            mathOperator.calculate(10.0, 0.0, "/");
        });
        assertEquals(exception.getMessage(), "Cannot divide by 0");
    }
    @Test
    void returnNumber_WhenDivide_ByOne() throws InvalidOperationException {
        assertEquals(8.0, mathOperator.calculate(8.0, 1.0, "/"));
    }
    // multiplication tests
    @Test
    void multipliedByOne_returnNumber() throws InvalidOperationException {
        assertEquals(8.0, mathOperator.calculate(8.0, 1.0, "*"));
    }

    @Test
    void multipliedByZero_ReturnZero() throws InvalidOperationException {
        assertEquals(0.0, mathOperator.calculate(8.0, 0.0, "*"));
    }
}

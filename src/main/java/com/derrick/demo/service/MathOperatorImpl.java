package com.derrick.demo.service;

import org.springframework.stereotype.Service;

import com.derrick.demo.exception.InvalidOperationException;

@Service
public class MathOperatorImpl implements MathOperator {

    @Override
    public double calculate(double operand1, double operand2, String operation) throws InvalidOperationException {
        if("/".equals(operation) && operand2 == (double) 0) {
            throw new InvalidOperationException("Cannot divide by 0");
        }

        return switch (operation) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> operand1 / operand2;
            default -> throw new RuntimeException("Unknown operation: " + operation);
        };
    }
}

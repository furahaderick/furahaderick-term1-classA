package com.derrick.demo.service;

import com.derrick.demo.exception.InvalidOperationException;

public interface MathOperator {
    double calculate(double operand1, double operand2, String operation) throws InvalidOperationException ;
}

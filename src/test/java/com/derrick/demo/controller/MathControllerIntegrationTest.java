package com.derrick.demo.controller;

import com.derrick.demo.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import static org.junit.jupiter.api.Assertions.*;

import com.derrick.demo.model.DoMathRequest;
import com.derrick.demo.model.MathResponse;
import com.derrick.demo.service.MathOperator;


public class MathControllerIntegrationTest {

    @Test
    void givenTwoNumbers_whenAdded_Returns_Sum() throws InvalidOperationException {
        MathOperator mathOperatorMock = Mockito.mock(MathOperator.class);
        Mockito.when(mathOperatorMock.calculate(5.0, 4.0, "+")).thenReturn(9.0);

        MathController mathController = new MathController(mathOperatorMock);

        DoMathRequest doMathRequest = new DoMathRequest();
        doMathRequest.setOperand1(5.0);
        doMathRequest.setOperand2(4.0);
        doMathRequest.setOperation("+");

        MathResponse mathResponse = mathController.doMath(doMathRequest);

        assertEquals(9.0, mathResponse.getCalcResponse());
    }
}

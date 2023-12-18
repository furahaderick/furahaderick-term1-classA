package com.derrick.demo.controller;

import com.derrick.demo.exception.InvalidOperationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.derrick.demo.model.MathResponse;
import com.derrick.demo.service.MathOperator;
import com.derrick.demo.model.DoMathRequest;

@RestController
@RequestMapping("/api/math")
public class MathController {

    private final MathOperator mathOperator;

    @Autowired
    public MathController(MathOperator mathOperator) {
        this.mathOperator = mathOperator;
    }

    @PostMapping("/doMath")
    public MathResponse doMath(@RequestBody DoMathRequest doMathRequest) throws InvalidOperationException {
        double operand1 = doMathRequest.getOperand1();
        double operand2 = doMathRequest.getOperand2();
        String operation = doMathRequest.getOperation();
        double result = mathOperator.calculate(operand1, operand2, operation);

        MathResponse mathResponse = new MathResponse();
        mathResponse.setCalcResponse(result);

        return mathResponse;
    }
}

package com.derrick.demo.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.derrick.demo.model.DoMathRequest;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerEndToEndTest {
    @Autowired
    private MockMvc mockMvc;

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void givenTwoNumbers_whenAdded_Returns_Sum() throws Exception {
        DoMathRequest doMathRequest = new DoMathRequest();
        doMathRequest.setOperand1(5.0);
        doMathRequest.setOperand2(4.0);
        doMathRequest.setOperation("+");

        // perform an HTTP post request and validate the response
        mockMvc.perform(MockMvcRequestBuilders.post("/api/math/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(doMathRequest)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.calcResponse").value(9.0));
    }
}

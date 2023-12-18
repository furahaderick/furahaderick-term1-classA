package com.derrick.demo.controller;

import com.derrick.demo.exception.InvalidOperationException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.derrick.demo.model.DoMathRequest;
import com.derrick.demo.model.MathResponse;

@SpringBootTest
@AutoConfigureMockMvc
public class MathControllerEndToEndTest {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void givenTwoNumbers_whenAdded_Returns_Sum() throws Exception {
        String doMathRequestJSON = "{ \\\"operand1\\\": 5.0, \\\"operand2\\\": 4.0, \\\"operation\\\": \\\"+\\\" }";

        mockMvc.perform(MockMvcRequestBuilders.post("/api/math/doMath")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(doMathRequestJSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("$.calcResponse").value(9.0));
    }
}

package com.google.solution.accident;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class AccidentDataApiProviderTest {

    @Autowired
    private AccidentDataApiProvider accidentDataApiProvider;

    @Test
    void apiTest() throws UnsupportedEncodingException {
        accidentDataApiProvider.apiTest();
    }
}
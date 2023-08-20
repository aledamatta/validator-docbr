package br.com.damatta.ie.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class AMTest {
    private AM validator;

    @BeforeEach
    void setUp() {
        validator = new AM();
    }

    @Test
    void validIE() {
        final var ie = "025475746";
        final var result = validator.isValid(ie);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidIE() {
        final var ie = "248156310";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIESizeIsNot9Characters() {
        var ie = "0105482";
        var result = validator.isValid(ie);
        Assertions.assertFalse(result);

        ie = "0105482012123234243";
        result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }
}
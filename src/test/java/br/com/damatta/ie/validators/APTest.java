package br.com.damatta.ie.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class APTest {
    private AP validator;

    @BeforeEach
    void setUp() {
        validator = new AP();
    }

    @Test
    void validIE() {
        var ie = "032277393";
        var result = validator.isValid(ie);
        Assertions.assertTrue(result);

        ie = "038126273";
        result = validator.isValid(ie);
        Assertions.assertTrue(result);

        ie = "030141163";
        result = validator.isValid(ie);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidIE() {
        final var ie = "032278393";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIESizeIsNot9Characters() {
        var ie = "0305482";
        var result = validator.isValid(ie);
        Assertions.assertFalse(result);

        ie = "0305482012123234243";
        result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIENotStartWith03() {
        final var ie = "1100482300112";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }
}
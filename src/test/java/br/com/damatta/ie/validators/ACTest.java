package br.com.damatta.ie.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ACTest {

    private AC validator;

    @BeforeEach
    void setUp() {
        validator = new AC();
    }

    @Test
    void validIE() {
        final var ie = "0100482300112";
        final var result = validator.isValid(ie);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidIE() {
        final var ie = "0105482300112";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIESizeIsNot13Characters() {
        var ie = "0105482012";
        var result = validator.isValid(ie);
        Assertions.assertFalse(result);

        ie = "0105482012123234243";
        result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIENotStartWith01() {
        final var ie = "0200482300112";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }
}
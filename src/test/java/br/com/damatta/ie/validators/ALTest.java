package br.com.damatta.ie.validators;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ALTest {

    private AL validator;

    @BeforeEach
    void setUp() {
        validator = new AL();
    }

    @Test
    void validIE() {
        final var ie = "248186310";
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
        var ie = "2405482";
        var result = validator.isValid(ie);
        Assertions.assertFalse(result);

        ie = "2405482012123234243";
        result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidIENotStartWith24() {
        final var ie = "1100482300112";
        final var result = validator.isValid(ie);
        Assertions.assertFalse(result);
    }
}
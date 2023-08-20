package br.com.damatta.ie;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TIETest {
    private TIE validator;

    @BeforeEach
    void setUp() {
        validator = new TIE();
    }

    @Test
    void validIEAC() {
        final var ie = "01.004.823/001-12";
        final var result = validator.isValid(ie, "AC");
        Assertions.assertTrue(result);
    }

    @Test
    void invalidIEAC() {
        final var ie = "01.054.823/001-12";
        final var result = validator.isValid(ie, "AC");
        Assertions.assertFalse(result);
    }

}
package br.com.damatta.cnpj;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TCNPJTest {
    private TCNPJ validadorCnpj;

    @BeforeEach
    void setUp() {
        validadorCnpj = new TCNPJ();
    }

    @Test
    void isValidCnpj() {
        final var cnpjOk = "00000000000191";
        final var result = validadorCnpj.isValid(cnpjOk);
        Assertions.assertTrue(result);
    }

    @Test
    void isInvalidCnpj() {
        final var cnpjInvalid = "00000000000192";
        final var result = validadorCnpj.isValid(cnpjInvalid);
        Assertions.assertFalse(result);
    }
}
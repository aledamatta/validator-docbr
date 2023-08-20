package br.com.damatta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ValidatorDocBrTest {
    private ValidatorDocBr validador;

    @BeforeEach
    void setUp() {
        validador = new ValidatorDocBr();
    }

    @Test
    void validCnpj() {
        final var cnpjOk = "00000000000191";
        final var result = validador.isValidCnpj(cnpjOk);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidCnpjWith13caracteres() {
        final var cnpjInvalid = "0000000000191";
        final var result = validador.isValidCnpj(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjWith15caracteres() {
        final var cnpjInvalid = "000000000000191";
        final var result = validador.isValidCnpj(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCpf() {
        final var cpfOk = "17994794637";
        final var result = validador.isValidCpf(cpfOk);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidCpf() {
        final var cpfInvalid = "17994794636";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCpfWith10Caracteres() {
        final var cpfInvalid = "7994794636";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCpfWith12Caracteres() {
        final var cpfInvalid = "179947946363";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCnpjCpfWithIllegalCaracter() {
        final var cnpjOk = "00.000.000/0001-91";
        Assertions.assertFalse(validador.isValidCnpjCpf(cnpjOk));
    }

    @Test
    void validCnpjCpfWithCnpjOK() {
        final var cnpjOk = "00000000000191";
        final var result = validador.isValidCnpjCpf(cnpjOk);
        Assertions.assertTrue(result);
    }

    @Test
    void validCnpjCpfWithCnpjInvalid() {
        final var cnpjInvalid = "00000000000192";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCnpjCpfWithCpfOK() {
        final var cpfOk = "17994794637";
        final var result = validador.isValidCnpjCpf(cpfOk);
        Assertions.assertTrue(result);
    }

    @Test
    void validCnpjCpfWithCpfInvalid() {
        final var cpfInvalid = "17994794636";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith10caracteres() {
        final var cpfInvalid = "7994794636";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith12caracteres() {
        final var cpfInvalid = "179947946363";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith13caracteres() {
        final var cnpjInvalid = "0000000000191";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith15caracteres() {
        final var cnpjInvalid = "000000000000191";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }
}
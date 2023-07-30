package br.com.damatta;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ValidatorDocBrTest {
    private ValidatorDocBr validador;

    @BeforeEach
    void setUp() {
        validador = new ValidatorDocBr();
    }

    @Test
    void validCnpj() {
        final var cnpjOk = "00.000.000/0001-91";
        final var result = validador.isValidCnpj(cnpjOk);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidCnpjWith13caracteres() {
        final var cnpjInvalid = "0.000.000/0001-91";
        final var result = validador.isValidCnpj(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjWith15caracteres() {
        final var cnpjInvalid = "000.000.000/0001-91";
        final var result = validador.isValidCnpj(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCpf() {
        final var cpfOk = "179.947.946-37";
        final var result = validador.isValidCpf(cpfOk);
        Assertions.assertTrue(result);
    }

    @Test
    void invalidCpf() {
        final var cpfInvalid = "179.947.946-36";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCpfWith10Caracteres() {
        final var cpfInvalid = "79.947.946-36";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCpfWith12Caracteres() {
        final var cpfInvalid = "179.947.946-363";
        final var result = validador.isValidCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCnpjCpfWithCnpjOK() {
        final var cnpjOk = "00.000.000/0001-91";
        final var result = validador.isValidCnpj(cnpjOk);
        Assertions.assertTrue(result);
    }

    @Test
    void validCnpjCpfWithCnpjInvalid() {
        final var cnpjInvalid = "00.000.000/0001-92";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void validCnpjCpfWithCpfOK() {
        final var cpfOk = "179.947.946-37";
        final var result = validador.isValidCnpjCpf(cpfOk);
        Assertions.assertTrue(result);
    }

    @Test
    void validCnpjCpfWithCpfInvalid() {
        final var cpfInvalid = "179.947.946-36";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith10caracteres() {
        final var cpfInvalid = "79.947.946-36";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith12caracteres() {
        final var cpfInvalid = "179.947.946-363";
        final var result = validador.isValidCnpjCpf(cpfInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith13caracteres() {
        final var cnpjInvalid = "0.000.000/0001-91";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }

    @Test
    void invalidCnpjCpfWith15caracteres() {
        final var cnpjInvalid = "000.000.000/0001-91";
        final var result = validador.isValidCnpjCpf(cnpjInvalid);
        Assertions.assertFalse(result);
    }
}
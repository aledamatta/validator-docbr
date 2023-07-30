package br.com.damatta.cpf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TCPFTest {
    private TCPF validadorCpf;

    @BeforeEach
    void setUp() {
        validadorCpf = new TCPF();
    }

    @Test
    void isValidCPF() {
        final var cpfOk = "17994794637";
        final var result = validadorCpf.isValid(cpfOk);
        Assertions.assertTrue(result);
    }

    @Test
    void isInvalidCPF() {
        final var cpfInvalid = "17994794638";
        final var result = validadorCpf.isValid(cpfInvalid);
        Assertions.assertFalse(result);
    }
}
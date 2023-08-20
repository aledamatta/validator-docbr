package br.com.damatta;

import br.com.damatta.cnpj.TCNPJ;
import br.com.damatta.cpf.TCPF;
import br.com.damatta.ie.TIE;

public class ValidatorDocBr {
    private final TCNPJ cnpjValidator;
    private final TCPF cpfValidator;
    private final TIE ieValidator;

    public ValidatorDocBr() {
        cnpjValidator = new TCNPJ();
        cpfValidator = new TCPF();
        ieValidator = new TIE();
    }

    public boolean isValidCnpjCpf(final String cnpjCpf) {
        if (isInvalidInputCnpjCpf(cnpjCpf)) {
            return false;
        }

        if (cnpjCpf.length() != 11 && cnpjCpf.length() != 14){
            return false;
        }

        if (cnpjCpf.length() == 14){
            return cnpjValidator.isValid(cnpjCpf);
        } else {
            return cpfValidator.isValid(cnpjCpf);
        }
    }

    public boolean isValidCnpj(final String cnpj) {
        if (isInvalidInputCnpjCpf(cnpj)) {
            return false;
        }

        if (cnpj.length() != 14) {
            return false;
        }

        return cnpjValidator.isValid(cnpj);
    }

    public boolean isValidCpf(final String cpf) {
        if (isInvalidInputCnpjCpf(cpf)) {
            return false;
        }

        if (cpf.length() != 11) {
            return false;
        }

        return cpfValidator.isValid(cpf);
    }

    public boolean isValidIE(final String ie, final String uf){
        return ieValidator.isValid(ie,uf);
    }

    private boolean isInvalidInputCnpjCpf(final String texto) {
        return (texto == null || !texto.matches("\\d+"));
    }
}

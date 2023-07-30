package br.com.damatta;

import br.com.damatta.cnpj.TCNPJ;
import br.com.damatta.cpf.TCPF;

public class ValidatorDocBr {
    private final TCNPJ cnpjValidator;
    private final TCPF cpfValidator;

    public ValidatorDocBr() {
        cnpjValidator = new TCNPJ();
        cpfValidator = new TCPF();
    }

    public boolean isValidCnpjCpf(final String cnpjCpf){
        final var doc = clean(cnpjCpf);

        if (doc.length() != 11 && doc.length() != 14){
            return false;
        }

        if (doc.length() == 14){
            return isValidCnpjClean(doc);
        } else {
            return isValidCpfClean(doc);
        }
    }

    public boolean isValidCnpj(final String cnpj){
        final var doc = clean(cnpj);

        if (doc.length() != 14){
            return false;
        }

        return isValidCnpjClean(doc);
    }

    private boolean isValidCnpjClean(final String cnpj){
        return cnpjValidator.isValid(cnpj);
    }

    public boolean isValidCpf(final String cpf){
        final var doc = clean(cpf);

        if (doc.length() != 11){
            return false;
        }

        return isValidCpfClean(doc);
    }

    private boolean isValidCpfClean(final String cpf){
        return cpfValidator.isValid(cpf);
    }

    public boolean isValidIe(final String ie, final String uf){
        return false;
    }

    private String clean(final String texto){
        if (texto == null){
            return "";
        }

        return texto.replaceAll("\\D","");
    }
}

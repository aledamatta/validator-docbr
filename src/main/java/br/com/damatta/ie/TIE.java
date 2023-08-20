package br.com.damatta.ie;

import br.com.damatta.ie.validators.AC;
import br.com.damatta.ie.validators.AL;
import br.com.damatta.ie.validators.UFEnum;
import br.com.damatta.ie.validators.ValidatorIE;

public class TIE {

    public boolean isValid(final String ie, final String uf) {
        UFEnum ufEnum;
        try {
            ufEnum = UFEnum.valueOf(uf.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return false;
        }

        ValidatorIE validator = factory(ufEnum);
        return validator.isValid(ie);
    }

    private ValidatorIE factory(final UFEnum uf){
        return switch (uf){
            case AC -> new AC();
            case AL -> new AL();
            case AM -> null;
            case AP -> null;
            case BA -> null;
            case CE -> null;
            case DF -> null;
            case ES -> null;
            case GO -> null;
            case MA -> null;
            case MG -> null;
            case MS -> null;
            case MT -> null;
            case PA -> null;
            case PB -> null;
            case PE -> null;
            case PI -> null;
            case PR -> null;
            case RJ -> null;
            case RN -> null;
            case RO -> null;
            case RR -> null;
            case RS -> null;
            case SC -> null;
            case SE -> null;
            case SP -> null;
            case TO -> null;
        };
    }
}
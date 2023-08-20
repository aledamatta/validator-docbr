package br.com.damatta.ie;

import br.com.damatta.ie.validators.*;

import java.util.regex.Pattern;

public class TIE {

    public boolean isValid(final String ie, final String uf) {
        UFEnum ufEnum;
        try {
            ufEnum = UFEnum.valueOf(uf.toUpperCase());
        } catch (IllegalArgumentException ex) {
            return false;
        }
        String ieClean = filter(ie);

        ValidatorIE validator = factory(ufEnum);
        return validator.isValid(ieClean);
    }

    private String filter(final String ie){
        String result = "";
        int idx = 0;

        if ("P".equals(ie.substring(0,1))){
            result = "P";
            idx = 1;
        }
        Pattern pattern = Pattern.compile("\\D+");
        result += pattern.matcher(ie.substring(idx)).replaceAll("");

        return result;
    }

    private ValidatorIE factory(final UFEnum uf){
        return switch (uf){
            case AC -> new AC();
            case AL -> new AL();
            case AM -> new AM();
            case AP -> new AP();
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
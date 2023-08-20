package br.com.damatta.ie.validators;

public class AP implements ValidatorIE {
    private final int[] peso = {9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(String ie) {
        if (!Rules.isCorrectSize(ie, 9)) {
            return false;
        }
        if (!Rules.isStartWith(ie, "03")){
            return false;
        }
        final String base = Rules.getBaseValue(ie, 8);

        int d;
        int p;
        if (Rules.between(base, 3000001, 3017000)) {
            p = 5;
            d = 0;
        } else if (Rules.between(base, 3017001, 3019022)) {
            p = 9;
            d = 1;
        } else {
            p = 0;
            d = 0;
        }

        final int total = p + Rules.calculateTotal(base, peso);
        final int rest = Rules.calculateMod(total, 11);

        final int dv = switch (rest){
            case 1 -> 0;
            case 0 -> d;
            default -> (11 -rest);
        };

        return (ie.equals(base + dv ));
    }
}

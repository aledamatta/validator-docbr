package br.com.damatta.ie.validators;

public class AC implements ValidatorIE{

    private final int[] peso = {5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(String ie) {
        if (!Rules.isCorrectSize(ie, 13)) {
            return false;
        }
        if (!Rules.isStartWith(ie, "01")){
            return false;
        }
        final String base = Rules.getBaseValue(ie, 11);

        int total = Rules.calculateTotal(base, peso);
        final int dv1 = Rules.getDigit(total, 11);

        total = Rules.calculateTotal(base+dv1, peso);
        final int dv2 = Rules.getDigit(total, 11);

        return (ie.equals(base + dv1 + dv2));
    }
}

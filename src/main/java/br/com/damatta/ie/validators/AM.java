package br.com.damatta.ie.validators;

public class AM implements ValidatorIE {
    private final int[] peso = {9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(String ie) {
        if (!Rules.isCorrectSize(ie, 9)) {
            return false;
        }
        final String base = Rules.getBaseValue(ie, 8);

        final int total = Rules.calculateTotal(base, peso);
        if (total == 0){
            return false;
        }
        final int dv = Rules.getDigit(total, 11);
        return (ie.equals(base + dv));
    }
}

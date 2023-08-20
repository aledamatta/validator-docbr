package br.com.damatta.ie.validators;

public class AL implements ValidatorIE{

    private final int[] peso = {9, 8, 7, 6, 5, 4, 3, 2};

    @Override
    public boolean isValid(String ie) {
        if (!Rules.isCorrectSize(ie, 9)) {
            return false;
        }
        if (!Rules.isStartWith(ie, "24")){
            return false;
        }
        final String base = Rules.getBaseValue(ie, 8);

        final int total = Rules.calculateTotal(base, peso);
        final int dv1 = getDv(total);

        return (ie.equals(base + dv1 ));
    }

    private int getDv(int total) {
        final int calc = total * 10;
        final int rest = calc - ((calc / 11) * 11);
        return (rest == 10 ? 0 : rest);
    }
}

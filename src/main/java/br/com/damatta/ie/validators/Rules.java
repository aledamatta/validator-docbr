package br.com.damatta.ie.validators;

public class Rules {

    public static boolean isCorrectSize(final String ie, final int size){
        return ie.length() == size;
    }

    public static boolean isStartWith(final String ie, final String value){
        return ie.startsWith(value);
    }

    public static String getBaseValue(final String ie, final int size){
        return ie.substring(0, size);
    }

    public static int calculateTotal(final String str, final int[] weight) {
        int soma = 0;
        for (int i=str.length()-1; i >= 0; i-- ) {
            final int dv = Integer.parseInt(str.substring(i,i+1));
            soma += dv*weight[weight.length-str.length()+i];
        }
        return soma;
    }

    public static int getDigit(final int total, final int divisor){
        final int mod = calculateMod(total, divisor);
        return (mod >= 2 ? ( divisor - mod) : mod);
    }

    public static int calculateMod(final int total, final int divisor) {
        return (total % divisor);
    }

    public static boolean between(final String base, final int inf, final int sup ){
        var value = Integer.parseInt(base);
        return (value >= inf && value <= sup);
    }

}

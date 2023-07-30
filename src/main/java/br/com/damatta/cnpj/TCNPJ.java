package br.com.damatta.cnpj;

public class TCNPJ {
    private final int[] peso = {6, 5, 4, 3, 2, 9, 8, 7, 6, 5, 4, 3, 2};

    public boolean isValid(final String cnpj){
        int dv1 = calcularDigito(cnpj.substring(0,12));
        int dv2 = calcularDigito(cnpj.substring(0,12) + dv1);
        return cnpj.equals(cnpj.substring(0,12) + dv1 + dv2);
    }

    private int calcularDigito(final String str) {
        int soma = 0;
        for (int i=str.length()-1; i >= 0; i-- ) {
            final int dv = Integer.parseInt(str.substring(i,i+1));
            soma += dv*peso[peso.length-str.length()+i];
        }
        soma = 11 - soma % 11;
        return soma > 9 ? 0 : soma;
    }
}

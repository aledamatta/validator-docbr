package br.com.damatta.cpf;

public class TCPF {
    private final int[] peso = {11, 10, 9, 8, 7, 6, 5, 4, 3, 2};

    public boolean isValid(final String cpf){
        int dv1 = calcularDigito(cpf.substring(0,9));
        int dv2 = calcularDigito(cpf.substring(0,9) + dv1);
        return cpf.equals(cpf.substring(0,9) + dv1 + dv2);
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

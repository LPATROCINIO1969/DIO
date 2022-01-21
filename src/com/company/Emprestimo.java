package com.company;

public class Emprestimo {

    public static double getTaxa(int numParcelas){
        switch (numParcelas){
            case 1: return 0;
            case 2: return 0.15;
            case 3: return 0.20;
            case 4: return 0.25;
            case 5: return 0.5;
            default: return 0.6;
        }
    }

    public static void calcular(double valor, int numParcela){
        double valorFinal=0;
        double fator;
        double taxa;

        taxa = getTaxa(numParcela);
        fator = Math.pow(1+taxa,numParcela);
        valorFinal = valor*fator;
        System.out.println("----------------------------------------");
        System.out.println("Empréstimo");
        System.out.printf(">> Valor emprestado: %6.2f\n", (float)valor);
        System.out.printf(">> Número de parcelas: %6.2f\n", (float)numParcela);
        System.out.println(">> Taxa: " + taxa);
        System.out.printf(">> Valor a ser devolvido: %6.2f\n", (float)valorFinal);
        System.out.println("----------------------------------------");
    }

}

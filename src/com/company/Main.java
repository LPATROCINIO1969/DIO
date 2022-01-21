package com.company;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class Main {

    public static void main(String[] args) {

        // Imprime a saudação para o horário atual
        imprimeSaudacao();


        // teste das 4 operações
        float num1 = (float)20.0;
        float num2 = (float)10.0;

        System.out.printf("Adição: %3.2f + %3.2f = %3.2f\n", num1, num2, Calculadora.somar(num1,num2));
        System.out.printf("Subtração: %3.2f - %3.2f = %3.2f\n", num1, num2, Calculadora.subtrair(num1,num2));
        System.out.printf("Multiplicação: %3.2f * %3.2f = %3.2f\n", num1, num2, Calculadora.multiplicar(num1,num2));
        System.out.printf("Dividisão: %3.2f / %3.2f = %3.2f\n", num1, num2, Calculadora.dividir(num1,num2));

        // Imprime o valor final do empréstimo
        Emprestimo.calcular(1000,1);
        Emprestimo.calcular(1000,2);
        Emprestimo.calcular(1000,3);
        Emprestimo.calcular(1000,4);
        Emprestimo.calcular(1000,10);

    }



    // Imprime uma saudação de acordo com a hora do dia
    private static void imprimeSaudacao() {
        LocalTime horario = LocalTime.now();
        int hora = horario.getHour();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("HH:mm:ss");
        String horarioFormatado = horario.format(formato);
        System.out.println("Horário: " + horarioFormatado);
        if (hora < 12) System.out.println("Bom dia!");
        else if (hora >=18) System.out.println("Boa noite!");
        else System.out.println("Boa tarde");

    }

}

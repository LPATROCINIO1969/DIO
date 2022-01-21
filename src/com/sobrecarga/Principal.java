package com.sobrecarga;

public class Principal {
    public static void main(String[] args) {
        // executa cálculo de área de quadrilateros
        double lado = 10.0;
        double lado1 = 10.0;
        double lado2 = 3.5;
        double altura = 5;
        double area;

        // área do quadrado
        area = Quadrilatero.area(lado);
        System.out.printf("Quadrado de lado = %3.3f - Área =  %4.3f\n",lado,area);
        area = Quadrilatero.area(lado1,lado2);
        System.out.printf("Retângulo - base = %3.3f - altura = %3.3f - Área =  %4.3f\n",lado1,lado2,area);
        area = Quadrilatero.area(lado1,lado2,altura);
        System.out.printf("Trapézio - base1 = %3.3f - base 2 = %3.3f - altura = %3.3f - Área =  %4.3f\n",lado1,lado2,altura,area);



    }
}

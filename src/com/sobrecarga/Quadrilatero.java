package com.sobrecarga;

import java.text.NumberFormat;

public class Quadrilatero {
    public static double area(double lado){
        double area;
        area = lado*lado;
        return area;


    }

    public static double area(double lado1, double lado2){
        double area;
        area = lado1*lado2;
        return area;


    }

    public static double area(double base1, double base2, double altura){
        double area;
        area = (base1 + base2)*altura/2.0;
        return area;


    }

}

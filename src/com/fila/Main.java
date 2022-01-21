package com.fila;

public class Main {

    public static void main(String[] args) {

        String valorAtual;

        // Criando o objeto Fila
        Fila<String> minhaFila = new Fila<>();

        // populando a fila
        minhaFila.enqueue("Primeiro");
        minhaFila.enqueue("Segundo");
        minhaFila.enqueue("Terceiro");
        minhaFila.enqueue("Quarto");

        // Imprime a fila
        System.out.println(minhaFila);

        // Desempilha um termo da fila
        valorAtual = minhaFila.dequeue();
        System.out.println("Primeiro da fila atual: " + valorAtual);

        // Imprime a fila
        System.out.println(minhaFila);

        // Desempilha um termo da fila
        valorAtual =minhaFila.dequeue();
        System.out.println("Primeiro da fila atual: " + valorAtual.toString());

        // Imprime a fila
        System.out.println(minhaFila);

    }
}

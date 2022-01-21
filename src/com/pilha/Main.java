package com.pilha;

public class Main {
    public static void main(String[] args) {

        No noExtraido;

        // criando uma pilha de inteiros
        Pilha myPìlha = new Pilha();

        // Preenchendo a pilha com nós contendo inteiros de 1 a 10.
        for (int cont=1; cont <= 10; cont++)  myPìlha.push(new No(cont));

        // Imprime o conteúdo atual da pilha
        System.out.println(myPìlha);

        // Efetua um pop na pilha.
        noExtraido = myPìlha.pop();
        System.out.println(noExtraido);

        // Imprime o conteúdo atual da pilha
        System.out.println(myPìlha);

    }
}

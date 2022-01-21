package com.listacircular;

import com.listaduplamenteencadeada.ListaDuplamenteEncadeada;

public class Main {
    public static void main(String[] args) {
        ListaCircular <String> minhaLista = new ListaCircular<>();

        // Adiciona algumas strings a lista
        minhaLista.add("teste1");
        minhaLista.add("teste2");
        minhaLista.add("teste3");
        minhaLista.add("teste4");
        minhaLista.add("teste5");
        minhaLista.add("teste6");

        // Imprime o primeiro termo da lista
        System.out.println("Imprime primeiro termo da lista");
        System.out.println(minhaLista.get(2));

        // Imprime a lista
        System.out.println("Imprime a lista inteira");
        System.out.println(minhaLista);

        // Remove um termo da lista
        System.out.println("Remove o 3o. termo da lista");
        minhaLista.remove(3);

        // Imprime novamente a lista
        System.out.println("Imprime a lista inteira");
        System.out.println(minhaLista);


    }
}

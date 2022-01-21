package com.arvore;

import com.arvore.model.Obj;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria<Obj> minhaArvore = new ArvoreBinaria<>();

        // inserir nós na árvore
        minhaArvore.inserir(new Obj(13));
        minhaArvore.inserir(new Obj(10));
        minhaArvore.inserir(new Obj(25));
        minhaArvore.inserir(new Obj(2));
        minhaArvore.inserir(new Obj(12));
        minhaArvore.inserir(new Obj(20));
        minhaArvore.inserir(new Obj(31));
        minhaArvore.inserir(new Obj(29));

        // exibir a ordem dos nós na árvore
        minhaArvore.exibirInOrder();
        minhaArvore.exibirPreOrder();
        minhaArvore.exibirPosOrder();

        // retirando um valor da árvore
        // ***> retirando nó raiz
//        System.out.println("\n\nRetirando o nó raiz da árvore");
//        minhaArvore.remover(new Obj(13));

//        System.out.println("\n\nRetirando um nó folha da árvore");
//        minhaArvore.remover(new Obj(2));

        System.out.println("\n\nRetirando um nó INTERMEDIARIO árvore");
        minhaArvore.remover(new Obj(10));


        // exibir a ordem dos nós na árvore
        minhaArvore.exibirPreOrder();


    }
}

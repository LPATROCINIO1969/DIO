package com.listacircular;

import com.listaencadeada.No;

public class ListaCircular<T> {
    private No<T> cabeca;
    private No<T> cauda;
    private int tamanhoLista;

    

    public ListaCircular() {
        this.cabeca = null;
        this.cauda = null;
        this.tamanhoLista=0;
    }

    public boolean isEmpty(){
        return (this.tamanhoLista==0);
    }

    public int size(){
         return this.tamanhoLista;
    }

    private No<T> getNo(int index){
        No<T> noAuxiliar = cauda;

        if (this.isEmpty()) throw new IndexOutOfBoundsException("Lista Vazia");

        if (index == 0) return noAuxiliar;

        for (int i = 0; i < index; i++){
            noAuxiliar = noAuxiliar.getproximoNo();
        }
        return noAuxiliar;
    }


    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    private void validaIndice(int index){
        int ultimoIndice = size() -1;
        if (index > ultimoIndice){
            throw new IndexOutOfBoundsException("Não existe conteúdo no indice " + index + " desta lista! Esta lista só vai até o indice " + ultimoIndice + ".");
        }
    }

    public void add(T conteudo){
        No<T> novoNo = new No<>(conteudo);

        if (this.isEmpty()){
            this.cabeca = novoNo;
            this.cauda = novoNo;
            this.cabeca.setproximoNo(this.cauda);
        } else{
            novoNo.setproximoNo(this.cauda);
            this.cabeca.setproximoNo(novoNo);
            this.cauda = novoNo;
        }
        this.tamanhoLista++;

    }


    public void remove(int index){
        No<T> noAnterior;
        No<T> noRemovido;
        No<T> noPosterior;

        if (index>=this.tamanhoLista) throw new IndexOutOfBoundsException("Indice maior que tamanho da lista!");

        if (index == 0) {
            noRemovido = this.cauda;
            this.cauda = noRemovido.getproximoNo();
            this.cabeca.setproximoNo(this.cauda);
        } else if (index == 1){
            this.cauda.setproximoNo(this.cauda.getproximoNo().getproximoNo());
        } else {
            noAnterior = getNo(index-1);
            noRemovido = noAnterior.getproximoNo();
            noPosterior = noRemovido.getproximoNo();
            noAnterior.setproximoNo(noPosterior);
        }

        this.tamanhoLista--;
    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No<T> noAuxiliar = this.cauda;
        for (int idx = 0; idx <= size() - 1; idx++){
            stringRetorno += "No{" + noAuxiliar.getConteudo() + "} -->\n";
            noAuxiliar = noAuxiliar.getproximoNo();
        }
        if(!isEmpty()) stringRetorno += "(retorna ao inicio)";
        return stringRetorno;
    }
}

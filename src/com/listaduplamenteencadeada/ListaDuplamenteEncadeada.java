package com.listaduplamenteencadeada;

public class ListaDuplamenteEncadeada<T> {

    private NoDuplo<T> primeiroNo;
    private NoDuplo<T> ultimoNo;
    private int tamanhoLista;

    public ListaDuplamenteEncadeada() {
        this.primeiroNo = null;
        this.ultimoNo = null;
        this.tamanhoLista = 0;
    }

    public ListaDuplamenteEncadeada(NoDuplo<T> primeiroNo) {
        this.primeiroNo = primeiroNo;
        this.ultimoNo = primeiroNo;
        this.tamanhoLista = 1;
    }

    public int size(){
        return tamanhoLista;
    }

    private NoDuplo<T> getNo(int index){
        NoDuplo<T> noAuxiliar = primeiroNo;
        for (int i = 0; (i<index) && (noAuxiliar!=null);i++){
            noAuxiliar = noAuxiliar.getProximoNo();
        }

        return noAuxiliar;
    }

    public T get(int index){
        return this.getNo(index).getConteudo();
    }

    public void add(T elemento){
        NoDuplo<T> noAuxiliar = new NoDuplo<>(elemento);
        noAuxiliar.setAnteriorNo(ultimoNo);

        if (primeiroNo == null){
            primeiroNo = noAuxiliar;
            ultimoNo = noAuxiliar;
        } else {
            this.ultimoNo.setProximoNo(noAuxiliar);
            this.ultimoNo = noAuxiliar;
        }
        this.tamanhoLista++;


    }

    public void add (T elemento, int index){
        NoDuplo<T> novoNo = new NoDuplo<>(elemento);
        NoDuplo<T> noAuxiliar = getNo(index);
        novoNo.setAnteriorNo(noAuxiliar.getAnteriorNo());

        if (novoNo.getAnteriorNo() == null) {
            primeiroNo = novoNo;
        }  else {
            novoNo.getAnteriorNo().setProximoNo(novoNo);
        }

        novoNo.setProximoNo(noAuxiliar);
        if (novoNo.getProximoNo() == null){
            ultimoNo = novoNo;
        } else{
            noAuxiliar.setAnteriorNo(novoNo);
        }

        this.tamanhoLista++;

    }


    public void remove(int index){
        NoDuplo<T> noAuxiliar = getNo(index);
        NoDuplo<T> noPrevio;
        NoDuplo<T> noPosterior;

        if (noAuxiliar != null) {
            noPrevio = noAuxiliar.getAnteriorNo();
            noPosterior = noAuxiliar.getProximoNo();

            if (noPrevio != null){
               noPrevio.setProximoNo(noPosterior);
               if (noPosterior != null){
                   noPosterior.setAnteriorNo(noPrevio);
               } else {
                   ultimoNo = noPrevio;
               }

            } else {
                primeiroNo = noPosterior;
                if (noPosterior != null){
                    noPosterior.setAnteriorNo(null);
                } else {
                    ultimoNo = null;
                }
            }

            tamanhoLista--;
        }

    }


    @Override
    public String toString() {
        String stringRetorno = "";

        NoDuplo<T> noAuxiliar = primeiroNo;
        for(int i=0; i < size(); i++){
            stringRetorno += "No{" + noAuxiliar.getConteudo() + "} -->\n";;
            noAuxiliar = noAuxiliar.getProximoNo();
        }
        stringRetorno += "null";

        return stringRetorno;
    }
}

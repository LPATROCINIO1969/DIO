
package com.fila;

public class Fila<T> {
    private No<T> noInicial;
    private No<T> ultimoNo;

    public Fila() {
        this.noInicial = null;
        this.ultimoNo = this. noInicial;
    }

    public Fila(T objeto) {
        No<T> noAuxiliar = new No<T>(objeto);
        this.noInicial = noAuxiliar;
        this.ultimoNo = this.noInicial;
    }

    public T first(){
        return noInicial.getObject();
    }


    public void enqueue(T object){
        No<T> novoNo = new No<>(object);
        if (isEmpty()) {
            this.noInicial = novoNo;
            this.ultimoNo = novoNo;
        } else{
            this.ultimoNo.setRefNo(novoNo);
            this.ultimoNo = novoNo;
        }

    }

    public T dequeue(){
        No<T> noRetirado = null;
        if (!isEmpty()){
            noRetirado = this.noInicial;
            if (noRetirado.equals(ultimoNo)) ultimoNo = null;
            this.noInicial = this.noInicial.getRefNo();
        }
        return noRetirado.getObject();
    }

    public boolean isEmpty(){
        return(this.noInicial == null);
    }

    @Override
    public String toString() {
        String stringRetorno="";
        No noAuxiliar = this.noInicial;

        while (noAuxiliar != null) {
            stringRetorno += "[No {object = " + noAuxiliar.getObject() + "}] --->";
            noAuxiliar = noAuxiliar.getRefNo();
        }

        stringRetorno += "null";

        return stringRetorno;
//        return "Fila{" +
//                "noInicial=" + noInicial +
//                ", ultimoNo=" + ultimoNo +
//                '}';
    }
}

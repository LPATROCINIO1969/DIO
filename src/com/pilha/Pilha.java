package com.pilha;

public class Pilha {
    private No refNoEntradaPilha;

    public Pilha() {
        this.refNoEntradaPilha = null;
    }

    public No top(){
        return refNoEntradaPilha;
    }

    public void push(No novoNo){
        novoNo.setRefNo(refNoEntradaPilha);
        refNoEntradaPilha = novoNo;
    }

    public No pop(){
        No noAuxiliar = refNoEntradaPilha;
        if (!isEmpty()) {
            refNoEntradaPilha = refNoEntradaPilha.getRefNo();
        }
        return noAuxiliar;

    }

    public boolean isEmpty(){
        if (refNoEntradaPilha == null) return true;
        return false;
    }

    @Override
    public String toString() {
        String stringRetorno = "---------------------------------\n";
        stringRetorno += "            Pilha\n";
        stringRetorno += "---------------------------------\n";

        No noAuxiliar = refNoEntradaPilha;
        while (noAuxiliar != null){
            stringRetorno += "[No {Dado = " + noAuxiliar.getDado() +" }]\n";
            noAuxiliar = noAuxiliar.getRefNo();
        }
        stringRetorno += "=================================\n";
        return stringRetorno;
//        return "Pilha{" +
//                "refNoEntradaPilha=" + refNoEntradaPilha +
//                '}';
    }
}

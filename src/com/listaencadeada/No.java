package com.listaencadeada;

public class No <T>{
    private T conteudo;
    private No proximoNo;

    public No() {
        this.proximoNo = null;
    }

    public No(T conteudo) {
        this();
        this.conteudo = conteudo;
    }

    public No(T conteudo, No proximoNo) {
        this.conteudo = conteudo;
        this.proximoNo = proximoNo;
    }

    public T getConteudo() {
        return conteudo;
    }

    public void setConteudo(T conteudo) {
        this.conteudo = conteudo;
    }

    public No getproximoNo() {
        return proximoNo;
    }

    public void setproximoNo(No proximoNo) {
        this.proximoNo = proximoNo;
    }


    @Override
    public String toString() {
        return "No{" +
                "conteudo=" + conteudo +
                '}';
    }

    public String toStringEncadeado() {
        String stringReturn = "No{" +
                "conteudo=" + conteudo +
                '}';
        
        if (proximoNo != null) {
            stringReturn += " --> " + proximoNo.toString();
        }
        else {
            stringReturn += " --> null";
        }
        
        return stringReturn;
    }
    
}


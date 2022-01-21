package com.listaencadeada;

public class ListaEncadeada<T> {
    No<T> referenciaEntrada;

    public ListaEncadeada() {
        this.referenciaEntrada = null;
    }

    public boolean isEmpty(){
        return (referenciaEntrada==null);
    }

    public int size(){
        int cont = 0;
        No<T> noAtual = referenciaEntrada;

        while(noAtual != null){
            cont++;
            noAtual = noAtual.getproximoNo();
        }

        return cont;
    }


    private No<T> getNo(int index){
        No<T> noAuxiliar = referenciaEntrada;
        No<T> noRetorno = null;

        validaIndice(index);

        for (int i = 0; i <= index; i++){
            noRetorno = noAuxiliar;
            noAuxiliar = noAuxiliar.getproximoNo();
        }
        return noRetorno;
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
        No refNo = referenciaEntrada;

        // Verifica se a lista está vazia
        if (this.isEmpty()){
            referenciaEntrada = novoNo;
        }
        else {
            // Adiciona o nó no final da lista
            while (refNo.getproximoNo() != null) {
                refNo = refNo.getproximoNo();
            }
            refNo.setproximoNo(novoNo);
        }

    }


    public T remove(int index){
        No<T> noAnterior;
        No<T> noRemovido;
        No<T> noPosterior;

        if (index == 0) {
            noRemovido = referenciaEntrada;
            referenciaEntrada = noRemovido.getproximoNo();
        } else if (index == this.size()-1){
            noAnterior = this.getNo(index-1);
            noRemovido = noAnterior.getproximoNo();
            noAnterior.setproximoNo(null);
        } else {
            noAnterior = getNo(index-1);
            noRemovido = noAnterior.getproximoNo();
            noPosterior = noRemovido.getproximoNo();
            noAnterior.setproximoNo(noPosterior);
        }

        return noRemovido.getConteudo();

    }

    @Override
    public String toString() {
        String stringRetorno = "";
        No<T> noAuxiliar = referenciaEntrada;
        for (int idx = 0; idx <= size() - 1; idx++){
            stringRetorno += "No{" + noAuxiliar.getConteudo() + "} -->\n";
            noAuxiliar = noAuxiliar.getproximoNo();
        }
        stringRetorno += "null";
        return stringRetorno;
    }
}

package com.arvore;

public class ArvoreBinaria<T extends Comparable<T>> {
    private BinNo<T> raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }


    public void inserir (T conteudo){
        BinNo<T> noNovo = new BinNo<T>(conteudo);
        this.raiz = inserir(raiz, noNovo);
    }

    private BinNo<T> inserir(BinNo<T>  noAtual, BinNo<T> noNovo){
        if (noAtual == null){
            noAtual = noNovo;
        } else
            if(noNovo.getConteudo().compareTo(noAtual.getConteudo())==-1){
                noAtual.setNoEsq(inserir(noAtual.getNoEsq(),noNovo));

            } else {
                noAtual.setNoDir(inserir(noAtual.getNoDir(), noNovo));
            }
        return noAtual;
    }


    public void exibirInOrder(){
        System.out.println("\nExibindo InOrdem");
        exibirInOrder(this.raiz);
    }

    private void exibirInOrder(BinNo<T> noAtual){
        if (noAtual!=null) {
                exibirInOrder(noAtual.getNoEsq());
                System.out.println(noAtual);
                exibirInOrder(noAtual.getNoDir());
        }

    }

    public void exibirPreOrder(){
        System.out.println("\nExibindo PreOrdem");
        exibirPreOrder(this.raiz);
    }

    private void exibirPreOrder(BinNo<T> noAtual){
        if (noAtual!=null) {
            System.out.println(noAtual);
            exibirPreOrder(noAtual.getNoEsq());
            exibirPreOrder(noAtual.getNoDir());
        }

    }

    public void exibirPosOrder(){
        System.out.println("\nExibindo PosOrdem");
        exibirPreOrder(this.raiz);
    }

    private void exibirPosOrder(BinNo<T> noAtual){
        if (noAtual!=null) {
            exibirPosOrder(noAtual.getNoEsq());
            exibirPosOrder(noAtual.getNoDir());
            System.out.println(noAtual);
        }

    }

    public void remover(T conteudo){
        BinNo<T> noAtual;
        BinNo<T> noPai = null;
        BinNo<T> noFilho = null;
        BinNo<T> noTemp = null;
        BinNo<T> noPaiNoRemovido = null;
        try{
            noAtual = this.raiz;
            while ((noAtual != null) && !(noAtual.getConteudo().equals(conteudo))){
                noPaiNoRemovido = noAtual;
                if (conteudo.compareTo(noAtual.getConteudo())<0){
                    noAtual = noAtual.getNoEsq();
                } else {
                    noAtual =noAtual.getNoDir();
                }
            }

            // Indica que o conteúdo não foi encontrado em nenhum nó da arvore
            if (noAtual == null) {
                System.out.println("Conteúdo não encontrado");
                return;
            }

            // efetua a remoção do nó raiz e substitui pelo nó de maior valor da subarvore esquerda.
            if (noPaiNoRemovido == null){
                if (noAtual.getNoDir()== null){
                    this.raiz = noAtual.getNoEsq();
                } else if (noAtual.getNoEsq() == null){
                    this.raiz = noAtual.getNoDir();
                } else {
                    noTemp = noAtual;
                    noFilho = noTemp.getNoEsq();
                    while(noFilho != null){
                        noPai = noTemp;
                        noTemp = noFilho;
                        noFilho = noTemp.getNoDir();
                    }
                    noTemp.setNoDir(this.raiz.getNoDir());
                    noPai.setNoDir(noTemp.getNoEsq());
                    noTemp.setNoEsq(this.raiz.getNoEsq());
                    this.raiz = noTemp;
                }
            } // A partir daqui avaliamos nós que não são raiz.
            else if (noAtual.getNoDir() == null){   // verificamos se o nó que vai ser excluido possui ramo a direita
                if (noPaiNoRemovido.getNoDir() == noAtual) {
                    noPaiNoRemovido.setNoDir(noAtual.getNoEsq());
                } else {
                    noPaiNoRemovido.setNoEsq(noAtual.getNoEsq());
                }

            } else if (noAtual.getNoEsq() == null){  // verificamos se o nó que vai ser excluido possui ramo a esquerda
                if (noPaiNoRemovido.getNoDir() == noAtual) {
                    noPaiNoRemovido.setNoDir(noAtual.getNoDir());
                } else {
                    noPaiNoRemovido.setNoEsq(noAtual.getNoDir());
                }

            } else {   // Procedemos a exclusão de um nó que não é raiz e possui tanto ramo a esq. quanto a dir.
                noTemp = noAtual;
                noFilho = noTemp.getNoEsq();
                while(noFilho != null){
                    noPai = noTemp;
                    noTemp = noFilho;
                    noFilho = noTemp.getNoDir();
                }
                if (noPai!=noAtual) {
                    noPai.setNoDir(noTemp.getNoEsq());
                    noTemp.setNoEsq(noAtual.getNoEsq());
                }
                noTemp.setNoDir(noAtual.getNoDir());

                if (noPaiNoRemovido.getNoDir() == noAtual){
                    noPaiNoRemovido.setNoDir(noTemp);
                } else {
                    noPaiNoRemovido.setNoEsq(noTemp);
                }
            }

        }catch (NullPointerException erro){
            System.out.println("Conteúdo não encontrado");
        }
    }


}

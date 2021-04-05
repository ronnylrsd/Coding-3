package com.classes.classe.Unikut;
public class LSESemRepetidos<T extends Comparable<T>> {
    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;   

    public LSENode<T> getPrim() {
        return prim;
    }

    private void setPrim(LSENode<T> prim) {
        this.prim = prim;
    }

    public LSENode<T> getUlt() {
        return ult;
    }

    private void setUlt(LSENode<T> ult) {
        this.ult = ult;
    }

    public int getQtd() {
        return qtd;
    }

    private void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public int inserirValorFim (T valor){
        LSENode<T> novo = new LSENode(valor);//guarda o valor do nó enquanto ele não é inserido na lista
        if(qtd == 0){//lista vazia
            prim = novo;
            ult = novo;
            //primeiro e último recebem o mesmo valor pq só tem um nó
            qtd++;
            return 1;
        }
        else{
            if(buscarSimples(valor) == null){
                ult.setProx(novo);
                ult = novo;
                //a cada novo nó é encadeado depois do último
                qtd++;
                return 2;
            }
            else{
                return -1;
            }
        }
    }
    
    
    private LSENode<T> buscarSimples (T valor) { // metodo de busca porem que retorna o objeto ao invez de um boleano
        LSENode<T> aux;                 // privada pois só vai ser usada pelos procedimentos    
        if (qtd == 0) { // lista vazia
            return null;
        }
        else {
            aux = prim;
            while (aux != null) {
                if (aux.getInfo().compareTo(valor) == 0) {
                    return aux;
                }
                else {
                    aux = aux.getProx();
                }
            }
            return null;
        }                  
    }
    
    public T buscarObjeto (T valor) { // busca sequancial simples  retornando endereco do nó 
        LSENode<T> pos;        
        pos = buscarSimples(valor); // usando busca simples para retornar a referencia ao no
        if (pos == null) {
            return null;
        }
        else {
            return pos.getInfo(); //retorna o objeto
        }
    }
   
    public T exibirValores(){
        if(qtd == 0){
            return null;
        }
        else{
            LSENode<T> aux;
            //for(inicialização da variável de controle;condição de repetição;variação da variável)
            for(aux = prim;aux != null;aux = aux.getProx()){
                return aux.getInfo();
            }
        }
        return null;
    }
    
}
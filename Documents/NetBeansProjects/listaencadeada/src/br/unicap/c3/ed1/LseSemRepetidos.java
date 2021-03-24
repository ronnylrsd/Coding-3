
package br.unicap.c3.ed1;

public class LseSemRepetidos<T extends Comparable<T>> {
    private LSENode<T> prim;
    private LSENode<T> ult;
    private int qtd;   
    

    public void inserirValorInicio(T valor){
        
     LSENode<T> novo;
     boolean achou;
     novo = new LSENode(valor);
     
     if(qtd==0){
      prim=novo;
      ult =novo;
      qtd++;
     }
     else{
         achou=this.buscar(valor);
         if(achou == true){
             System.out.println("valor ja inserido!");
         }else{
             novo.setProx(prim);
             prim=novo;
             System.out.println("insercao feita");
         }
         
     }
        
        
        
    }
    public void inserirValorFinal (T valor) {
        LSENode<T> novo;
        boolean achou;
        novo = new LSENode (valor);
        if (qtd == 0) { // lista está vazia
            prim = novo;
            ult = novo;
            qtd++;
        }
        else { // lista não está vazia
            achou = this.buscar(valor);
            if (achou == true) { // achou!
                System.out.println("Valor repetido! Inserção não efetuada!");
            }
            else {  // não achou!!!
                ult.setProx(novo);
                ult = novo;
                qtd++;
                System.out.println("Inserção efetuada!");
            }
        }
        System.out.println("Inserção efetuada com sucesso!");
    }  
    
    
    public void remover (T valor){
     LSENode<T> aux, anterior = null; 
     boolean busca;
     
     if (qtd==0){ // vazio
         System.out.println("Operacao nao pode ser feita pois a lista está vazia");
     
     }else if(qtd==1){ // 1 item na lista 
         
       busca = buscar(valor);
       
       if(busca==true){
        prim=null;
        ult=null;
        qtd --;
       }else{
           
          System.out.println("Valor nao encontrado portanto a remocao nao foi feita");
       }
         
    
     
     }else if(prim.getInfo().compareTo(valor)==0){ // lista qtd>1 && primeiro == remocao
         
         prim = prim.getProx();
            qtd--;
            System.out.println("Remoção efetuada!");
         
         
     }else{ // caso geral
       aux=prim;
         
           while(aux!=null){
             
            if(aux.getInfo().compareTo(valor)==0)  {
               
               anterior.setProx(aux.getProx());  
                   qtd--; 
                System.out.println("Remocao efetuada");
                return;
           }else{
               
               anterior=aux;
               aux=aux.getProx();
               
           }
                     
             
         }
         
          }
     
     
        
        
        
    }
    
    public boolean ehIgual(LseSemRepetidos<T> valor){
        LSENode<T> origi ,segund;
        origi=this.prim; // armazenar o valor do nó
        segund=valor.prim; // armzenar o valor do nó externo
        
         if(this.qtd!=valor.qtd ){ // comparacao de qtd fora do while para evitar contagem desnecessaria
            
            return false; // retorna falso se o qtd for diferente
         
         }
       
         while(origi.getProx()!=null || segund.getProx()!=null){ // // condicao de parada do while quando o get prox for null
            
        
          if(origi.getInfo().compareTo(segund.getInfo())!=0){  // comparando 2 nós
        
            return false;
            
            
          }else if(origi.getProx()== null && segund.getProx()!=null
            ||  origi.getProx()!= null && segund.getProx()==null    ){ // se a lista terminar e a outra nao 
              
              
              return false;
                    
                    
                      
        }else{  // get prox para verifcar os outros nós
          origi.getProx();
          segund.getProx();
            
        }
        
        }
        return true; // se nao caiu em nenhum dos returns , retorna true;
        
        
    }
    
    
    
    
    public void removerPrimeiro () {        
        if (qtd == 0) {
            System.out.println("Lista vazia!");
        }
        else if (qtd == 1) {
            prim = null; //objeto
            ult = null; // objeto
            qtd = 0; // qtd
            System.out.println("Remoção efetuada!");
        }
        else {
            prim = prim.getProx();
            qtd--;
            System.out.println("Remoção efetuada!");
        }
    }
    
    public void removerUltimo () { 
        LSENode<T> aux;
        if (qtd == 0) {
            System.out.println("Lista vazia!");
        }
        else if (qtd == 1) {
            prim = null;
            ult = null;
            qtd = 0;
            System.out.println("Remoção efetuada!");
        }
        else {
            aux = prim;  
            while (aux.getProx() != ult) {
                aux = aux.getProx();
            }
            aux.setProx(null);
            ult = aux;
            qtd--;
            System.out.println("Remoção efetuada!");
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
    
    public boolean buscar (T valor) { // Busca sequencial simples para nao inserir repetidos 
                                      // apenas retorna um boleano , true ou false 
        LSENode<T> aux;
        if (qtd == 0) { // lista vazia
            return false;
        }
        else {
            aux = prim;
            while (aux != null) {
                if (aux.getInfo().compareTo(valor) == 0) {
                    return true;
                }
                else {
                    aux = aux.getProx();
                }
            }
            return false;
        }        
    }
   
    public void exibirLista () {
        LSENode<T> aux;
        if (qtd == 0) {
            System.out.println("Lista vazia!!");
        }
        else {
            aux = prim;
            while (aux != null) {
                System.out.println(aux.getInfo());
                aux = aux.getProx();
            }            
        }
    }
    
    
  
    
}

package br.unicap.c3.ed1;


public class LSE <T> {
   private LSENode<T> prim;
   private LSENode<T> ult;
   private int qtd;
   
   public void inserirValor(T valor){
       
    LSENode<T> novo;
    novo = new LSENode (valor);
    
    if(qtd == 0){
        prim = novo;
        ult = novo;
        qtd++;
    }
    else{
        
     ult.setProx(novo);   
     ult=novo;
     qtd++;
        
    }  
    System.out.println("inseracão realizada com sucesso");
   }
   public void inserirValorInicio(T valor){
       
    LSENode<T> novo;
    novo = new LSENode (valor);
    
    if(qtd == 0){
        prim = novo;
        ult = novo;
        qtd++;
    }
    else{
        novo.setProx(prim);
        prim=novo;
        qtd++;
     
        
    }  
    System.out.println("inseracão realizada com sucesso");
   }
   
   
   public void exibirLista(){
       
       LSENode<T> aux;
       if(qtd==0){
           System.out.println("lista vazia");
      
       }
       else{
          aux = prim;
          while(aux!=null){
              
             System.out.print(aux.getInfo()+ "  ");
             aux=aux.getProx();
              
          }
           
       }
   }
   
  public boolean verificarValor(T valor){
       LSENode<T> aux;
       if(qtd==0){
           
          return false;
      
       }
       else{
          aux = prim;
          while(aux!=null){
                       
         if(aux.getInfo()==valor){
                return true;
             
             }
             
             aux=aux.getProx();
               
              
          }
        return false;
       }
  }
}

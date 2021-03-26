package com.classes.classe.Unikut;
class LSENode <T>{
    private T info;
    private LSENode<T> prox;
    
    
    
 LSENode(T valor){
      
   this.info = valor; 
      
  }  
  void setInfo(T valor){
      this.info=valor;
  }  
  
   void setProx(LSENode<T> newProx){
      this.prox=newProx;
  }
   T getInfo(){
      return info;
  }  
   LSENode<T> getProx(){
      return prox;
  }  
    
}

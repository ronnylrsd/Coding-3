 
package br.unciap.c3.ed11;


public class produto implements Comparable <produto>{
 
    private String cod;
    private String desc;
    private double preco;
    private int estoque;
    
    public produto ( String c){
        this.cod= c; 
    }

    public String getCod() {
        return cod;
    }


    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getEstoque() {
        return estoque;
    }

    public void setEstoque(int estoque) {
        this.estoque = estoque;
    }
    
    public String toString (){
        
       return cod + " " + desc + " " + preco + " " + estoque;
    }
  
    public int compareTo(produto prod) {
    
        return this.cod.compareTo(prod.cod);
    }
    
}

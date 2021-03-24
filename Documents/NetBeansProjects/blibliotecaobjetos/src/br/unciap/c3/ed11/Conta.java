
package br.unciap.c3.ed11;

public class Conta implements Comparable <Conta> {

 private String login;
 private String senha;
 private String nome;
 
    public Conta(String log, String senha){
        
       this.login=log;
       this.senha=senha;
    }
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public int compareTo(Conta t) {
      
       return this.login.compareTo(t.login);
        
    } public String getLogin() {
        return login;
      }
      public void setSenha(String senha){
      this.senha = senha;
       
     }
 public String getSenha() {
        return senha;
    }    
}

package com.classes.Unikut;
public class Recado implements Comparable <Recado> {
    private String login;
    private String mensagem;
    
    public Recado(String log,String msg){
        this.login = log;
        this.mensagem = msg;
    }

    public String getLogin() {
        return login;
    }
    
    public void setLogin(String login) {
        this.login = login;
    }

    public String getMensagem() {
        return mensagem;
    }
    
    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
    
    @Override
    public String toString (){
        return "O usuário: "+login+": "+mensagem+".";
    }
    @Override
    public int compareTo(Recado t) {
        return this.login.compareTo(t.login);
    }
}

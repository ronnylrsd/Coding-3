package com.classes.Unikut;
public class Amigo implements Comparable <Amigo>{
    private String login;
    private String status;
    
    public Amigo(String log){
        this.login = log;
        this.status = "pendente";
    }

    public String getLogin() {
        return login;
    }

    private void setLogin(String login) {
        this.login = login;
    }

    public String getStatus() {
        return status;
    }

    protected void setStatus() {
        this.status = "Amigo";
    }
    
    public void AlteraStatus(Amigo amg){
        amg.setStatus();
    }
    
    @Override
    public String toString (){
        return "O usuário: "+login+": "+status+".";
    }

    @Override
    public int compareTo(Amigo t) {
        return this.login.compareTo(t.getLogin());
    }
    
}

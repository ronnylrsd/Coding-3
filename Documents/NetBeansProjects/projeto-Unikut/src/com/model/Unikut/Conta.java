package com.model.Unikut;

public abstract class Conta {

    private String login;
    private String senha;
    private String nome;

    public Conta(String log, String senha) {
        this.login = log;
        this.senha = senha;
        this.nome = "convidado";
    }

    public Conta(String log, String senha, String nome) {
        this.login = log;
        this.senha = senha;
        this.nome = nome;
    }

    public Conta(String log) {
        this.login = log;
    }

    public String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return this.login;
    }
    
}
package com.model.Unikut;

public class ContaFactory {

    public static Conta getConta(String login, String senha, String nome) {
        if(!login.contains(".adm")){
            return new ContaUsuario(login,senha,nome);
        }
        else{
            return new ContaAdministradora(login,senha);
        }
    }
}

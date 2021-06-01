package com.model.Unikut;
  
public class ContaAdministradora extends Conta {

    public ContaAdministradora(String login, String senha) {
        super(login, senha);
    }

    public String exibeContaAdm(Conta exibir) {
        return exibir.ImprimeInformacoesConta();
    }
}
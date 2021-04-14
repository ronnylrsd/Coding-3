package com.classes.Unikut;
public class ContaAdministradora extends Conta {
    public ContaAdministradora(String login,String senha){
        super(login,senha);
    }
    
    public boolean alteraAdm (Conta alterar){
        if(alterar == null){
            return false;
        }
        else{
            super.alterarDados(alterar);
            return true;
        }
    }
    
    public void exibeContaAdm (Conta exibir){
        if(exibir == null){
            System.out.println("Conta inexistente!");
        }
        else{
            System.out.println("Informações sobre a conta:");
            if(exibir.getNome().compareTo("convidado")==0){
                System.out.println("Nome: ainda não adicionado.");
            }
            else{
                System.out.println("Nome: "+exibir.getNome());
            }
            if(exibir.getIdade()==0){
                System.out.println("Idade: ainda não adicionada.");
            }
            else{
                System.out.println("Idade: "+exibir.getIdade());
            }
            if(exibir.getSexo()!='M' || exibir.getSexo()!='F' || exibir.getSexo()!='I'){
                System.out.println("Sexo: ainda não adicionado.");
            }
            else{
                System.out.println("Sexo: "+exibir.getSexo());
            }
            if(exibir.getAniversario() == null){
                System.out.println("Aniversário: ainda não adicionado.");
            }
            else{
                System.out.println("Aniversário: "+exibir.getAniversario());
            }
            if(exibir.getEstadoCivil() == null){
                System.out.println("Estado Civil: ainda não adicionado.");
            }
            else{
                System.out.println("Estado Civil: "+exibir.getEstadoCivil());
            }
        }
    }
}

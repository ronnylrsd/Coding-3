package com.classes.Unikut;
import com.classes.classe.Unikut.LSESemRepetidos;
import java.util.Scanner;
public class CadastroConta {
    LSESemRepetidos<Conta> dados;

    public LSESemRepetidos<Conta> getDados() {
        return dados;
    }

    public void setDados(LSESemRepetidos<Conta> dados) {
        this.dados = dados;
    }
    
    public CadastroConta(){//criar a lista
        dados = new LSESemRepetidos();
    }
    
    public boolean entrar (String login,String senha){
        Conta ct = new Conta(login,senha);
        return dados.buscarObjeto(ct) != null;
    }
    
    public void cadastrar (String login,String senha){
    Scanner in = new Scanner(System.in);
        Conta ct = new Conta (login,senha);
        if(dados.buscarObjeto(ct)==null){
            System.out.println("Seu nome foi iniciado como convidado.");
            System.out.println("Você deseja alterar o seu nome?(Sim/Não)");
            String sn = in.nextLine();
            if(sn.equalsIgnoreCase("sim")==true){
                System.out.println("Informe o nome:");
                String nome = in.nextLine();
                ct= new Conta(login,senha,nome);
                dados.inserirValorFinal(ct);
            }
            else{
                ct = new Conta(login,senha);
                dados.inserirValorFinal(ct);
            }
        }
        else{
            System.out.println("Conta já cadastrada.");
        }
    }
    
    public void alteraPerfil (String lg,String s){
        Conta ct = new Conta (lg,s);
        Conta result = dados.buscarObjeto(ct);
        if(result != null){
            result.alterarDados(result);
        }
        else{
            System.out.println("Conta não cadastrado!");
        }
    }
    
    public void amigos (Conta ct){
        Scanner in = new Scanner (System.in);
        LSESemRepetidos amigos = new LSESemRepetidos();
        int op;
        do{
            System.out.println("Bem-vindo aos amigos.");
            System.out.println("Menu de opções:");
            System.out.println("1-Adicionar amigo.");
            System.out.println("2-Status de amizades.");
            System.out.println("3-Sair de amigos.");
            System.out.println("Escolha uma opção");
            op = in.nextInt();
        }while(op != 3);
    }
}

package com.classes.Unikut;
import com.classes.classe.Unikut.LSESemRepetidos;
import java.util.Scanner;
public class Menu {
    private LSESemRepetidos<Conta> usuariosCadastrados;
    
    public LSESemRepetidos<Conta> getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    private void setUsuariosCadastrados(LSESemRepetidos<Conta> dados) {
        this.usuariosCadastrados = dados;
    }
    
    public Menu(){//criar a lista
        usuariosCadastrados = new LSESemRepetidos();
    }
    
    public boolean entrar (){
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String login = in.nextLine();
        System.out.println("Informe a senha:");
        String senha = in.nextLine();
        Conta conta = new Conta(login,senha);
        return usuariosCadastrados.buscarObjeto(conta) != null;
    }
    
    public void cadastrar (){
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String login = in.nextLine();
        System.out.println("Informe a senha:");
        String senha = in.nextLine();
        Conta ct = new Conta (login,senha);
        if(usuariosCadastrados.buscarObjeto(ct)==null){
            System.out.println("Seu nome foi iniciado como convidado.");
            System.out.println("Você deseja alterar o seu nome?(Sim/Não)");
            String sn = in.nextLine();
            if(sn.equalsIgnoreCase("sim")==true){
                System.out.println("Informe o nome:");
                String nome = in.nextLine();
                ct= new Conta(login,senha,nome);
                usuariosCadastrados.inserirValorFim(ct);
            }
            else{
                ct = new Conta(login,senha);
                usuariosCadastrados.inserirValorFim(ct);
            }
            System.out.println("Conta cadastrada com sucesso!");
        }
        else{
            System.out.println("Conta já cadastrada.");
        }
    }
    
    public void alteraPerfil (){
        Scanner in = new Scanner (System.in);
        System.out.println("Para alterar o perfil: Confirme.");
        System.out.println("Informe o login:");
        String login = in.nextLine();
        System.out.println("Informe a senha:");
        String senha = in.nextLine();
        Conta ct = new Conta (login,senha);
        Conta result = usuariosCadastrados.buscarObjeto(ct);
        if(result != null){
            result.alterarDados(result);
        }
        else{
            System.out.println("Conta não cadastrado!");
        }
    }
    
    public void amigos (){
        Scanner in = new Scanner (System.in);
        int op;
        do{
            Conta result1 = null;
            Conta result2;
            Conta result3;
            System.out.println("Bem-vindo aos amigos.");
            System.out.println("Menu de opções:");
            System.out.println("1-Adicionar amigo.");
            System.out.println("2-Status de amizades.");
            System.out.println("3-Aceitar solicitações.");
            System.out.println("4-Sair de amigos.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            in.nextLine();
            switch(op){
                case 1:
                    System.out.println("Para alterar o perfil: Confirme.");
                    System.out.println("Informe o login:");
                    String login = in.nextLine();
                    System.out.println("Informe a senha:");
                    String senha = in.nextLine();
                    Conta ct = new Conta (login,senha);
                    result1 = usuariosCadastrados.buscarObjeto(ct);
                    if(result1 != null){
                        System.out.println("Informe o login do usuário para enviar a solicitação:");
                        String lg = in.nextLine();
                        Conta amg = new Conta (lg);
                        result2 = usuariosCadastrados.buscarObjeto(amg);
                        if(result2 != null){
                            result1.adicionaAmigos(result2);
                            result2.adicionaAmigos(result1);
                            System.out.println("Solicitação enviada.");
                        }
                        else{
                            System.out.println("Conta amiga não cadastrada!");
                        }
                    }
                    else{
                        System.out.println("Conta não cadastrado!");
                    }
                    break;
                case 2:
                    if(result1 != null){
                        result1.listaAmigos();
                    }
                    else{
                        System.out.println("Lista Vazia!");
                    }
                    break;
                case 3:
                    System.out.println("Informe o login do usuário para alterar status:");
                    login = in.nextLine();
                    Conta conta = new Conta (login);
                    result3 = usuariosCadastrados.buscarObjeto(conta);
                    if(result1 != null && result3 != null){
                        result1.alteraStatusAmigos(result3);
                        System.out.println("Status de amigo, atualizado!");
                    }
                    else{
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 4:
                    System.out.println("De volta à conta.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        }while(op != 4);
    }
    
}

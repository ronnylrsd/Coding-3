package com.classes.Unikut;
import java.util.LinkedList;
import java.util.Scanner;
public class Menu {
    protected LinkedList<Conta> usuariosCadastrados;
    private String login;
    private String senha;

    public LinkedList getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public void setUsuariosCadastrados(LinkedList usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }
    
    public Menu(){//criar a lista
        usuariosCadastrados = new LinkedList<>();
    }
    
    protected Conta buscaSimples(Conta ct){
        int i=0;
        if(usuariosCadastrados.isEmpty()){
            return null;
        }
        else{
            Conta conta = usuariosCadastrados.get(i);
            Conta last = usuariosCadastrados.getLast();
            while(conta != null){
                if(ct.compareTo(conta)==0){
                    return conta;
                }
                else{
                    if(usuariosCadastrados.indexOf(last)==i){
                        return null;
                    }
                    else{
                        conta = usuariosCadastrados.get(i+1);
                    }
                }   
            }
            return null;
        }
    }
    
    public int entrar (){
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        login = in.nextLine();
        System.out.println("Informe a senha:");
        senha = in.nextLine();
        Conta ctt = new Conta(login,senha);
        if(buscaSimples(ctt) != null){
            if(login.contains(".adm")){
                return 1;
            }
            else{
                return 0;
            }
        }
        return -1;
    }
    
    public void cadastrar (){
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String lg = in.nextLine();
        System.out.println("Informe a senha:");
        String s = in.nextLine();
        if(lg.contains(".adm")){
            Conta ctt = new Conta(lg,s);
            if(buscaSimples(ctt) == null ){
                usuariosCadastrados.add(ctt);
                System.out.println("Conta administradora cadastrada com sucesso!");
            }
            else{
                System.out.println("Conta já cadastrada.");
            }
        }
        else{
            Conta ct = new Conta (lg,s);
            if(buscaSimples(ct) == null ){
            System.out.println("Seu nome foi iniciado como convidado.");
            System.out.println("Você deseja alterar o seu nome?(Sim/Não)");
            String sn = in.nextLine();
            if(sn.equalsIgnoreCase("sim")==true){
                System.out.println("Informe o nome:");
                String nome = in.nextLine();
                ct= new Conta(lg,s,nome);
                usuariosCadastrados.add(ct);
                System.out.println("Conta com nome alterado cadastrada com sucesso!");
            }
            else if(sn.equalsIgnoreCase("nao")==true){
                ct = new Conta(lg,s);
                usuariosCadastrados.add(ct);
                System.out.println("Conta sem nome alterado cadastrada com sucesso!");
            }
            else{
                System.out.println("Resposta inválida.");
            }
        }
        else{
            System.out.println("Conta já cadastrada.");
        }
        }
    }
    
    public void alteraPerfil (){
        Conta result;
        Conta ctt = new Conta(login,senha);
        result = buscaSimples(ctt);
        result.alterarDados(result);
    }
    
    public void amigos (){
        Scanner in = new Scanner (System.in);
        int op;
        do{
            Conta conta,amigo,amg;
            Conta ctt = new Conta(login,senha);
            conta = buscaSimples(ctt);
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
                    System.out.println("Informe o login do usuário para enviar a solicitação:");
                    String lg = in.nextLine();
                    Conta ct = new Conta (lg);
                    amigo = buscaSimples(ct);
                    if(amigo != null){
                        conta.adicionaAmigos(amigo);
                        System.out.println("Solicitação enviada.");
                    }
                    else{
                        System.out.println("Conta de amigo não cadastrada!");
                    }
                    break;
                case 2:
                    conta.listaAmigos();
                    break;
                case 3:
                    System.out.println("Informe o login do usuário para alterar status:");
                    String l = in.nextLine();
                    Conta c = new Conta(l);
                    amg = buscaSimples(c);
                    if(amg != null){
                        conta.alteraStatusAmigos(amg);
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
    
    public void recados(){
        Scanner in = new Scanner (System.in);
        int op;
        do{
            Conta conta;
            Conta ctt = new Conta(login,senha);
            conta = buscaSimples(ctt);
            System.out.println("Bem-vindo aos recados.");
            System.out.println("Menu de opções:");
            System.out.println("1-Enviar recado.");
            System.out.println("2-Visualizar recados.");
            System.out.println("3-Sair de recados.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            in.nextLine();
            switch(op){
                case 1:
                    System.out.println("Informe o login do destinatário:");
                    String lgn= in.nextLine();
                    Conta ch = new Conta(lgn);
                    Conta resultar = buscaSimples(ch);
                    if(resultar != null){            
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        resultar.adicionaRecado(login,msg);
                    }
                    else{
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 2:
                    conta.listaRecados();
                    break;
                case 3:
                    System.out.println("De volta à conta.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        }while(op != 3);
    }
    
    public void removerConta(){
        Scanner in = new Scanner (System.in);
        System.out.println("Processo para excluir conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        Conta teste = new Conta(lge);
        Conta busca = buscaSimples(teste);
        if(busca != null){
            usuariosCadastrados.remove(busca);
            System.out.println("Conta removida!");
        }
        else{
            System.out.println("Conta inexistente!");
        }
    }
    
    public void alterarConta(){
        Scanner in = new Scanner (System.in);
        System.out.println("Processo para alterar conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        Conta teste = new Conta(lge);
        Conta busca =  buscaSimples(teste);
        if(busca != null){
            busca.alteraAdm(busca);
        }
        else{
            System.out.println("Conta inexistente!");
        }
    }
    
}

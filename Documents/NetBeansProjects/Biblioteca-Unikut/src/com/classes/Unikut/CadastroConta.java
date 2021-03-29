package com.classes.Unikut;
import com.classes.classe.Unikut.LSESemRepetidos;
import java.util.Scanner;
public class CadastroConta {
    private LSESemRepetidos<Conta> dados;
    private LSESemRepetidos<Amigo> amigos;
    private LSESemRepetidos<Recado> recados;
    
    public LSESemRepetidos<Conta> getDados() {
        return dados;
    }

    private void setDados(LSESemRepetidos<Conta> dados) {
        this.dados = dados;
    }

    public LSESemRepetidos getAmigos() {
        return amigos;
    }

    private void setAmigos(LSESemRepetidos amigos) {
        this.amigos = amigos;
    }

    public LSESemRepetidos getRecados() {
        return recados;
    }

    private void setRecados(LSESemRepetidos recados) {
        this.recados = recados;
    }
    
    public CadastroConta(){//criar a lista
        dados = new LSESemRepetidos();
        amigos = new LSESemRepetidos();
        recados = new LSESemRepetidos();
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
    
    public void amigos (){
        Scanner in = new Scanner (System.in);
        int op;
        do{
            System.out.println("Bem-vindo aos amigos.");
            System.out.println("Menu de opções:");
            System.out.println("1-Adicionar amigo.");
            System.out.println("2-Status de amizades.");
            System.out.println("3-Aceitar solicitações.");
            System.out.println("4-Sair de amigos.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Informe o login do usuário:");
                    String login = in.nextLine();
                    Conta ctt = new Conta (login);
                    Conta result = dados.buscarObjeto(ctt);
                    if(result != null){
                        Amigo amg = new Amigo(login);
                        amigos.inserirValorFinal(amg);
                    }
                    else{
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 2:
                    amigos.exibirLista();
                    break;
                case 3:
                    System.out.println("Informe o login do usuário:");
                    login = in.nextLine();
                    ctt = new Conta (login);
                    result = dados.buscarObjeto(ctt);
                    if(result != null){
                        Amigo amg = new Amigo(login);
                        amg.AlteraStatus(amg);
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
            System.out.println("Bem-vindo aos recados.");
            System.out.println("Menu de opções:");
            System.out.println("1-Enviar recado.");
            System.out.println("2-Visualizar recados.");
            System.out.println("3-Sair de recados.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            switch(op){
                case 1:
                    System.out.println("Informe o login do destinatário:");
                    String login = in.nextLine();
                    Conta ctt = new Conta (login);
                    Conta result = dados.buscarObjeto(ctt);
                    if(result != null){
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        Recado rec = new Recado(login,msg);
                        recados.inserirValorFinal(rec);
                    }
                    else{
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 2:
                    recados.exibirLista();
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
}

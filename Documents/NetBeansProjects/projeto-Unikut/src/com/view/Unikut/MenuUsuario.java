
package com.view.Unikut;

import com.controller.Unikut.Controle;
import java.util.LinkedList;
import java.util.Scanner;

public class MenuUsuario {
    
    Controle Controll = new Controle();
    protected String login;
    protected String senha;
    
    public void alteraPerfil() {
        int op;
        Scanner in = new Scanner(System.in);
        do {
            System.out.println("Menu de opções:");
            System.out.println("1-Alterar nome.");
            System.out.println("2-Alterar senha.");
            System.out.println("3-Alterar idade.");
            System.out.println("4-Alterar sexo.");
            System.out.println("5-Alterar aniversario.");
            System.out.println("6-Alterar estado civil.");
            System.out.println("7-Voltar ao menu da conta.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Informe o novo nome:");
                    String nome = in.nextLine();
                    Controll.alteraPerfil(op, nome);
                    System.out.println("Alteração concluída.");
                    break;
                case 2:
                    System.out.println("Informe a nova senha:");
                    String ne = in.nextLine();
                    Controll.alteraPerfil(op, ne);
                    System.out.println("Alteração concluída.");
                    break;
                case 3:
                    System.out.println("Informe a nova idade:");
                    String ni = in.nextLine();
                    Controll.alteraPerfil(op, ni);
                    System.out.println("Alteração concluída.");
                    break;
                case 4:
                    System.out.println("Informe o sexo:");
                    String ns = in.nextLine();
                    while (ns.compareToIgnoreCase("homem") != 0 && ns.compareToIgnoreCase("mulher") != 0 && ns.compareToIgnoreCase("outro") != 0) {
                        System.out.println("Insira homem,mulher ou outro");
                        ns = in.nextLine();
                    }
                    Controll.alteraPerfil(op, ns);
                    System.out.println("Alteração concluída.");
                    break;
                case 5:
                    System.out.println("Informe o aniversário:");
                    String na = in.nextLine();
                    Controll.alteraPerfil(op, na);
                    System.out.println("Alteração concluída.");
                    break;
                case 6:
                    System.out.println("Informe o estado civil");
                    String nec = in.nextLine();
                    Controll.alteraPerfil(op, nec);
                    System.out.println("Alteração concluída.");
                    break;
                case 7:
                    System.out.println("Voltando para o menu da conta.");
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        } while (op != 7);
    }
    
    public void amigos() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("Bem-vindo aos amigos.");
            System.out.println("Menu de opções:");
            System.out.println("1-Adicionar amigo.");
            System.out.println("2-Status de amizades.");
            System.out.println("3-Aceitar solicitações.");
            System.out.println("4-Sair de amigos.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Informe o login do usuário para enviar a solicitação:");
                    String lg = in.nextLine();
                    if (Controll.VerificarConta(lg, " ")) {
                        if (Controll.AdicionarAmigo(lg)) {
                            System.out.println("Amigo adicionado com sucesso");
                        } else {
                            System.out.println("Amigo ja adicionado");
                        }

                    } else {
                        System.out.println("Usuario Nao Existe");
                    }
                    break;
                case 2:
                    LinkedList s = Controll.ControlListaAmigos();
                    for (int i = 0; i < s.size(); i++) {
                        System.out.println(s.get(i));
                    }

                    break;
                case 3:
                    System.out.println("Informe o login do usuário para alterar status:");
                    String l = in.nextLine();
                    if (Controll.VerificarConta(l, "") && login.compareTo(l) != 0) {
                        System.out.println("Status de amigo atualizado");
                        Controll.StatusDeAmigos(l);
                    } else {
                        System.out.println("Usuario não existe");
                    }

                    break;
                case 4:
                    System.out.println("De volta à conta.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != 4);
    }
    
    public void recados() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            Conta conta;
            Conta ctt = new Conta(login, senha);
            conta = buscaSimples(ctt);
            System.out.println("Bem-vindo aos recados.");
            System.out.println("Menu de opções:");
            System.out.println("1-Enviar recado.");
            System.out.println("2-Enviar recado secreto.");
            System.out.println("3-Enviar recado mural.");
            System.out.println("4-Aceitar recado mural.");
            System.out.println("5-Visualizar recados.");
            System.out.println("6-Vizualizar recados secretos.");
            System.out.println("7-Vizualizar recados mural.");
            System.out.println("8-Sair de recados.");
            System.out.println("Escolha uma opção:");
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Informe o login do destinatário:");
                    String lgn = in.nextLine();
                    Conta ch = new Conta(lgn);
                    Conta resultar = buscaSimples(ch);
                    if (resultar != null && login.compareTo(lgn) != 0) {
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        resultar.adicionaRecado(login, msg);
                    } else {
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 2:
                    System.out.println("Informe o login do destinatário:");
                    lgn = in.nextLine();
                    ch = new Conta(lgn);
                    resultar = buscaSimples(ch);
                    if (resultar != null) {
                        System.out.println("Informe a senha da mensagem:");
                        String senha1 = in.nextLine();
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        resultar.adicionaRecadoComSenha(login, msg, senha1);
                    } else {
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 3:
                    System.out.println("Informe o login do destinatario");
                    String lgm = in.nextLine();
                    Conta m = new Conta(lgm);
                    Conta resulta = buscaSimples(m);
                    if (resulta != null) {
                        System.out.println("Informe a mensagem");
                        String msg = in.nextLine();
                        resulta.adicionaRecadoMural(login, msg);
                    } else {
                        System.out.println("Login não encontrado!");
                    }
                    break;
                case 4:

                    break;
                case 5:
                    conta.listaRecados();
                    break;
                case 6:
                    System.out.println("Informe a senha para ler a mensagem:");
                    String senha2 = in.nextLine();
                    conta.listaRecadosComSenha(senha2);
                    break;
                case 7:
                    conta.listaRecadosMural();
                    break;
                case 8:
                    System.out.println("De volta à conta.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != 8);
    }
    
    public void Match() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo a aba de Matches");
        int op;

        do {
        
            System.out.println("O que deseja fazer?");
            System.out.println("1-Adicionar Match.");
            System.out.println("2-Ver Status Match.");
            System.out.println("3-Sair da Aba Match.");
            op = in.nextInt();
            in.nextLine();
            switch (op) {
                case 1:
                    System.out.println("Informe o login do usuario que voce quer adicionar no Match:");
                    String lgn;
                    lgn = in.nextLine();
                    Controll.VerificarConta(lgn, " ");
                    if (!Controll.VerificarConta(lgn, " ")) {
                        System.out.println("A conta não existe!");
                    } else {
                       Controll.Match(lgn);
                    }
                    break;
                case 2:
                    LinkedList Match = Controll.VerMeusMatchs();
                    for (int i = 0; i < Match.size(); i++) {
                        System.out.println(Match.get(i));
                    }
                    break;
                case 3:
                    System.out.println("Saindo da Aba matches.");
                    break;
                default:
                    System.out.println("Insira um comando valido.");
            }
        } while (op != 3);

    }
}
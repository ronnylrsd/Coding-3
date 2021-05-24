package com.classes.Unikut;

import java.util.Collections;
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

    public Menu() {//criar a lista
        usuariosCadastrados = new LinkedList<>();
    }

    protected Conta buscaSimples(Conta ct) {
        Collections.sort(usuariosCadastrados);
        int index = Collections.binarySearch(usuariosCadastrados, ct);
        if (index < 0) {
            return null;
        } else {
            return usuariosCadastrados.get(index);
        }
    }

    public int entrar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        login = in.nextLine();
        System.out.println("Informe a senha:");
        senha = in.nextLine();
        Conta ctt = new Conta(login, senha);
        Conta busca = buscaSimples(ctt);
        if (busca != null && busca.getSenha().compareTo(senha) == 0) {
            if (login.contains(".adm")) {
                return 1;
            } else {
                return 0;
            }
        } else if (busca != null && busca.getSenha().compareTo(senha) != 0) {
            return -2;
        }
        return -1;
    }

    public void cadastrar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String lg = in.nextLine();
        System.out.println("Informe a senha:");
        String s = in.nextLine();
        if (lg.contains(".adm")) {
            ContaAdministradora ctt = new ContaAdministradora(lg, s);
            if (buscaSimples(ctt) == null) {
                usuariosCadastrados.add(ctt);
                System.out.println("Conta administradora cadastrada com sucesso!");
            } else {
                System.out.println("Conta já cadastrada.");
            }
        } else {
            char sn = 0;
            do {
                Conta ct = new Conta(lg, s);
                if (buscaSimples(ct) == null) {
                    System.out.println("Seu nome foi iniciado como convidado.");
                    System.out.println("Você deseja alterar o seu nome?(S = Sim/N = Não)");
                    sn = in.nextLine().charAt(0);
                    switch (sn) {
                        case 'S':
                            System.out.println("Informe o nome:");
                            String nome = in.nextLine();
                            ct = new Conta(lg, s, nome);
                            usuariosCadastrados.add(ct);
                            System.out.println("Conta com nome alterado cadastrada com sucesso!");
                            break;
                        case 'N':
                            ct = new Conta(lg, s);
                            usuariosCadastrados.add(ct);
                            System.out.println("Conta sem nome alterado cadastrada com sucesso!");
                            break;
                        default:
                            System.out.println("Resposta inválida.");
                            break;
                    }
                } else {
                    System.out.println("Conta já cadastrada.");
                }
            } while (sn != 'S' && sn != 'N');
        }
    }

    public void alteraPerfil() {
        Conta result;
        Conta ctt = new Conta(login, senha);
        result = buscaSimples(ctt);
        result.alterarDados(result);
    }

    public void amigos() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            Conta conta, amigo, amg;
            Conta ctt = new Conta(login, senha);
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
            switch (op) {
                case 1:
                    System.out.println("Informe o login do usuário para enviar a solicitação:");
                    String lg = in.nextLine();
                    Conta ct = new Conta(lg);
                    amigo = buscaSimples(ct);
                    if (amigo != null && login.compareTo(lg) != 0) {
                        conta.adicionaAmigos(amigo);
                        System.out.println("Solicitação enviada.");
                    } else {
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
                    if (amg != null && login.compareTo(l) != 0) {
                        conta.alteraStatusAmigos(amg);
                        System.out.println("Status de amigo, atualizado!");
                    } else {
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
        } while (op != 4);
    }

    public void Match() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo a aba de Matches");
        int op;

        do {
            Conta conta;
            Conta Usuario = new Conta(login, senha);
            conta = buscaSimples(Usuario); // armezanando a conta do Usuario que está mexendo na rede

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
                    Conta descartavel = new Conta(lgn); // criando uma conta apenas para inicializar com o login passado
                    Conta Armazenar = buscaSimples(descartavel);
                    if (!usuariosCadastrados.contains(Armazenar)) {
                        System.out.println("A conta não existe!");
                    } else {
                        if (Armazenar.getMatch().contains(conta)) {// se a conta que eu quero adicionar possui a minha conta nos matchs
                            conta.AdicionarMatch(Armazenar, "Match"); // irei usar o recurso adicionar na minha 
                            Armazenar.AlterarStatus(Usuario);
                        } else {
                            conta.AdicionarMatch(Armazenar, " ");
                        }
                    }
                    break;
                case 2:
                    conta.ExibirMatch();
                    break;
                case 3:
                    System.out.println("Saindo da Aba matches.");
                    break;
                default:
                    System.out.println("Insira um comando valido.");
            }
        } while (op != 3);

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
            System.out.println("3-Visualizar recados.");
            System.out.println("4-Vizualizar recados secretos.");
            System.out.println("5-Recados Mural.");
            System.out.println("6-Sair de recados.");

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
                    conta.listaRecados();
                    break;
                case 4:
                    System.out.println("Informe a senha para ler a mensagem:");
                    String senha2 = in.nextLine();
                    conta.listaRecadosComSenha(senha2);
                    break;
                case 5:
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
                case 6:
                    System.out.println("De volta à conta.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != 6);
    }

    public void removerConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para excluir conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        Conta teste = new Conta(lge);
        Conta busca = buscaSimples(teste);
        ContaAdministradora confirma = new ContaAdministradora(login, senha);
        ContaAdministradora adm = (ContaAdministradora) buscaSimples(confirma);//cast
        if (busca == null) {
            System.out.println("Conta inexistente!");
        } else if (login.compareTo(lge) == 0 || busca.getLogin().contains(".adm") == true) {
            System.out.println("A conta administradora não pode ser removida.");
        } else {
            usuariosCadastrados.remove(busca);
            System.out.println("Conta removida!");
        }
    }

    public void alterarConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para alterar conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        Conta teste = new Conta(lge);
        Conta busca = buscaSimples(teste);
        ContaAdministradora confirma = new ContaAdministradora(login, senha);
        ContaAdministradora adm = (ContaAdministradora) buscaSimples(confirma);//cast
        if (busca == null) {
            System.out.println("Conta inexistente!");
        } else if (login.compareTo(lge) == 0 || busca.getLogin().contains(".adm") == true) {
            System.out.println("A conta administradora não pode ser alterada.");
        } else {
            adm.alteraAdm(busca);
        }
    }

    public void exibirConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para exibir conta.");
        System.out.println("Informe o login da conta:");
        String log = in.nextLine();
        Conta teste = new Conta(log);
        Conta busca = buscaSimples(teste);
        ContaAdministradora confirma = new ContaAdministradora(login, senha);
        ContaAdministradora adm = (ContaAdministradora) buscaSimples(confirma);//cast
        if (busca == null) {
            System.out.println("Conta inexistente!");
        } else if (login.compareTo(log) == 0 || busca.getLogin().contains(".adm") == true) {
            System.out.println("A conta administradora não pode ser exibida.");
        } else {
            adm.exibeContaAdm(busca);
        }
    }
}
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
            System.out.println("0-Voltar ao menu da conta.");
            System.out.println("1-Alterar nome.");
            System.out.println("2-Alterar senha.");
            System.out.println("3-Alterar idade.");
            System.out.println("4-Alterar sexo.");
            System.out.println("5-Alterar aniversario.");
            System.out.println("6-Alterar estado civil.");
            System.out.println("Escolha uma opção:");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '0':
                    System.out.println("Voltando para o menu da conta.");
                    break;
                case '1':
                    System.out.println("Informe o novo nome:");
                    String nome = in.nextLine();
                    Controll.alteraPerfil(op, nome);
                    System.out.println("Alteração concluída.");
                    break;
                case '2':
                    System.out.println("Informe a nova senha:");
                    String ne = in.nextLine();
                    Controll.alteraPerfil(op, ne);
                    System.out.println("Alteração concluída.");
                    break;
                case '3':
                    System.out.println("Informe a nova idade:");
                    String ni = in.nextLine();
                    Controll.alteraPerfil(op, ni);
                    System.out.println("Alteração concluída.");
                    break;
                case '4':
                    System.out.println("Informe o sexo:");
                    String ns = in.nextLine();
                    while (ns.compareToIgnoreCase("homem") != 0 && ns.compareToIgnoreCase("mulher") != 0 && ns.compareToIgnoreCase("outro") != 0) {
                        System.out.println("Insira homem,mulher ou outro");
                        ns = in.nextLine();
                    }
                    Controll.alteraPerfil(op, ns);
                    System.out.println("Alteração concluída.");
                    break;
                case '5':
                    System.out.println("Informe o aniversário:");
                    String na = in.nextLine();
                    Controll.alteraPerfil(op, na);
                    System.out.println("Alteração concluída.");
                    break;
                case '6':
                    System.out.println("Informe o estado civil");
                    String nec = in.nextLine();
                    Controll.alteraPerfil(op, nec);
                    System.out.println("Alteração concluída.");
                    break;
                default:
                    System.out.println("Escolha inválida.");
                    break;
            }
        } while (op != '0');
    }

    public void amigos() {
        Scanner in = new Scanner(System.in);
        char op;
        do {
            System.out.println("Bem-vindo aos amigos.");
            System.out.println("Menu de opções:");
            System.out.println("0-Sair de amigos.");
            System.out.println("1-Adicionar amigo.");
            System.out.println("2-Status de amizades.");
            System.out.println("3-Aceitar solicitações.");
            System.out.println("Escolha uma opção:");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '0':
                    System.out.println("De volta à conta.");
                    break;
                case '1':
                    System.out.println("Informe o login do usuário para enviar a solicitação:");
                    String lg = in.nextLine();
                    if (Controll.controllerVerificar(lg)) {
                        if (Controll.AdicionaSituacao(lg)) {
                            System.out.println("Convite Enviado!");
                        } else {
                            System.out.println("Não é possível se adicionar como amigo.");
                        }
                    } else {
                        System.out.println("Usuario não existe!");
                    }
                    break;
                case '2':
                    LinkedList amigos = Controll.controllerVisualizarAmigos();
                    if (amigos.isEmpty()) {
                        System.out.println("Lista Vazia!");
                    } else {
                        for (int i = 0; i < amigos.size(); i++) {
                            System.out.println(amigos.get(i));
                        }
                    }
                    break;
                case '3':
                    
                    LinkedList amigosPendentes = Controll.controllerVisualizarAmigosPedentes();
                    if (amigosPendentes.isEmpty()) {
                        System.out.println("Lista Vazia!");
                    } else {
                        for (int i = 0; i < amigosPendentes.size(); i++) {
                            System.out.println(amigosPendentes.get(i));
                            System.out.println("Deseja aceitar amigo?");
                            String resposta = in.nextLine();
                            if (resposta.compareToIgnoreCase("sim") == 0) {                           
                                 Controll.AdicionarAmigo(i);
                            } else {
                                System.out.println("Amigo não aceito.");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != '0');
    }

    public void recados() {
        Scanner in = new Scanner(System.in);
        int op;
        do {
            System.out.println("Bem-vindo aos recados.");
            System.out.println("Menu de opções:");
            System.out.println("0-Sair de recados.");
            System.out.println("1-Enviar recado.");
            System.out.println("2-Enviar recado secreto.");
            System.out.println("3-Enviar recado mural.");
            System.out.println("4-Aceitar recado mural.");
            System.out.println("5-Visualizar recados.");
            System.out.println("6-Vizualizar recados secretos.");
            System.out.println("7-Vizualizar recados mural.");
            System.out.println("Escolha uma opção:");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '0':
                    System.out.println("De volta à conta.");
                    break;
                case '1':
                    System.out.println("Informe o login do destinatário:");
                    String lgn = in.nextLine();
                    if (Controll.controllerVerificarConta(lgn, "") && login.compareTo(lgn) != 0) {
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        Controll.controllerEnviarRecado(lgn, msg);
                        System.out.println("Recado enviado!");
                    } else {
                        System.out.println("Conta não existe!");
                    }
                    break;
                case '2':
                    System.out.println("Informe o login do destinatário:");
                    lgn = in.nextLine();
                    if (Controll.controllerVerificarConta(lgn, "") && login.compareTo(lgn) != 0) {
                        System.out.println("Informe a senha da mensagem:");
                        String sen = in.nextLine();
                        System.out.println("Informe a mensagem:");
                        String msg = in.nextLine();
                        Controll.controllerEnviarRecadoSecreto(lgn, msg, sen);
                        System.out.println("Recado secreto enviado!");
                    } else {
                        System.out.println("Conta não existe!");
                    }
                    break;
                case '3':
                    System.out.println("Informe o login do destinatario");
                    String lgm = in.nextLine();
                    if (Controll.controllerVerificarConta(lgm, "") && login.compareTo(lgm) != 0) {
                        System.out.println("Informe a mensagem do mural:");
                        String msg = in.nextLine();
                        Controll.controllerEnviarRecadoMural(msg);
                        System.out.println("Recado mural enviado!");
                    } else {
                        System.out.println("Conta não existe!");
                    }
                    break;
                case '4':
                    LinkedList MuralRecadosPendentes = Controll.controllerVisualizarRecadosMuralPedente();
                    for (int i = 0; i < MuralRecadosPendentes.size(); i++) {
                        System.out.println(MuralRecadosPendentes.get(i));
                        System.out.println("Deseja aceitar recados? (Indique o número do recado)");
                        String resposta = in.nextLine();
                        if (resposta.compareToIgnoreCase("sim") == 0) {
                            Controll.controllerRecadosMuralAceito((String) MuralRecadosPendentes.get(i));
                        } else {
                            System.out.println("Recado do mural não aceito.");
                        }
                    }
                    break;
                case '5':
                    LinkedList recados = Controll.controllerVisualizarRecados();
                    if (recados.isEmpty()) {
                        System.out.println("Lista de recados vazia!");
                    } else {
                        for (int i = 0; i < recados.size(); i++) {
                            System.out.println(recados.get(i));
                        }
                    }
                    break;
                case '6':
                    System.out.println("Informe a senha para ler a mensagem:");
                    String senha2 = in.nextLine();
                    LinkedList recadosSecreto = Controll.controllerVisualizarRecadoSecreto(senha2);
                    if (recadosSecreto.isEmpty()) {
                        System.out.println("Lista de recados vazia!");
                    } else {
                        for (int i = 0; i < recadosSecreto.size(); i++) {
                            System.out.println(recadosSecreto.get(i));
                        }
                    }
                    break;
                case '7':
                    LinkedList recadosMural = Controll.controllerVisualizarMuralRecados();
                    if (recadosMural.isEmpty()) {
                        System.out.println("Lista de recados vazia!");
                    } else {
                        for (int i = 0; i < recadosMural.size(); i++) {
                            System.out.println(recadosMural.get(i));
                        }
                    }
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != 0);
    }

    public void Match() {
        Scanner in = new Scanner(System.in);
        System.out.println("Bem vindo a aba de Matches");
        int op;
        do {
            System.out.println("O que deseja fazer?");
            System.out.println("0-Sair da Aba Match.");
            System.out.println("1-Adicionar Match.");
            System.out.println("2-Ver Status Match.");
            op = in.next().charAt(0);
            in.nextLine();
            switch (op) {
                case '0':
                    System.out.println("Saindo da Aba matches.");
                    break;
                case '1':
                    System.out.println("Informe o login do usuario que voce quer adicionar no Match:");
                    String lgn;
                    lgn = in.nextLine();
                    Controll.controllerVerificar(lgn);
                    if (!Controll.controllerVerificar(lgn)){
                        System.out.println("A conta não existe!");
                    } else {
                        Controll.Match(lgn);
                        System.out.println("Match concluído!");
                    }
                    break;
                case '2':
                    LinkedList Match = Controll.VerMeusMatchs();
                    if (Match.isEmpty()) {
                        System.out.println("Lista de recados vazia!");
                    } else {
                        for (int i = 0; i < Match.size(); i++) {
                            System.out.println(Match.get(i));                      
                        }
                    }
                    break;
                default:
                    System.out.println("Insira um comando valido.");
            }
        } while (op != '0');

    }
}

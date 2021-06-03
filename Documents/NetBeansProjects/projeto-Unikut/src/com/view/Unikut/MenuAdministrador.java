package com.view.Unikut;

import com.controller.Unikut.Controle;
import java.util.Scanner;

public class MenuAdministrador {

    Controle Controll = new Controle();
    protected String login;
    protected String senha;

    public void removerConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para excluir conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        if (Controll.controllerVerificar(lge)) {

            if (Controll.controllerRemoveConta(lge) == true) {
                System.out.println("Conta do usuário " + lge + " removida.");

            }
        } else {
            System.out.println("Conta de usuário não existe!");
        }
    }

    public void alterarConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para alterar conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        if (Controll.controllerVerificar(lge)) {
            char op;
            do {
                System.out.println("Menu de opções:");
                System.out.println("0-Voltar ao menu da conta administradora.");
                System.out.println("1-Alterar nome.");
                System.out.println("2-Alterar idade.");
                System.out.println("3-Alterar sexo.");
                System.out.println("4-Alterar aniversario.");
                System.out.println("5-Alterar estado civil.");
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
                        Controll.controllerAlteraPerfilAdm(lge, op, nome);
                        System.out.println("Alteração concluída.");
                        break;
                    case '2':
                        System.out.println("Informe a nova idade:");
                        String ni = in.nextLine();
                        Controll.controllerAlteraPerfilAdm(lge, op, ni);
                        System.out.println("Alteração concluída.");
                        break;
                    case '3':
                        System.out.println("Informe o sexo:");
                        String ns = in.nextLine();
                        while (ns.compareToIgnoreCase("homem") != 0 && ns.compareToIgnoreCase("mulher") != 0 && ns.compareToIgnoreCase("outro") != 0) {
                            System.out.println("Insira homem,mulher ou outro");
                            ns = in.nextLine();
                        }
                        Controll.controllerAlteraPerfilAdm(lge, op, ns);
                        System.out.println("Alteração concluída.");
                        break;
                    case '4':
                        System.out.println("Informe o aniversário:");
                        String na = in.nextLine();
                        Controll.controllerAlteraPerfilAdm(lge, op, na);
                        System.out.println("Alteração concluída.");
                        break;
                    case '5':
                        System.out.println("Informe o estado civil");
                        String nec = in.nextLine();
                        Controll.controllerAlteraPerfilAdm(lge, op, nec);
                        System.out.println("Alteração concluída.");
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                        break;
                }
            } while (op != '0');
        } else {
            System.out.println("Conta não existe!");
        }
    }

    public void exibirConta() {
        Scanner in = new Scanner(System.in);
        System.out.println("Processo para exibir conta.");
        System.out.println("Informe o login da conta:");
        String lge = in.nextLine();
        if (Controll.controllerVerificar(lge)) {
            System.out.println(Controll.controllerExibeConta(lge));
        } else {
            System.out.println("Conta de usuário não existe!");
        }
    }
}

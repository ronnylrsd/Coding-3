package com.view.Unikut;

import java.util.Scanner;


public class ProjetoUnikut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu conta = new Menu();
        int op;
        do {
            System.out.println("UNIKUT");
            loginOuCadastro();
            op = in.nextInt();
            switch (op) {
                case 1:
                    int resultado = conta.entrar();
                    switch (resultado) {
                        case -2:
                            System.out.println("Senha da conta inválida!");
                            break;
                        case -1:
                            System.out.println("Conta inexistente!");
                            break;
                        case 0:
                            int op2;
                            do {
                                System.out.println("Bem-vindo Usuário");
                                perfilOuAmigosOuRecados();
                                op2 = in.nextInt();
                                switch (op2) {
                                    case 1:
                                        conta.alteraPerfil();
                                        break;
                                    case 2:
                                        conta.amigos();
                                        break;
                                    case 3:
                                        conta.recados();
                                        break;
                                    case 4:
                                        conta.Match();
                                        break;
                                    case 5:
                                        System.out.println("De volta ao Menu Inicial.");
                                        break;
                                    default:
                                        System.out.println("Escolha inválida. Tente novamente.");
                                        break;
                                }
                            } while (op2 != 5);
                            break;
                        case 1:
                            int op3;
                            do {
                                System.out.println("Bem-vindo Administrador");
                                removaOuAltera();
                                op3 = in.nextInt();
                                switch (op3) {
                                    case 1:
                                        conta.removerConta();
                                        break;
                                    case 2:
                                        conta.alterarConta();
                                        break;
                                    case 3:
                                        conta.exibirConta();
                                        break;
                                    case 4:
                                        System.out.println("De volta ao Menu Inicial.");
                                        break;
                                    default:
                                        System.out.println("Escolha inválida. Tente novamente.");
                                        break;
                                }
                            } while (op3 != 4);
                            break;
                        default:
                            System.out.println("Ainda não implementado!");
                            break;
                    }
                    break;
                case 2:
                    conta.cadastrar();
                    break;
                case 3:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        } while (op != 3);

    }

    public static void loginOuCadastro() {
        System.out.println("Menu de opções:");
        System.out.println("1-Entrar na conta.");
        System.out.println("2-Cadastrar conta.");
        System.out.println("3-Encerrar o programa.");
        System.out.println("Escolha uma opção:");
    }

    public static void perfilOuAmigosOuRecados() {
        System.out.println("Menu de opções:");
        System.out.println("1-Alterar perfil.");
        System.out.println("2-Aba amigos.");
        System.out.println("3-Aba recados.");
        System.out.println("4-Aba Match.");
        System.out.println("5-Sair da conta.");
        System.out.println("Escolha uma opção:");
    }

    public static void removaOuAltera() {
        System.out.println("Menu de opções:");
        System.out.println("1-Remover conta.");
        System.out.println("2-Alterar conta.");
        System.out.println("3-Exibir conta.");
        System.out.println("4-Sair da conta administradora.");
        System.out.println("Escolha uma opção:");
    }

}

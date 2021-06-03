package com.view.Unikut;
import java.util.Scanner;

public class ProjetoUnikut {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Menu conta = new Menu();
        MenuUsuario usuario = new MenuUsuario();
        MenuAdministrador administrador = new MenuAdministrador();
        char op;
        do {
            System.out.println("UNIKUT");
            loginOuCadastro();
            op = in.next().charAt(0);
            switch (op) {
                case '0':
                    System.out.println("Fim do programa!");
                    break;
                case '1':
                    if (conta.entrar() == false) {
                        System.out.println("Login ou senha inválidos!");
                    } else {
                        char op2;
                        do {
                            System.out.println("Bem-vindo: Usuário.");
                            menuUsuario();
                            op2 = in.next().charAt(0);
                            switch (op2) {
                                case '0':
                                    System.out.println("De volta ao Menu Inicial.");
                                    break;
                                case '1':
                                    usuario.alteraPerfil();
                                    break;
                                case '2':
                                    usuario.amigos();
                                    break;
                                case '3':
                                    usuario.recados();
                                    break;
                                case '4':
                                    usuario.Match();
                                    break;
                                default:
                                    System.out.println("Escolha inválida. Tente novamente.");
                                    break;
                            }
                        } while (op2 != '0');
                    }
                    break;
                case '2':
                    if(conta.entrarAdm() == false){
                        System.out.println("Login ou senha inválidos!");
                    }
                    else{
                        char op3;
                            do {
                                System.out.println("Bem-vindo: Administrador.");
                                menuAdministrador();
                                op3 = in.next().charAt(0);
                                switch (op3) {
                                    case '0':
                                        System.out.println("De volta ao Menu Inicial.");
                                        break;
                                    case '1':
                                        administrador.removerConta();
                                        break;
                                    case '2':
                                        administrador.alterarConta();
                                        break;
                                    case '3':
                                        administrador.exibirConta();
                                        break;
                                    default:
                                        System.out.println("Escolha inválida! Tente novamente.");
                                        break;
                                }
                            } while (op3 != '0');
                    }
                    break;
                case '3':
                    conta.cadastrar();
                    break;
                case '4':
                    conta.cadastrarAdm();
                    break;
                default:
                    System.out.println("Escolha inválida! Tente novamente.");
                    break;
            }
        } while (op != '0');

    }

    public static void loginOuCadastro() {
        System.out.println("Menu de opções:");
        System.out.println("0-Encerrar o programa.");
        System.out.println("1-Entrar na conta.");
        System.out.println("2-Entrar na conta administradora.");
        System.out.println("3-Cadastrar conta.");
        System.out.println("4-Cadastrar conta administradora.");
        System.out.println("Escolha uma opção:");
    }

    public static void menuUsuario() {
        System.out.println("Menu de opções:");
        System.out.println("0-Sair da conta.");
        System.out.println("1-Alterar perfil.");
        System.out.println("2-Aba amigos.");
        System.out.println("3-Aba recados.");
        System.out.println("4-Aba Match.");
        System.out.println("Escolha uma opção:");
    }

    public static void menuAdministrador() {
        System.out.println("Menu de opções:");
        System.out.println("0-Sair da conta administradora.");
        System.out.println("1-Remover conta.");
        System.out.println("2-Alterar conta.");
        System.out.println("3-Exibir conta.");
        System.out.println("Escolha uma opção:");
    }

}
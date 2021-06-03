package com.view.Unikut;

import com.controller.Unikut.Controle;
import java.util.Scanner;

public class Menu {

    Controle Controll = new Controle();
    protected String login;
    protected String senha;

    public boolean entrar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        login = in.nextLine();
        System.out.println("Informe a senha:");
        senha = in.nextLine();
        return Controll.Entrar(login, senha);
    }

    public boolean entrarAdm() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        login = in.nextLine();
        System.out.println("Informe a senha:");
        senha = in.nextLine();
        if (Controll.VerificarContaAdm(login, senha)) {
            if (Controll.EntrarAdm(login, senha)) {
                System.out.println("Bem vindo a sua conta administrador!");
                return true;
            } else {
                System.out.println("Senha incorreta!");
                return false;
            }

        } else {
            System.out.println("Administrador não existe!");
            return false;
        }
    }

    public void cadastrar() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String lg = in.nextLine();
        System.out.println("Informe a senha:");
        String s = in.nextLine();
        //cadastrar com o nome faltando
        if (!Controll.VerificarConta(lg, s)) {
            Controll.Cadastrar(lg, s);
            System.out.println("Conta do usuário criada com sucesso!");
        } else {
            System.out.println("Conta do usuário já existente!");
        }
    }

    public void cadastrarAdm() {
        Scanner in = new Scanner(System.in);
        System.out.println("Informe o login:");
        String lg = in.nextLine();
        System.out.println("Informe a senha:");
        String s = in.nextLine();

        if (!Controll.VerificarConta(lg, s)) {
            Controll.CadastrarAdm(lg, s);
            System.out.println("Conta do administrador criada com sucesso!");
        } else {
            System.out.println("Conta do administrador já existente!");
        }
    }
}

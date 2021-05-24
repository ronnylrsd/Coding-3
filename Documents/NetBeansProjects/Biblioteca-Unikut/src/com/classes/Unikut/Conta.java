package com.classes.Unikut;

import java.util.LinkedList;
import java.util.Scanner;

public class Conta implements Comparable<Conta> {

    private String login;
    private String senha;
    private String nome;
    private int idade;
    private char sexo;
    private String aniversario;
    private String estadoCivil;
    private String status;
    private LinkedList<Conta> amigos;
    private LinkedList<String> recados;
    private LinkedList<Conta> Match;
    private String situacao;
    private String senhaRecado;

    public Conta(String log, String senha) {
        this.login = log;
        this.senha = senha;
        this.nome = "convidado";
        this.amigos = new LinkedList<>();
        this.status = "pendente";
        this.recados = new LinkedList<>();
        this.Match = new LinkedList();
        this.situacao = "espera";

    }

    public Conta(String log, String senha, String nome) {
        this.login = log;
        this.senha = senha;
        this.nome = nome;
        this.amigos = new LinkedList();
        this.recados = new LinkedList<>();
    }

    public Conta(String log) {
        this.login = log;
        this.status = "pendente";
        this.amigos = new LinkedList();
        this.situacao = "espera";
        this.Match = new LinkedList();

    }

    public Conta() {
        this.amigos = new LinkedList<>();
        this.recados = new LinkedList<>();
    }

    public String getLogin() {
        return login;
    }

    protected void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public String getAniversario() {
        return aniversario;
    }

    public void setAniversario(String aniversario) {
        this.aniversario = aniversario;
    }

    public String getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(String estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus() {
        this.status = "amigo";
    }

    public LinkedList<Conta> getAmigos() {
        return amigos;
    }

    private void setAmigos(LinkedList<Conta> amigos) {
        this.amigos = amigos;
    }

    public LinkedList<String> getRecados() {
        return recados;
    }

    private void setRecados(LinkedList<String> recados) {
        this.recados = recados;
    }

    public LinkedList<Conta> getMatch() {
        return Match;
    }

    public String getSituacao() {
        return this.situacao;
    }

    public void setSituacao() {
        this.situacao = "Match";
    }

    public void adicionaRecadoComSenha(String lg, String recado, String senha1) {
        recados.add(lg + ": " + recado);
        setsenhaRecado(senha1);
    }

    public String getsenhaRecado() {
        return senhaRecado;
    }

    public void setsenhaRecado(String senhaRecado) {
        this.senhaRecado = senhaRecado;
    }

    public void alterarDados(Conta result) {
        int op;
        Scanner in = new Scanner(System.in);
        if (result == null) {
            System.out.println("Conta não encontrada!");
        } else {
            System.out.println("Conta encotrada!");
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
                        String nn = in.nextLine();
                        result.setNome(nn);
                        System.out.println("Alteração concluída.");
                        break;
                    case 2:
                        System.out.println("Informe a nova senha:");
                        String ne = in.nextLine();
                        result.setSenha(ne);
                        System.out.println("Alteração concluída.");
                        break;
                    case 3:
                        System.out.println("Informe a nova idade:");
                        int ni = in.nextInt();
                        result.setIdade(ni);
                        System.out.println("Alteração concluída.");
                        break;
                    case 4:
                        System.out.println("Informe o sexo:");
                        char ns = in.next().charAt(0);
                        result.setSexo(ns);
                        System.out.println("Alteração concluída.");
                        break;
                    case 5:
                        System.out.println("Informe o aniversário:");
                        String na = in.nextLine();
                        result.setAniversario(na);
                        System.out.println("Alteração concluída.");
                        break;
                    case 6:
                        System.out.println("Informe o estado civil:");
                        String nec = in.nextLine();
                        result.setEstadoCivil(nec);
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
    }

    public void adicionaAmigos(Conta result) {
        Conta conta = new Conta(login, senha);
        if (buscaSimples(result) == null) {
            this.amigos.add(result);
            result.amigos.add(conta);
        } else {
            System.out.println("Amigo já adicionado.");
        }
    }

    public void listaAmigos() {
        if (amigos.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            int i = 0;
            Conta aux = amigos.getFirst();
            Conta last = amigos.getLast();
            while (aux != null) {
                System.out.println(aux);
                if (amigos.indexOf(last) == i) {
                    return;
                } else {
                    aux = amigos.get(i + 1);
                }
            }
        }
    }

    protected Conta buscaSimples(Conta ct) {
        int i = 0;
        if (amigos.isEmpty()) {
            return null;
        } else {
            Conta conta = amigos.get(i);
            Conta last = amigos.getLast();
            while (conta != null) {
                if (conta.compareTo(ct) == 0) {
                    return conta;
                } else {
                    if (amigos.indexOf(last) == i) {
                        return null;
                    } else {
                        conta = amigos.get(i + 1);
                    }
                }
            }
            return null;
        }
    }

    public void alteraStatusAmigos(Conta result) {
        Conta amigo = buscaSimples(result);
        if (amigo != null) {
            if (amigo.getStatus().equalsIgnoreCase("pendente")) {
                amigo.setStatus();
            } else {
                System.out.println("Solicitação já atualizada.");
            }
        } else {
            System.out.println("Amigo ou conta não existente.");
        }
    }

    public void adicionaRecado(String lg, String recado) {
        recados.add(lg + ": " + recado);
    }

    public void adicionaRecadoMural(String lg, String recado) {
        recados.add(lg + ": " + recado);
    }

    public void listaRecadosMural() {
        if (recados.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            int i = 0;
            String aux = recados.getFirst();
            String last = recados.getLast();
            while (aux != null) {
                System.out.println(aux);
                if (recados.indexOf(last) == i) {
                    return;
                } else {
                    aux = recados.get(i + 1);
                }
            }
        }
    }

    public void listaRecados() {
        if (recados.isEmpty()) {
            System.out.println("Lista vazia!");
        } else {
            int i = 0;
            String aux = recados.getFirst();
            String last = recados.getLast();
            while (aux != null) {
                System.out.println(aux);
                if (recados.indexOf(last) == i) {
                    return;
                } else {
                    aux = recados.get(i + 1);
                }
            }
        }
    }

    public void AdicionarMatch(Conta passada, String flag) {

        if (this.Match.contains(passada)) {
            System.out.println("Conta ja adicionada na Aba Matches");
        } else if (flag.equals("Match")) {
            passada.setSituacao();// mudo para Match
            this.Match.add(passada);

        } else {
            this.Match.add(passada);
        }
    }

    public void AlterarStatus(Conta passada) {
        int cont = 0;
        Conta Prim = Match.get(cont);
        Conta Ult = Match.getLast();

        while (Prim != null) {

            if (Prim.compareTo(passada) == 0) {
                Prim.setSituacao();
                return;
            } else {

                if (Match.indexOf(Ult) == cont) {
                    return;
                } else {
                    Prim = Match.get(cont + 1);
                }
            }
        }

    }

    public void ExibirMatch() {

        if (this.Match.isEmpty()) {
            System.out.println("Nenhum Match");
        } else {
            int cont = 0;
            Conta Prim = Match.get(cont);
            Conta Ult = Match.getLast();

            while (Prim != null) {
                System.out.print(Prim.getLogin());
                System.out.print(":" + Prim.getSituacao());
                System.out.println("");

                if (Match.indexOf(Ult) == cont) {
                    return;
                } else {
                    Prim = Match.get(cont + 1);
                }
            }
        }

    }

    public void listaRecadosComSenha(String senha2) {

        String SenhaReal = getsenhaRecado();

        if (SenhaReal.equals(senha2)) {

            if (recados.isEmpty()) {
                System.out.println("Lista vazia!");
            } else {
                int i = 0;
                String aux = recados.getFirst();
                String last = recados.getLast();
                while (aux != null) {
                    System.out.println(aux);
                    if (recados.indexOf(last) == i) {
                        return;
                    } else {
                        aux = recados.get(i + 1);
                    }
                }
            }
        } else {
            System.out.println("Senha Invalida.");
        }
    }

    @Override
    public String toString() {
        return this.login + " " + this.status;
    }

    @Override
    public int compareTo(Conta t) {
        return this.login.compareTo(t.getLogin());
    }
}
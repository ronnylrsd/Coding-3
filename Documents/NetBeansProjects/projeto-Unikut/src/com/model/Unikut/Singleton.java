package com.model.Unikut;

import java.util.LinkedList;

public class Singleton {

    private static Singleton instance;
    private LinkedList<Conta> rede;
    private LinkedList<String> mural;
    private String login, senha;

    private Singleton() {//cria a lista
        rede = new LinkedList<>();
        mural = new LinkedList<>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public static void setInstance(Singleton instance) {
        Singleton.instance = instance;
    }

    public LinkedList<Conta> getRede() {
        return rede;
    }

    public void setRede(LinkedList<Conta> rede) {
        this.rede = rede;
    }

    public LinkedList<String> getMural() {
        return mural;
    }

    public void setMural(LinkedList<String> mural) {
        this.mural = mural;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Conta buscaSimples(String log, String sen) {
        for (Conta c : rede) {
            if (c.getLogin().compareTo(log) == 0 && c.getSenha().compareTo(sen) == 0) {
                return c;
            }
        }
        return null;
    }

    public boolean Entrar(String log, String sen) {  // adicionar exception
        Conta Usuario = buscaSimples(log, sen);
        if (Usuario != null && Usuario.getSenha().compareTo(sen) == 0) {
            if (!log.contains(".adm")) {
                this.login = log;
                this.senha = sen;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean EntrarAdm(String log, String sen) {  // adicionar exception
        Conta Usuario = buscaSimples(log, sen);
        if (Usuario != null && Usuario.getSenha().compareTo(sen) == 0) {
            if (log.contains(".adm")) {
                this.login = log;
                this.senha = sen;
                return true;

            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean Cadastrar(String log, String sen, String n) {
        Conta busca = buscaSimples(log, sen);
        if (busca == null && !log.contains(".adm")) {
            Conta usuario = new Conta(log, sen, n);
            rede.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    public boolean CadastrarAdm(String log, String sen) {
        Conta busca = buscaSimples(log, sen);
        if (busca == null && !log.contains(".adm")) {
            ContaAdministradora adm = new ContaAdministradora(log, sen);
            rede.add(adm);
            return true;
        } else {
            return false;
        }
    }

    public boolean alteraPerfil(int resp, String mudanca) {
        Conta result;
        result = buscaSimples(login, senha);
        if (result == null) {
            return false;
        } else {
            result.alterarDados(result, mudanca, resp);
            return true;
        }
    }

    public LinkedList ListaDeAmigos() {
        Conta Usuario = buscaSimples(login, senha);
        return Usuario.listaAmigos();

    }

    public void alteraNome(String nome) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setNome(nome);

    }

    public void alteraSenha(String sen) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setSenha(sen);
    }

    public void alteraIdade(String id) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setIdade(id);
    }

    public void alteraSexo(String sex) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setSexo(sex);
    }

    public void alteraAniversario(String aniver) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setAniversario(aniver);
    }

    public void alteraEstadoCivil(String est) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setEstadoCivil(est);
    }

    public boolean adicionarAmigos(String log) {
        Conta Usuario = buscaSimples(login, senha);
        Conta Amigo = buscaSimples(log, "");
        return Usuario.adicionaAmigos(Amigo);

    }

    public boolean alteraStatus(String log) {
        Conta Usuario = buscaSimples(login, senha);
        Conta Amigo = buscaSimples(log, "");
        return Usuario.alteraStatusAmigos(Amigo);

    }

    public boolean modelEnviarRecado(String log, String recado) {
        Conta destinatario = buscaSimples(log, "");
        return destinatario.adicionaRecado(login, recado);
    }

    public boolean modelEnviarRecadoSecreto(String log, String recado, String sen) {
        Conta destinatario = buscaSimples(log, "");
        return destinatario.adicionaRecadoComSenha(login, recado, sen);
    }

    public boolean modelEnviarRecadoMural(String recado) {
        String status = "Pendente";
        return mural.add(login + ": " + recado + " (" + status + ").");
    }

    public LinkedList modelVisualizarRecadoMuralPendente() {
        LinkedList recadoMuralPendente = new LinkedList();
        for (int i = 0; i < mural.size(); i++) {
            if (mural.get(i).contains("Pendente")) {
                recadoMuralPendente.add(mural.get(i));
            }
        }
        return recadoMuralPendente;
    }

    public void modelRecadoMuralAceito(String recado) {
        for (int i = 0; i < mural.size(); i++) {
            if (mural.get(i).compareTo(recado) == 0) {
                mural.add(i, mural.get(i).replace("Pendente", ""));
            }
        }
    }

    public LinkedList modelVisualizarRecados() {
        Conta usuario = buscaSimples(login, senha);
        LinkedList lista = usuario.listaRecados();
        return lista;
    }

    public LinkedList modelVisualizarRecadoSecreto(String sen) {
        Conta usuario = buscaSimples(login, senha);
        LinkedList lista = usuario.listaRecadosComSenha(sen);
        return lista;
    }

    public LinkedList modelVisualizarRecadosMural() {
        LinkedList recadoMuralAceito = new LinkedList();
        for (int i = 0; i < mural.size(); i++) {
            if (!mural.get(i).contains("Pendente")) {
                recadoMuralAceito.add(mural.get(i));
            }
        }
        return recadoMuralAceito;
    }

    public void ArmazenarMatch(String log) {
        Conta Usuario = buscaSimples(login, "");
        Conta Match = buscaSimples(log, "");

        if (Match.getMatch().contains(Usuario)) {
            Usuario.AdicionarMatch(Match, "Match");
            Match.AlterarStatus(Match);

        } else {
            Usuario.AdicionarMatch(Match, " ");
        }

    }

    public LinkedList VerMatch() {
        Conta Usuario = buscaSimples(login, "");
        return Usuario.getMatch();

    }

    public boolean modelRemoveConta(String log) {
        Conta usuario = buscaSimples(log, "");
        return rede.remove(usuario);
    }

    public void modelAlteraNomeAdm(String log, String nome) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setNome(nome);

    }

    public void modelAlteraSenhaAdm(String log, String sen) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setSenha(sen);
    }

    public void modelAlteraIdadeAdm(String log, String id) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setIdade(id);
    }

    public void modelAlteraSexoAdm(String log, String sex) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setSexo(sex);
    }

    public void modelAlteraAniversarioAdm(String log, String aniver) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setAniversario(aniver);
    }

    public void modelAlteraEstadoCivilAdm(String log, String est) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setEstadoCivil(est);
    }

    public String modelExibeConta(String log) {
        ContaAdministradora administrador = (ContaAdministradora) buscaSimples(login, senha);
        Conta Usuario = buscaSimples(log, "");
        return administrador.exibeContaAdm(Usuario);
    }

}

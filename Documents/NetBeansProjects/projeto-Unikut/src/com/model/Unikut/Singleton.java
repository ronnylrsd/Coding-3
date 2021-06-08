package com.model.Unikut;

import java.util.LinkedList;

public class Singleton {

    private static Singleton instance;
    private LinkedList<Conta> rede;
    private LinkedList<String> muralPendente, mural;
    private String login, senha;

    public LinkedList<String> getMuralPendente() {
        return muralPendente;
    }

    public void setMuralPendente(LinkedList<String> muralPendente) {
        this.muralPendente = muralPendente;
    }

    private Singleton() {//cria a lista
        rede = new LinkedList<>();
        muralPendente = new LinkedList();
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

    public Conta busca(String log) {
        for (Conta c : rede) {
            if (c.getLogin().compareTo(log) == 0) {
                return c;
            }
        }
        return null;
    }

    public boolean modelBusca(String log) {
        return rede.stream().anyMatch((c) -> (c.getLogin().compareTo(log) == 0));
    }

    public boolean modelEntrar(String log, String sen) {  // adicionar exception
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

    public boolean modelEntrarAdm(String log, String sen) {  // adicionar exception
        ContaAdministradora Usuario = (ContaAdministradora) buscaSimples(log, sen);
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

    public boolean modelCadastrar(String log, String sen, String n) {
        Conta busca = buscaSimples(log, sen);
        if (busca == null && !log.contains(".adm")) {
            ContaUsuario usuario = (ContaUsuario) ContaFactory.getConta(log,sen,n);
            rede.add(usuario);
            return true;
        } else {
            return false;
        }
    }

    public boolean modelCadastrarAdm(String log, String sen) {
        Conta busca = buscaSimples(log, sen);
        if (busca == null && log.contains(".adm")) {
            ContaAdministradora adm = (ContaAdministradora) ContaFactory.getConta(log,sen,"");
            rede.add(adm); 
            return true;
        } else {
            return false;
        }
    }

    public void modelAlteraNome(String nome) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setNome(nome);
    }

    public void modelAlteraSenha(String sen) {
        Conta Usuario = buscaSimples(login, senha);
        Usuario.setSenha(sen);
    }

    public void modelAlteraIdade(String id) {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        Usuario.setIdade(id);
    }

    public void modelAlteraSexo(String sex) {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        Usuario.setSexo(sex);
    }

    public void modelAlteraAniversario(String aniver) {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        Usuario.setAniversario(aniver);
    }

    public void modelAlteraEstadoCivil(String est) {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        Usuario.setEstadoCivil(est);
    }

    public void modelAdicionarAmigo(int index) {
        ContaUsuario usuario = (ContaUsuario) buscaSimples(login, senha);
        String log;
        log = usuario.AdicionarAmigo(index);
        ContaUsuario Amigo = (ContaUsuario) busca(log);
        Amigo.getAmigos().add(login);
    }

    public boolean modelAdicionarSitucao(String log) {
        ContaUsuario Situacao = (ContaUsuario) busca(log);
        if (login.compareTo(log) == 0) {
            return false;
        } else {
            return Situacao.AdicionaSolicitacao(login);
        }
    }

    public LinkedList modelVisualizarAmigos() {
        ContaUsuario usuario = (ContaUsuario) buscaSimples(login, senha);
        LinkedList lista = usuario.listaAmigos();
        return lista;
    }

    public LinkedList modelVisualizarAmigosPendentes() {
        ContaUsuario usuario = (ContaUsuario) buscaSimples(login, senha);
        return usuario.getSolicitacoes();
    }

    public boolean modelEnviarRecado(String log, String recado) {
        ContaUsuario destinatario = (ContaUsuario) busca(log);
        return destinatario.adicionaRecado(login, recado);
    }

    public boolean modelEnviarRecadoSecreto(String log, String recado, String sen) {
        ContaUsuario destinatario = (ContaUsuario) busca(log);
        return destinatario.adicionaRecadoComSenha(login, recado, sen);
    }

    public boolean modelEnviarRecadoMural(String recado, String destinatario) {
        String remetente = login;
        return muralPendente.add(remetente + ", mandou: " + recado);
    }

    public LinkedList modelVisualizarRecadoMuralPendente() {
        return muralPendente;
    }

    public boolean modelRecadoMuralAceito(int index) {
        String msg;
        msg = muralPendente.get(index);
        if (msg.contains(login) == true) {
            return false;
        } else {
            mural.add(msg + " para: " + login + ".");
            return true;
        }
    }

    public LinkedList modelVisualizarRecados() {
        ContaUsuario usuario = (ContaUsuario) buscaSimples(login, senha);
        LinkedList lista = usuario.listaRecados();
        return lista;
    }

    public LinkedList modelVisualizarRecadoSecreto(String sen) {
        ContaUsuario usuario = (ContaUsuario) buscaSimples(login, senha);
        return usuario.listaRecadosComSenha(sen);
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

    public void modelArmazenarMatch(String log) {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        ContaUsuario Match = (ContaUsuario) busca(log);
        if (Match.getMatch().contains(login + ": PENDENTE")) {
            Usuario.AdicionarMatch(log, "Match");
            Match.AlteraMatch(login);

        } else {
            Usuario.AdicionarMatch(log, "");
        }

    }

    public LinkedList modelVerMatch() {
        ContaUsuario Usuario = (ContaUsuario) buscaSimples(login, senha);
        return Usuario.getMatch();

    }

    public boolean modelRemoveConta(String log) {
        Conta usuario = busca(log);
        return rede.remove(usuario);
    }

    public void modelAlterarConta(String log, char resp, String mud) {
        ContaUsuario Usuario = (ContaUsuario) busca(log);
        Usuario.alterarDadosAdm(resp, mud);
    }

    public String modelExibeConta(String log) {
        ContaUsuario Usuario = (ContaUsuario) busca(log);
        String l = "Login: " + Usuario.getLogin() + ".", nom, idd, sex, ani, estC;
        if (Usuario.getNome().compareTo("convidado") == 0) {
            nom = "Nome: convidado.";
        } else {
            nom = "Nome: " + Usuario.getNome();
        }
        if (Usuario.getIdade() == null) {
            idd = "Idade ainda não informada.";
        } else {
            idd = "Idade: " + Usuario.getIdade();
        }
        if (Usuario.getSexo() == null) {
            sex = "Sexo ainda não informado.";
        } else {
            sex = "Sexo: " + Usuario.getSexo();
        }
        if (Usuario.getAniversario() == null) {
            ani = "Aniversario ainda não informado.";
        } else {
            ani = "Aniversário: " + Usuario.getAniversario();
        }
        if (Usuario.getEstadoCivil() == null) {
            estC = "Estado civil ainda não informado.";
        } else {
            estC = "Estado Civil: " + Usuario.getEstadoCivil();
        }
        return l + " " + nom + " " + idd + " " + sex + " " + ani + " " + estC;
    }

}

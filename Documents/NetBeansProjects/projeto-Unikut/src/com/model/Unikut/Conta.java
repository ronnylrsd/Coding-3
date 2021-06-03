package com.model.Unikut;

import java.util.Collections;
import java.util.LinkedList;

public class Conta implements Comparable<Conta> {

    private String login;
    private String senha;
    private String nome;
    private String idade;
    private String sexo;
    private String aniversario;
    private String estadoCivil;
    private String status;
    private LinkedList<Conta> amigos;
    private LinkedList<String> recados;
    private LinkedList<Conta> Match;
    private String situacao;
    private String senhaRecado;
    private LinkedList<String> Recadocomsenha;

    public Conta(String log, String senha) {
        this.login = log;
        this.senha = senha;
        this.nome = "convidado";
        this.amigos = new LinkedList<>();
        this.status = "pendente";
        this.recados = new LinkedList<>();
        this.Match = new LinkedList();
        this.situacao = "espera";

        this.Recadocomsenha = new LinkedList<>();

    }

    public Conta(String log, String senha, String nome) {
        this.login = log;
        this.senha = senha;
        this.nome = nome;
        this.amigos = new LinkedList();
        this.recados = new LinkedList<>();

        this.Recadocomsenha = new LinkedList<>();
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
        this.Recadocomsenha = new LinkedList<>();
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

    public String getIdade() {
        return idade;
    }

    public void setIdade(String idade) {
        this.idade = idade;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
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

    public String getsenhaRecado() {
        return senhaRecado;
    }

    public void setsenhaRecado(String senhaRecado) {
        this.senhaRecado = senhaRecado;
    }

    public LinkedList<String> getRecadocomsenha() {
        return Recadocomsenha;
    }

    public void setRecadocomsenha(LinkedList<String> Recadocomsenha) {
        this.Recadocomsenha = Recadocomsenha;
    }

    public void alterarDados(Conta result, String info, int resp) {

        switch (resp) {
            case 1:
                result.setNome(info);
                break;
            case 2:
                result.setSenha(info);
                break;
            case 3:
                result.setIdade(info);
                break;
            case 4:
                result.setSexo(info);
                break;
            case 5:
                result.setAniversario(info);

                break;
            case 6:
                result.setEstadoCivil(info);
                break;
        }
    }

    protected Conta buscaAmigos(Conta ct) {
        for (Conta c : amigos) {
            if (c.getLogin().compareTo(ct.getLogin()) == 0 && c.getSenha().compareTo(ct.getSenha()) == 0) {
                return c;
            }
        }
        return null;
    }

    public void adicionaAmigos(Conta usuario, Conta amigo) {
        this.amigos.add(amigo);
        amigo.amigos.add(usuario);
    }

    public LinkedList listaAmigos() {
        if (amigos.isEmpty()) {
            return null;
        } else {
            return amigos;
        }
    }

    public boolean alteraStatusAmigos(Conta result) {
        Conta amigo = buscaAmigos(result);
        if (amigo != null) {
            if (amigo.getStatus().equalsIgnoreCase("pendente")) {
                amigo.setStatus();
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean adicionaRecado(String lg, String recado) {
        return recados.add(lg + ": " + recado);
    }

    public boolean adicionaRecadoComSenha(String lg, String recado, String senha1) {
        setsenhaRecado(senha1);
        return Recadocomsenha.add(lg + ": " + recado);
    }

    public LinkedList listaRecados() {
        if (recados.isEmpty()) {
            return null;
        } else {
            return recados;
        }
    }

    public LinkedList listaRecadosComSenha(String senha2) {
        String SenhaReal = getsenhaRecado();
        if (SenhaReal.equals(senha2)) {
            if (Recadocomsenha.isEmpty()) {
                return null;
            } else {
                return Recadocomsenha;
            }
        } else {
            return null;
        }
    }

    public boolean AdicionarMatch(Conta passada, String flag) {
        if (this.Match.contains(passada)) {
            return false;
        } else if (flag.equals("Match")) {
            passada.setSituacao();// mudou para Match
            this.Match.add(passada);
            return true;
        } else {
            this.Match.add(passada);
            return true;
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

    public LinkedList ExibirMatch() {
        if (this.Match.isEmpty()) {
            return null;
        } else {
            return Match;
        }
    }

    public String ImprimeInformacoesConta() {
        return this.login + " " + this.nome + " " + this.idade + " " + this.sexo + " " + this.aniversario + " " + this.estadoCivil;
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

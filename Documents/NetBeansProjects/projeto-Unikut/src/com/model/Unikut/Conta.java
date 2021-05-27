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
    private LinkedList<String> MuralRecado;

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

    public void adicionaRecadoComSenha(String lg, String recado, String senha1) {
        Recadocomsenha.add(lg + ": " + recado);
        setsenhaRecado(senha1);
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

    public void adicionaAmigos(Conta result) throws AmigoJaAdicionadoException {
        Conta conta = new Conta(login, senha);
        if (buscaSimples(result) == null) {
            this.amigos.add(result);
            result.amigos.add(conta);
        } else {
            throw new AmigoJaAdicionadoException();
        }
    }

    public LinkedList listaAmigos() {
        if (amigos.isEmpty()) {
            return null;
        } else {
            return amigos;
        }
    }

    protected Conta buscaSimples(Conta ct) {
        Collections.sort(amigos);
        int index = Collections.binarySearch(amigos, ct);
        if (index < 0) {
            return null;
        } else {
            return amigos.get(index);
        }
    }

    public void alteraStatusAmigos(Conta result) throws SolicitacaoJaEnviadaException, AmigoContaNaoExistenteException {
        Conta amigo = buscaSimples(result);
        if (amigo != null) {
            if (amigo.getStatus().equalsIgnoreCase("pendente")) {
                amigo.setStatus();
            } else {
                throw new SolicitacaoJaEnviadaException();
            }
        } else {
            throw new AmigoContaNaoExistenteException();
        }
    }

    public void adicionaRecado(String lg, String recado) {
        recados.add(lg + ": " + recado);
    }

    public void adicionaRecadoMural(String lg, String recado) {
        MuralRecado.add(lg + ": " + recado);
    }

    public LinkedList listaRecadosMural() {
        if (MuralRecado.isEmpty()) {
            return null;
        } else {
            return MuralRecado;
        }
    }

    public LinkedList listaRecados() {
        if (recados.isEmpty()) {
            return null;
        } else {
            return recados;
        }
    }

    public void AdicionarMatch(Conta passada, String flag) throws AmigoJaAdicionadoException {

        if (this.Match.contains(passada)) {
          throw new AmigoJaAdicionadoException();
        } else if (flag.equals("Match")) {
            passada.setSituacao();// mudou para Match
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

    public LinkedList ExibirMatch() {
        if (this.Match.isEmpty()) {
            return null;
        } else {
            return Match;
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

    @Override
    public String toString() {
        return this.login + " " + this.status;
    }

    @Override
    public int compareTo(Conta t) {
        return this.login.compareTo(t.getLogin());
    }
}
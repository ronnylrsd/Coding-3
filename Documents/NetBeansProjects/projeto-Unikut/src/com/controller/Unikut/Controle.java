
package com.controller.Unikut;


import com.model.Unikut.Conta;
import com.model.Unikut.ContaAdministradora;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class Controle {

    protected LinkedList<Conta> usuariosCadastrados;
    private String login;
    private String senha;

    public LinkedList getUsuariosCadastrados() {
        return usuariosCadastrados;
    }

    public void setUsuariosCadastrados(LinkedList usuariosCadastrados) {
        this.usuariosCadastrados = usuariosCadastrados;
    }

    public Controle() {//criar a lista
        usuariosCadastrados = new LinkedList<>();
    }

    protected Conta buscaSimples(Conta ct) {
        Collections.sort(usuariosCadastrados);
        int index = Collections.binarySearch(usuariosCadastrados, ct);
        if (index < 0) {
            return null;
        } else {
            return usuariosCadastrados.get(index);
        }
    }

    public boolean Entrar(String log, String sen) {
        Conta ctt = new Conta(log, sen);
        Conta busca = buscaSimples(ctt);
        if (busca != null && busca.getSenha().compareTo(sen) == 0) {
            if (log.contains(".adm")) {
                return true;//1
            } else {
                return true;//0
            }
        } else if (busca != null && busca.getSenha().compareTo(sen) != 0) {
            return false;//-2
        }
        return false;//-1
    }

    public boolean Cadastrar(String log, String sen, String nome) {
        Conta busca = new Conta(log);
        Conta aux = buscaSimples(busca);
        if (aux != null) {
            return false;
        } else {
            if (log.contains(".adm")) {
                ContaAdministradora adm = new ContaAdministradora(log, sen);
                usuariosCadastrados.add(adm);
            } else {
                Conta usuario = new Conta(log, sen, nome);
                usuariosCadastrados.add(usuario);
            }
            return true;
        }

    }

    public boolean alteraPerfil(int resp, String mudanca) {
        Conta result;
        Conta ctt = new Conta(login, senha);
        result = buscaSimples(ctt);
        if (result == null) {
            return false;
        } else {
            result.alterarDados(result, mudanca, resp);
            return true;
        }
    }

    public boolean adicionarAmigos(String log) {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        Conta result;
        Conta ctt = new Conta(log);
        result = buscaSimples(ctt);
        if (result == null) {
            return false;
        } else {
            busca.adicionaAmigos(result);
            return true;
        }

    }

    public LinkedList listadeAmigos() {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        LinkedList lista = busca.listaAmigos();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }

    }

    public boolean alteraStatus(String log) {
        Conta ctt = new Conta(login, senha);
        Conta resultado = buscaSimples(ctt);
        Conta usuario = new Conta(log);
        Conta busca = buscaSimples(usuario);
        if (busca == null) {
            return false;
        } else {
            ctt.AlterarStatus(usuario);
            return true;
        }
    }

    public boolean adicionaMatch(String log) {
        Conta ctt = new Conta(login, senha);
        Conta conta = buscaSimples(ctt);
        Conta descartavel = new Conta(log); // criando uma conta apenas para inicializar com o login passado
        Conta Armazenar = buscaSimples(descartavel);
        if (!usuariosCadastrados.contains(Armazenar)) {
            return false;
        } else {
            if (Armazenar.getMatch().contains(conta)) {// se a conta que eu quero adicionar possui a minha conta nos matchs
                conta.AdicionarMatch(Armazenar, "Match"); // irei usar o recurso adicionar na minha 
                Armazenar.AlterarStatus(conta);
            } else {
                conta.AdicionarMatch(Armazenar, " ");
            }
            return true;
        }
    }

    public LinkedList exibirMatch() {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        LinkedList lista = busca.ExibirMatch();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

    public boolean enviarRecado(String log, String recado) {
        Conta usuario = new Conta(log);
        Conta busca = buscaSimples(usuario);
        if (busca == null) {
            return false;
        } else {
            busca.adicionaRecado(login, recado);
            return true;
        }
    }

    public boolean enviarRecadoSecreto(String log, String recado, String sen) {
        Conta usuario = new Conta(log);
        Conta busca = buscaSimples(usuario);
        if (busca == null) {
            return false;
        } else {
            busca.adicionaRecadoComSenha(login, recado, sen);
            return true;
        }
    }

    public LinkedList visualizarRecado() {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        LinkedList lista = busca.listaRecados();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

    public LinkedList visualizarRecadoSecreto(String sen) {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        LinkedList lista = busca.listaRecadosComSenha(sen);
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

    public boolean muralRecados(String log, String recado) {
        Conta usuario = new Conta(log);
        Conta busca = buscaSimples(usuario);
        if (busca == null) {
            return false;
        } else {
            busca.adicionaRecadoMural(login, recado);
            return true;
        }
    }

    public LinkedList visualizarMuralRecados() {
        Conta usuario = new Conta(login, senha);
        Conta busca = buscaSimples(usuario);
        LinkedList lista = busca.listaRecadosMural();
        if (lista == null) {
            return null;
        } else {
            return lista;
        }
    }

}
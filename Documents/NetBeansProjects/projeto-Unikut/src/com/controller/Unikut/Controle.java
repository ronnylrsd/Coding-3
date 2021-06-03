package com.controller.Unikut;

import com.model.Unikut.Singleton;
import java.util.LinkedList;

public class Controle {

    Singleton s = Singleton.getInstance();

    public boolean VerificarConta(String log, String sen) {
        return s.buscaSimples(log, sen) != null && log.contains(".adm") == false;
    }
    
    public boolean controllerVerificar(String log) {
        return s.modelBusca(log);
    }

    public boolean VerificarContaAdm(String log, String sen) {
        return s.buscaSimples(log, sen) != null && log.contains(".adm") == true;
    }

    public boolean Entrar(String log, String sen) {
        return s.Entrar(log, sen);
    }

    public boolean EntrarAdm(String log, String sen) {
        return s.EntrarAdm(log, sen);
    }

    public boolean Cadastrar(String log, String sen,String nom) {
        return s.Cadastrar(log, sen, nom);
    }

    public boolean CadastrarAdm(String log, String sen) {
        return s.CadastrarAdm(log, sen);
    }

    public void alteraPerfil(int resp, String mudanca) {

        switch (resp) {
            case 1:
                s.alteraNome(mudanca);
                break;
            case 2:
                s.alteraSenha(mudanca);
                break;
            case 3:
                s.alteraIdade(mudanca);
                break;
            case 4:
                s.alteraSexo(mudanca);
                break;
            case 5:
                s.alteraAniversario(mudanca);
                break;
            case 6:
                s.alteraEstadoCivil(mudanca);
                break;
        }

    }

    public boolean AdicionarAmigo(String log) {
        return s.adicionarAmigos(log);
    }

    public LinkedList ControlListaAmigos() {
        return s.ListaDeAmigos();

    }

    public boolean StatusDeAmigos(String l) {
        return s.alteraStatus(l);

    }

    public boolean controllerEnviarRecado(String log, String recado) {
        return s.modelEnviarRecado(log, recado);
    }

    public boolean controllerEnviarRecadoSecreto(String log, String recado, String sen) {
        return s.modelEnviarRecadoSecreto(log, recado, sen);
    }

    public boolean controllerEnviarRecadoMural(String msg) {
        return s.modelEnviarRecadoMural(msg);
    }

    public LinkedList controllerVisualizarRecadosMuralPedente() {
        return s.modelVisualizarRecadoMuralPendente();
    }

    public void controllerRecadosMuralAceito(String recado) {
        s.modelRecadoMuralAceito(recado);
    }

    public LinkedList controllerVisualizarRecados() {
        return s.modelVisualizarRecados();
    }

    public LinkedList controllerVisualizarRecadoSecreto(String sen) {
        return s.modelVisualizarRecadoSecreto(sen);
    }

    public LinkedList controllerVisualizarMuralRecados() {
        return s.modelVisualizarRecadosMural();
    }

    public void Match(String log) {
        s.ArmazenarMatch(log);
    }

    public LinkedList VerMeusMatchs() {
        return s.VerMatch();
    }

    public boolean controllerRemoveConta(String lg) {
        return s.modelRemoveConta(lg);
    }

    public void controllerAlteraPerfilAdm(String lg, int resp, String mudanca) {
        switch (resp) {
            case 1:
                s.modelAlteraNomeAdm(lg, mudanca);
                break;
            case 2:
                s.modelAlteraSenhaAdm(lg, mudanca);
                break;
            case 3:
                s.modelAlteraIdadeAdm(lg, mudanca);
                break;
            case 4:
                s.modelAlteraSexoAdm(lg, mudanca);
                break;
            case 5:
                s.modelAlteraAniversarioAdm(lg, mudanca);
                break;
            case 6:
                s.modelAlteraEstadoCivilAdm(lg, mudanca);
                break;
        }
    }

    public String controllerExibeConta(String lg) {
        return s.modelExibeConta(lg);
    }

}

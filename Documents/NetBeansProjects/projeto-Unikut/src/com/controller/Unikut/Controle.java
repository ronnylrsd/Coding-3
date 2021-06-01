
package com.controller.Unikut;



import com.model.Unikut.Singleton;
import java.util.LinkedList;

public class Controle {

    Singleton s = Singleton.getInstance();

    public boolean VerificarConta(String log, String sen) {
        return s.buscaSimples(log, sen) != null && log.contains(".adm") == false;
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

    public boolean Cadastrar(String log, String sen) {
        s.Cadastrar(log, sen);
        return true;
    }

    public boolean CadastrarAdm(String log, String sen) {
        s.CadastrarAdm(log, sen);
        return true;
    }

    public boolean AdicionarAmigo(String log) {
        return s.adicionarAmigos(log);

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

    public LinkedList ControlListaAmigos() {

        return s.ListaDeAmigos();

    }

    public boolean StatusDeAmigos(String l) {
        return s.alteraStatus(l);

    }

    public boolean adicionarAmigos(String log) {

    }

    public LinkedList listadeAmigos() {

    }

    public boolean alteraStatus(String log) {

    }

    public boolean adicionaMatch(String log) {

    }

    public LinkedList exibirMatch() {

    }

    public boolean enviarRecado(String log, String recado) {

    }

    public boolean enviarRecadoSecreto(String log, String recado, String sen) {

    }

    public LinkedList visualizarRecado() {

    }

    public LinkedList visualizarRecadoSecreto(String sen) {

    }

    public boolean muralRecados(String log, String recado) {

    }

    public LinkedList visualizarMuralRecados() {

    }

    public boolean controllerRemoveConta(String lg) {
        return s.modelRemoveConta(lg);
    }

    public void controllerAlteraPerfilAdm(String lg,int resp,String mudanca) {
        switch (resp) {
            case 1:
                s.modelAlteraNomeAdm(lg,mudanca);
                break;
            case 2:
                s.modelAlteraSenhaAdm(lg,mudanca);
                break;
            case 3:
                s.modelAlteraIdadeAdm(lg,mudanca);
                break;
            case 4:
                s.modelAlteraSexoAdm(lg,mudanca);
                break;
            case 5:
                s.modelAlteraAniversarioAdm(lg,mudanca);
                break;
            case 6:
                s.modelAlteraEstadoCivilAdm(lg,mudanca);
                break;
        }
    }

    public String controllerExibeConta(String lg) {
        return s.modelExibeConta(lg);
    }

}
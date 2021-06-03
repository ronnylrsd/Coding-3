package com.controller.Unikut;

import com.model.Unikut.Singleton;
import java.util.LinkedList;

public class Controle {

    Singleton s = Singleton.getInstance();

    public boolean controllerVerificarConta(String log, String sen) {
        return s.buscaSimples(log, sen) != null && log.contains(".adm") == false;
    }
    
    public boolean controllerVerificar(String log) {
        return s.modelBusca(log) && log.contains(".adm") == false;
    }

    public boolean controllerVerificarContaAdm(String log, String sen) {
        return s.buscaSimples(log, sen) != null && log.contains(".adm") == true;
    }

    public boolean controllerEntrar(String log, String sen) {
        return s.modelEntrar(log, sen);
    }

    public boolean controllerEntrarAdm(String log, String sen) {
        return s.modelEntrarAdm(log, sen);
    }

    public boolean controllerCadastrar(String log, String sen,String nom) {
        return s.modelCadastrar(log, sen, nom);
    }

    public boolean controllerCadastrarAdm(String log, String sen) {
        return s.modelCadastrarAdm(log, sen);
    }

    public void controllerAlteraPerfil(int resp, String mudanca) {

        switch (resp) {
            case 1:
                s.modelAlteraNome(mudanca);
                break;
            case 2:
                s.modelAlteraSenha(mudanca);
                break;
            case 3:
                s.modelAlteraIdade(mudanca);
                break;
            case 4:
                s.modelAlteraSexo(mudanca);
                break;
            case 5:
                s.modelAlteraAniversario(mudanca);
                break;
            case 6:
                s.modelAlteraEstadoCivil(mudanca);
                break;
        }

    }

    public void controllerAdicionarAmigo(int index){
        s.modelAdicionarAmigo(index);
    }
    
    public boolean controllerAdicionarSituacao(String login){
       return s.modelAdicionarSitucao(login); 
    }
    
    public LinkedList controllerVisualizarAmigos() {
        return s.modelVisualizarAmigos();
    }

    public LinkedList controllerVisualizarAmigosPedentes() {
        return s.modelVisualizarAmigosPendentes();
    }

    public boolean controllerEnviarRecado(String log, String recado) {
        return s.modelEnviarRecado(log, recado);
    }

    public boolean controllerEnviarRecadoSecreto(String log, String recado, String sen) {
        return s.modelEnviarRecadoSecreto(log, recado, sen);
    }

    public boolean controllerEnviarRecadoMural(String msg,String dest) {
        return s.modelEnviarRecadoMural(msg,dest);
    }

    public LinkedList controllerVisualizarRecadosMuralPedente() {
        return s.modelVisualizarRecadoMuralPendente();
    }

    public boolean controllerRecadosMuralAceito(int index) {
        return s.modelRecadoMuralAceito(index);
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

    public void controllerMatch(String log) {
        s.modelArmazenarMatch(log);
    }

    public LinkedList controllerVerMeusMatchs() {
        return s.modelVerMatch();
    }

    public boolean controllerRemoveConta(String lg) {
        return s.modelRemoveConta(lg);
    }

    public void controllerAlteraPerfilAdm(String lg, char resp, String mudanca) {
        s.modelAlterarConta(lg, resp, mudanca);
    } 

    public String controllerExibeConta(String lg) {
        return s.modelExibeConta(lg);
    }

}

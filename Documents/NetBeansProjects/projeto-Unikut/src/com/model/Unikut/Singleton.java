
package com.model.Unikut;



import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Singleton {

    private static Singleton instance;
    private List<Conta> rede;
    private List<String> mural;
    String login, senha;

    private Singleton() {
        rede = new LinkedList<Conta>();
        mural = new LinkedList<String>();
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;

    }

    public Conta buscaSimples(String login, String sen) {
        Conta ct = new Conta(login, sen);
        Collections.sort(rede);
        int index = Collections.binarySearch(rede, ct);
        if (index < 0) {
            return null;
        } else {
            return rede.get(index);
        }
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
        Conta Usuario = buscaSimples (log, sen);
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

    public boolean Cadastrar(String log, String sen) {
        Conta busca = buscaSimples(log,sen);
        if (busca != null && !log.contains(".adm")) {
            Conta usuario = new Conta(log, sen);
            rede.add(usuario);
            return true;
        } else {
            return false;
        }
    }
    
    public boolean CadastrarAdm(String log, String sen) {
        Conta busca = buscaSimples(log,sen);
        if (busca != null && !log.contains(".adm")) {
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
    
    public boolean modelRemoveConta(String log){
        Conta usuario = buscaSimples(log,"");
        return rede.remove(usuario);     
    }
    
    public void modelAlteraNomeAdm(String log,String nome) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setNome(nome);

    }

    public void modelAlteraSenhaAdm(String log,String sen) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setSenha(sen);
    }

    public void modelAlteraIdadeAdm(String log,String id) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setIdade(id);
    }

    public void modelAlteraSexoAdm(String log,String sex) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setSexo(sex);
    }

    public void modelAlteraAniversarioAdm(String log,String aniver) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setAniversario(aniver);
    }

    public void modelAlteraEstadoCivilAdm(String log,String est) {
        Conta Usuario = buscaSimples(log, "");
        Usuario.setEstadoCivil(est);
    }
    
    public String modelExibeConta(String log){
        ContaAdministradora administrador = (ContaAdministradora) buscaSimples(login,senha);
        Conta Usuario = buscaSimples(log, "");
        return administrador.exibeContaAdm(Usuario);
    }
    
   public void ArmazenarMatch(String log){
     Conta Usuario = buscaSimples(login, "");
     Conta Match = buscaSimples(log,"");
     
     if(Match.getMatch().contains(Usuario)){
         Usuario.AdicionarMatch(Match,"Match");
         Match.AlterarStatus(Match);
         
     }else{
        Usuario.AdicionarMatch(Match," ");
     }
         
       
   }
   public LinkedList VerMatch(){
      Conta Usuario = buscaSimples(login, ""); 
      return Usuario.getMatch();
    
  }
           
    
    
    
}

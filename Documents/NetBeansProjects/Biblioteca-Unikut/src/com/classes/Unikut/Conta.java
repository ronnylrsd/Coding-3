package com.classes.Unikut;
import java.util.Scanner;

public class Conta implements Comparable <Conta> {

 private String login;
 private String senha;
 private String nome;
 private int idade;
 private char sexo;
 private String aniversario;
 private String estadoCivil;
 
    public Conta(String log, String senha){ 
       this.login=log;
       this.senha=senha;
       this.nome="convidado";
    }
    
    public Conta(String log, String senha,String nome){
       this.login=log;
       this.senha=senha;
       this.nome=nome;
    }
    
    public Conta(String log){
        this.login = log;
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
    
    public String getLogin() {
        return login;
    }
    
    private void setLogin(String login){
        this.login = login;
    }
    
    public String getSenha() {
        return senha;
    }
    public void setSenha(String senha){
        this.senha = senha;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public void alterarDados (Conta result){
        int op;
        Scanner in = new Scanner (System.in);
        if(result == null){
            System.out.println("Conta não encontrada!");
        }
        else{
            System.out.println("Conta encotrada!");
            do{
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
                switch(op){
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
                    char ns= in.next().charAt(0);
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
            }while(op!=7);
        }
    }
    
    @Override
    public int compareTo(Conta t) {
       return this.login.compareTo(t.getLogin());
    }
}

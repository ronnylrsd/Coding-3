
package com.classes.Unikut;
import com.classes.classe.Unikut.LSESemRepetidos;
import com.classes.Unikut.Conta;
import java.util.Scanner;

public class CadastroConta {
    private LSESemRepetidos<Conta> dados;
    public CadastroConta(){//criar a lista
        dados = new LSESemRepetidos();
    }
    

   
    public void cadastrar (String cpf){
       Scanner in = new Scanner(System.in);
        
        Scanner input = new Scanner (System.in);
        Conta cliente = new Conta (cpf,"");
        if(dados.buscarObjeto(cliente)==null){
            System.out.println("Informe o nome do cliente:");
            String n = in.nextLine();
            System.out.println("Informe o telefone do cliente:");
            String t = in.nextLine();
            System.out.println("Informe o e-mail do cliente:");
            String e = in.nextLine();
           Conta cl = new Conta(cpf,n);
            dados.inserirValorFinal(cl);
        }
        else{
            System.out.println("Cliente já cadastrado.");
        }
    }
}

package projeto.unikut;
import java.util.Scanner;
import com.classes.Unikut.CadastroConta;
public class ProjetoUnikut { 
    public static void main(String[] args) {
        Scanner in = new Scanner (System.in);
        CadastroConta conta = new CadastroConta();
        int op;
        do{
            System.out.println("UNIKUT");
            loginOuCadastro();
            op = in.nextInt();
            switch(op){
                case 1:
                    boolean resultado = conta.entrar();
                    if(resultado == true){
                        int op2;
                        do{
                            System.out.println("Bem-vindo");
                            perfilOuAmigosOuRecados();
                            op2 = in.nextInt();
                            switch (op2){
                                case 1:
                                    System.out.println("Para alterar o perfil: Confirme.");
                                    System.out.println("Informe o login:");
                                    String login = in.nextLine();
                                    in.nextLine();
                                    System.out.println("Informe a senha:");
                                    String senha = in.nextLine();
                                    conta.alteraPerfil(login, senha);
                                    break;
                                case 2:
                                    conta.amigos();
                                    break;
                                case 3:
                                    conta.recados();
                                    break;
                                case 4:
                                    System.out.println("De volta ao menu inicial.");
                                    break;
                                default:
                                    System.out.println("Escolha inválida. Tente novamente.");
                                    break;
                            }
                        }while(op2!=4);
                    }
                    else{
                        System.out.println("Conta inexistente!");
                    }
                    break;
                case 2:
                    conta.cadastrar();
                    break;
                case 3:
                    System.out.println("Fim do programa.");
                    break;
                default:
                    System.out.println("Escolha inválida. Tente novamente.");
                    break;
            }
        }while(op != 3);

    }

    public static void loginOuCadastro (){
        System.out.println("Menu de opções:");
        System.out.println("1-Entrar na conta.");
        System.out.println("2-Cadastrar conta.");
        System.out.println("3-Encerrar o programa.");
        System.out.println("Escolha uma opção:");
    }
    
    public static void perfilOuAmigosOuRecados(){
        System.out.println("Menu de opções:");
        System.out.println("1-Alterar perfil.");
        System.out.println("2-Aba amigos.");
        System.out.println("3-Aba recados.");
        System.out.println("4-Sair do conta.");
        System.out.println("Escolha uma opção:");
    }
    
}
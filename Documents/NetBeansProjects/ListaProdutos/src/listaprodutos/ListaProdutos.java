
package listaprodutos;
import java.util.Scanner;
import br.unicap.c3.ed1.LseSemRepetidos; // importando lista sem repetidos
import br.unciap.c3.ed11.produto; // importando a classe produto

public class ListaProdutos {

    
    public static void main(String[] args) {
    LseSemRepetidos<produto> produtos = new LseSemRepetidos(); // criando uma lista de 
    Scanner input = new Scanner(System.in);
    int op,estoque;
    double preco;
    String cod,desc;
    produto prod; // inicializando um objeto produto
    
    do{
    System.out.println("[Escolha uma das opcoes abaixo]");     // menu para escolha
    System.out.println("1-Inserir um novo produto no inicio");    
    System.out.println("2-Inserir um novo produto no final");   
    System.out.println("3-Exibir todos os produtos da lista");
    System.out.println("4-Remover um produto no inicio da lista");
    System.out.println("5-Remover um produto no final da lista");    
    System.out.println("6-Procurar um produto através de seu codigo");
    System.out.println("7-Alterar os dados de um produto");   
    System.out.println("8-Encerrar o programa");    
        
     op=input.nextInt();   
        switch(op) {
        
            case 2: 
               System.out.println("Informe o cod do produto");
                   input.nextLine();   cod=input.nextLine();    
               prod = new produto(cod);// criando um objeto produto usando cod parar inserir na lista 
               System.out.println("Informe a descricao do produto");
               desc=input.nextLine(); 
               prod.setDesc(desc); // inserindo a desc no produto
               System.out.println("Informe o preco do produto");    
               preco=input.nextDouble(); input.nextLine();// limpando buffer
               prod.setPreco(preco); // inserindo o preco no produto
               System.out.println("informe a quantidade do produto no estoque");
               estoque=input.nextInt(); input.nextLine();
               prod.setEstoque(estoque);// inserindo por ultimo a quantidade no estoque
               produtos.inserirValorFinal(prod);// inserindo o objeto produto no final da lista sem repetidos
           break;
           
            case 1: // ainda a terminar 
                
                System.out.println("Informe o cod do produto");
               input.nextLine();  cod=input.nextLine();
               prod = new produto(cod);// criando um objeto produto usando cod parar inserir na lista 
               System.out.println("Informe a descricao do produto");
               desc=input.nextLine(); 
               prod.setDesc(desc); // inserindo a desc no produto
               System.out.println("Informe o preco do produto");    
               preco=input.nextDouble(); input.nextLine();// limpando buffer
               prod.setPreco(preco); // inserindo o preco no produto
               System.out.println("informe a quantidade do produto no estoque");
               estoque=input.nextInt(); input.nextLine();
               prod.setEstoque(estoque);// inserindo por ultimo a quantidade no estoque
                produtos.inserirValorInicio(prod);// inserindo o objeto produto na lista sem repetidos
                break; 
                
            case 3:
                produtos.exibirLista();
                break;
                
            case 4: 
                produtos.removerPrimeiro();
                break;
                
            case 5:
                produtos.removerUltimo();
                break;
                
            case 6:     
                
               System.out.println("Informe o codigo do produto para informarmos o valor");
              input.nextLine();  cod=input.nextLine();
               imprimirValorProduto(produtos,cod);
               
               break;
               
            case 7: 
                System.out.println("informe o codigo do produto para altera-lo");
                cod=input.nextLine();
                alterarValorProduto(produtos,cod);
                
                break;
                
            case 8: 
              System.out.println("obrigado por utilizar o programa");
              break;
              
            case 9: 
                
                
              
            default:
                
                System.out.println("opcao invalida , por favor insira uma opcao implementada");
    }
        
        
        
        
        
        
        
        
    }while(op!=8);
    
 
    
    }
   
    public static void imprimirValorProduto(LseSemRepetidos<produto> produtos ,String valor){
        
    produto prod,recebe;
    prod=new produto(valor);    
    recebe=produtos.buscarObjeto(prod);
    
    if(recebe == null){
        
        System.out.println("produto não inserido no cadastro ou codigo invalido");
    }else{
      System.out.println("O codigo do produto é: "+recebe.getCod());
      System.out.println("A sua descricao é : "+recebe.getDesc());
      System.out.println("O preco é "+recebe.getPreco());
       System.out.println("e seu numero no estoque é "+recebe.getEstoque());      
       
    }
      }
    
    
    
    public static void alterarValorProduto(LseSemRepetidos<produto> produtos ,String valor){
        
     produto prod,recebe;
     prod =new produto(valor);
     recebe= produtos.buscarObjeto(prod);
     
    if(recebe == null){
        
        System.out.println("produto não inserido no cadastro ou codigo invalido");
    }else{
    
        
    }
        
        
    }
        
        
        
        
    }
    
    
    
    
    
    


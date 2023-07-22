import java.util.Scanner;

public class Questao2g {
    
    public static String menu(){
        return "\nEscolha uma opção:\n"
        + "1 - Cadastrar produto\n"
        + "2 - Fazer pedido\n"
        + "3 - Inserir itens\n"
        + "4 - Imprimir pedidos\n" 
        + "0 - sair";
    }
    
    public static void main(String[] args) {
        
        Scanner teclado = new Scanner(System.in);
        
        final int NUM_PRODUTOS = 10; // tamanho do array produto
        Produto produtos[] = new Produto[NUM_PRODUTOS]; //criação do array produtos para ser possivel cadastrar produtos
        int contProduto=0; //Contador para ser possivel associar valores a todo o array produtos
        
        Pedido pedido = new Pedido("15/03/2023"); // criação de um objeto pedido

        System.out.println(menu());
        int op = teclado.nextInt();

        while (op!=0){
            switch (op){
                case 1:{ //cadastrar produtos
                    System.out.println("\nDigite o nome do produto");
                    String nome = teclado.next();
                    System.out.println("\nDigite o valor do produto");
                    double valor = teclado.nextDouble();
                    System.out.println("\nDigite a quantidade do produto");
                    int quantidade = teclado.nextInt();
                    
                    Produto p = new Produto (nome,valor,quantidade);
                    produtos[contProduto]=p;
                    contProduto++;
                    System.out.println("\nProduto cadastrado: \n"+p.imprimir()+"\n");
                    break;
                }
                case 2: { //fazer pedido
                    System.out.println("\nCódigo do produto | Nome ");
                    for (int c = 0; c < contProduto; c++ ) {
                        System.out.println(produtos[c].imprimir());
                    } // irá dizer todos os produtos cadastrados e seus códigos
                    
                    System.out.println("\nDigite o código do produto");
                    int codigo = teclado.nextInt();
                    
                    for (int i = 0; i < contProduto; i++) {
                        if (produtos[i].getCodigo() == codigo) { // condição para comparar o codigo escolhido com o codigo de cada produto
                            Item item = new Item (produtos[i]); // cria-se um item que passa o produto do codigo como parametro
                            
                            System.out.println("\nDigite o quantidade do produto");
                            int quantidade = teclado.nextInt();
                            
                            if (quantidade <= produtos[i].getQuantidade()) {                            
                                item.setQuantidade(quantidade); // configura a quantidade de itens de acordo com a quantidade escolhida
                                pedido.inserirItem(item); // faz um pedido inserindo o item escolhido
                                produtos[i].venderProduto(quantidade);
                                System.out.println("\nPedido realizado com sucesso");
                            } else {
                                System.out.println("\nNão temos " + produtos[i].getNome()+ " o suficiente, temos apenas: "+ produtos[i].getQuantidade()+" no estoque");
                            }
                        }
                    }
                    break;
                }
                case 3: { //inserir itens
                    System.out.println("\nDigite o pedido: ");
                    int p = teclado.nextInt(); // solicita o numero do pedido
                   
                    if (p==pedido.getCodigo()) { // como é apenas um pedido, fizemos uma simples comparação
                    
                        System.out.println("\nCódigo do produto | Nome ");
                        for (int c = 0; c < contProduto; c++ ) {
                            System.out.println(produtos[c].imprimir());
                        } 
                    
                        System.out.println("\nDigite o código do item que você quer inserir");
                        int codigo = teclado.nextInt();
                    
                        for (int i = 0; i < contProduto; i++) {
                            if (produtos[i].getCodigo() == codigo) { // condição para comparar o codigo escolhido com o codigo de cada produto
                                Item c = new Item (produtos[i]); //
                            
                                System.out.println("\nDigite o quantidade do produto");
                                int quantidade = teclado.nextInt();
                                
                                if (quantidade <= produtos[i].getQuantidade()) {                            
                                    c.setQuantidade(quantidade); // configura a quantidade de itens de acordo com a quantidade escolhida
                                    pedido.inserirItem(c); 
                                    produtos[i].venderProduto(quantidade);
                                    System.out.println("\nPedido realizado com sucesso");
                                } else {
                                    System.out.println("\nNão temos " + produtos[i].getNome()+ " o suficiente, temos apenas: "+ produtos[i].getQuantidade()+" no estoque");
                                }
                            }
                        }
                    }
                    break;
                }
                case 4: {// imprimir pedidos
                    System.out.println(pedido.imprimir());
                    break;
                }
                    
            }
            System.out.println(menu());
            op = teclado.nextInt();
        }
    }
}

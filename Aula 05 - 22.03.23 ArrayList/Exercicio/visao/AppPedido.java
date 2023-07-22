package visao;

import controle.*;
import javax.swing.JOptionPane;

public class AppPedido {
    public static String menu () {
        return "1. Cadastrar Produto \n"+
        "2. Comprar Produto\n"+
        "3. Cadastrar Pedido\n"+
        "4. Inserir Item no pedido\n"+
        "5. Imprimir pedido\n"+
        "6. Remover pedido\n"+
        "7. Sair\n"; 
    }
    
    
    public static void main (String [] args) {
       ControlePedido pedidos = new ControlePedido();
       ControleProduto produtos = new ControleProduto();
       
       int numPedido = 1;
       
       String opc = JOptionPane.showInputDialog(menu());
       int opcao = Integer.parseInt(opc);
       
       while (opcao != 7) {
           switch (opcao) {
                case 1: // cadastrar produto
                    String nome = JOptionPane.showInputDialog("Digite o nome do produto: ");
                    String pegarPreco = JOptionPane.showInputDialog("Digite o preço do produto: ");
                    int preco = Integer.parseInt(pegarPreco);
                    String pegarQuantidade = JOptionPane.showInputDialog("Digite a quantidade do produto");
                    int quantidade = Integer.parseInt(pegarQuantidade);
                    produtos.cadastrarProduto(nome, preco, quantidade);
                    JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
                    break;
                case 2: // comprar produto
                    if (produtos.getQuantidade()!=0) { // condição para analisar se há produtos cadastrados
                        
                        String nomeProdutos=""; // estrutura para dizer produtos cadastrados
                        for(int c = 0; c < produtos.getQuantidade(); c++) {
                           nomeProdutos+= produtos.imprimir(c) + "\n";
                        }
                        
                        String escolha = JOptionPane.showInputDialog("Qual o código do produto? \n" + nomeProdutos);
                        int codigo = Integer.parseInt(escolha);
                        
                        String pegarQtd = JOptionPane.showInputDialog("Qual a quantidade do produto?");
                        int qtd = Integer.parseInt(pegarQtd);
                        
                        if (produtos.comprarProduto(codigo, qtd)) {
                            JOptionPane.showMessageDialog(null,"Produto comprado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null,"Produto não encontrado.");
                        }
                        break; 
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum produto cadastrado!");
                        break;
                    }
                case 3: // cadastrar pedido
                    if (produtos.getQuantidade()!=0) { // condição para analisar se há produtos cadastrados                    
                        pedidos.cadastrarPedido(numPedido, "27/03/2023");
                        
                        String nomeProdutos=""; // estrutura para dizer produtos cadastrados
                        for(int c = 0; c < produtos.getQuantidade(); c++) {
                           nomeProdutos+= produtos.imprimir(c) + "\n";
                        } 
                        
                        String pedir = JOptionPane.showInputDialog("Qual código do produto escolhido?\n" + nomeProdutos);
                        int codigo = Integer.parseInt(pedir);
                        String pegarQtd = JOptionPane.showInputDialog("Qual a quantidade do produto?");
                        int qtd = Integer.parseInt(pegarQtd);
                        if (qtd <= produtos.pesquisarProduto(codigo).getQuantidade()) {
                            pedidos.adicionarItem(numPedido,produtos.pesquisarProduto(codigo), qtd);
                            JOptionPane.showMessageDialog(null,"Pedido feito com sucesso!");
                            ++numPedido;
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Produto insuficiente no estoque!");
                            break;                           
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum produto cadastrado!");
                        break;
                    }
                case 4: // inserir item no pedido
                    if (pedidos.getQuantidade() > 0) { // condição para analisar se tem pedido feito
                        
                        String pegarCodigo = JOptionPane.showInputDialog("Digite o código do pedido");
                        int codigo = Integer.parseInt(pegarCodigo);
                        
                         String nomeProdutos=""; // estrutura para dizer produtos cadastrados
                        for(int c = 0; c < produtos.getQuantidade(); c++) {
                           nomeProdutos+= produtos.imprimir(c) + "\n";
                        } 
                        
                        String pedir = JOptionPane.showInputDialog("Qual código do produto escolhido?\n" + nomeProdutos);
                        int codigoProduto = Integer.parseInt(pedir);
                        String pegarQtd = JOptionPane.showInputDialog("Qual a quantidade do produto?");
                        int qtd = Integer.parseInt(pegarQtd);       
                        
                        if (qtd <= produtos.pesquisarProduto(codigoProduto).getQuantidade()) {
                            if (pedidos.adicionarItem(codigo, produtos.pesquisarProduto(codigoProduto), qtd)) {
                                JOptionPane.showMessageDialog(null,"Item inserido com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null,"Pedido não encontrado!");
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Produto insuficiente no estoque!");
                            break;
                        }

                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum pedido registrado!");
                        break;
                    }
                case 5: // imprimir pedido
                    if (pedidos.getQuantidade() > 0) { // condição para analisar se tem pedido feito
                        String pegarCodigo = JOptionPane.showInputDialog("Digite o código do pedido");
                        int codigo = Integer.parseInt(pegarCodigo);     
                        JOptionPane.showMessageDialog(null,pedidos.imprimirPedido(codigo));
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum pedido registrado!");
                        break;
                    }
                case 6: // remover pedido
                    if (pedidos.getQuantidade() > 0) { // condição para analisar se tem pedido feito
                        String pegarCodigo = JOptionPane.showInputDialog("Digite o código do pedido");
                        int codigo = Integer.parseInt(pegarCodigo);    
                        if (pedidos.removerPedido(codigo)) {
                            JOptionPane.showMessageDialog(null,"Pedido removido com sucesso!");     
                        } else {
                            JOptionPane.showMessageDialog(null,"ERRO! Nenhum pedido encontrado!");
                        }
                        break;
                    
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum pedido registrado!");
                        break;
                    }    
           } // switch     
            opc = JOptionPane.showInputDialog(menu());
            opcao = Integer.parseInt(opc);       
       }//while   
    } // main 
} // app pedido

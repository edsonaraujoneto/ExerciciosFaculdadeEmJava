package visao;

import controle.*;
import javax.swing.JOptionPane;

public class ClassePrincipal {
    public static String menu(){
        return "Digite:\n" +
        "1 - Cadastrar produto \n" + 
        "2 - Imprimir produto \n"+
        "3 - Eh caro? \n"+
        "0 - para sair";
    }
    public static void main(String[] args) {
        
        ControleProduto cp = new ControleProduto();
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

        while (op!=0){
            switch (op){
                case 1: {//cadstrar produto
                    
                    String nome = JOptionPane.showInputDialog("Digite o nome do produto");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do produto"));
                    int op2 = Integer.parseInt(JOptionPane.showInputDialog("Este produto é um livro? \n1 - Sim \n2 - Não "));

                    if (op2 ==1){ // é livro
                        int op3 = Integer.parseInt(JOptionPane.showInputDialog("Este produto é um livro didático? \n1 - Sim \n2 - Não "));
                        if (op3 == 1) { // é didático
                            String autor = JOptionPane.showInputDialog("Digite o autor do livro");
                            int pag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de paginas do livro"));
                            String disciplina = JOptionPane.showInputDialog("Digite a disciplina do livro");
                            cp.cadastrarProduto(nome,preco,autor,pag,disciplina);
                            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
                        }  else { 
                            String autor = JOptionPane.showInputDialog("Digite o autor do livro");
                            int pag = Integer.parseInt(JOptionPane.showInputDialog("Digite o número de paginas do livro"));                    
                            cp.cadastrarProduto(nome, preco, autor, pag);
                            JOptionPane.showMessageDialog(null,"Produto cadastrado com sucesso!");
                        }
                    }
                    else{
                        cp.cadastrarProduto(nome, preco);
                    }
                    break;
                }
                
                case 2: {//Imprimir produto
                    
                    String nomeProdutos="";
                    for (int c = 1; c <= cp.quantidade(); c++) {
                        nomeProdutos += cp.getInformacao(c) + "\n";
                    }                 
                    
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto\n" + nomeProdutos));
                    JOptionPane.showMessageDialog(null,cp.imprimirProduto(codigo));
                    break;
                }
                
                case 3: {// eh caro
                    
                    String nomeProdutos="";
                    for (int c = 1; c <= cp.quantidade(); c++) {
                        nomeProdutos += cp.getInformacao(c) + "\n";
                    }  
                    
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto\n" + nomeProdutos));
                    if(cp.produtoEhCaro(codigo)) {
                        JOptionPane.showMessageDialog(null,"O produto é caro!");
                    } else {
                        JOptionPane.showMessageDialog(null,"O produto não é caro");    
                    }                 
                    break;
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
    } // main
} // classe principal

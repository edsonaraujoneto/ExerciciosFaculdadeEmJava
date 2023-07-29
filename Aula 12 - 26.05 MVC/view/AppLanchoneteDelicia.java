package view;

import controller.ControllerSalgado;
import javax.swing.JOptionPane;

public class AppLanchoneteDelicia {
    public static String menu(){
        return "Digite:\n" +
        "1 - Cadastrar salgado\n"+
        "2 - Listar salgado \n" +
        "3 - Pesquisar salgado \n"+
        "4 - Remover salgado \n"+
        "5 - Atualizar salgado \n"+
        "0 - para sair";
    }

    public static void main(String[] args) {
        ControllerSalgado controllerSalgado = new ControllerSalgado();
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        while (op!=0){
            switch (op){
                case 1:{ // Cadastrar Salgado
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do salgado");
                    double preco = Double.parseDouble(JOptionPane.showInputDialog("Digite o preco do salgado"));
                    controllerSalgado.cadastrarSalgado(descricao, preco);
                    JOptionPane.showMessageDialog(null,"Salgado cadastrado com sucesso!");
                    break;
                }
                case 2:{ // Listar salgado
                    JOptionPane.showMessageDialog(null,controllerSalgado.imprimir() );
                    break;
                }
                case 3: { // Pesquisar Salgado
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do salgado");     
                    if( controllerSalgado.pesquisarSalgado(descricao) != null) {
                        JOptionPane.showMessageDialog(null,controllerSalgado.pesquisarSalgado(descricao).toString());  
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Salgado não encontrado");    
                    }
                    break;
                }
                case 4:{//Remover salgado
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do salgado"); 
                    if(controllerSalgado.pesquisarSalgado(descricao)!=null) {
                        controllerSalgado.removerSalgado(controllerSalgado.pesquisarSalgado(descricao));
                        JOptionPane.showMessageDialog(null,"Salgado removido com sucesso!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Salgado não encontrado");
                    }
                    break;
                }
                case 5: {// Atualizar Salgado
                    String descricao = JOptionPane.showInputDialog("Digite a descrição do salgado"); 
                    if(controllerSalgado.pesquisarSalgado(descricao)!=null) {
                        controllerSalgado.atualizarSalgado(controllerSalgado.pesquisarSalgado(descricao));
                        JOptionPane.showMessageDialog(null,"Salgado atualizado com sucesso!");
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Salgado não encontrado!");
                    }
                    break;
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
            
        }
        
    }
    
}
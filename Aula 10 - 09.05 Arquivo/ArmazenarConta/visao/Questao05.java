package visao;

import java.util.ArrayList;
import controle.ControleConta;
import javax.swing.JOptionPane;
import javax.swing.JOptionPane;

public class Questao05 {
    

    public static String menu(){
        return "Banco AP2\n\n" +
        "1-Criar Conta\n" +
        "2-Pesquise Conta\n" +
        "3-Listar Conta\n" +
        "4-Sair\n\n" +
       "Digite a opção desejada:";
    }
    
    public static void main(String[] args) {
        ControleConta cC = new ControleConta ();
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        
        while (op!=4){
            switch (op){
                case 1:{//criar conta
                    String nome = JOptionPane.showInputDialog("Digite o nome: ");
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
                    cC.cadastrarConta(numero, nome, 0);
                    JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
                    break;
                } // case 1
                case 2:{//Pesquisar Conta
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Digite o número da conta: "));
                    if(cC.pesquisarConta(numero)!= null) {
                        JOptionPane.showMessageDialog(null,"Conta encontrada com sucesso!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Conta não encontrada");
                    }
                    break;
                } // case 2
                case 3: { //listar
                    JOptionPane.showMessageDialog(null,"Contas cadastradas: " + cC.listarConta());
                    break;
                }
            } // switch
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
    }   // main 
}

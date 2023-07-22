
import javax.swing.JOptionPane;

public class TestaBanco {

    public static String menu(){
        return "Escolha uma opção:\n"
        + "1 - Cadastrar conta\n"
        + "2 - Sacar\n"
        + "3 - Depositar\n"
        + "4 - Imprimir dados da conta\n" 
        + "5 - Extrato\n"        
        + "0 - Sair";
    }

    public static void main(String[] args) {
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        Conta c = new Conta();

        while (op !=0){
            switch (op){
                case 1:{ // Cadastrar Conta
                    c.numero = Integer.parseInt(JOptionPane.showInputDialog("Número da Conta:"));
                    c.nome = JOptionPane.showInputDialog("Nome do titular da conta:");
                    c.abertura = JOptionPane.showInputDialog("Data de cadastro da Conta:");

                    JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso");
                    break;
                }

                case 2:{ // Sacar
                    if (c.sacar (Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor a ser sacado: ")))) {
                        JOptionPane.showMessageDialog(null,"Saque efetuado com sucesso! SALDO ATUAL:" + c.saldo);
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Saque não realizado, saldo insuficiente! ");
                        break;
                    }
                }

                case 3:{ // Depositar
                    c.depositar(Double.parseDouble(JOptionPane.showInputDialog(null,"Digite o valor a ser depositado: ")));
                    JOptionPane.showMessageDialog(null,"Depositado realizado com sucesso!  SALDO ATUAL: " + c.saldo);
                    break;
                }

                case 4:{// Imprime os dados da conta
                    JOptionPane.showMessageDialog(null,c.imprime());
                    break;
                }

                case 5: { // Extrato
                    JOptionPane.showMessageDialog(null,c.extrato());
                    break;
                }
                default: 
                    JOptionPane.showMessageDialog(null, "Entrada inválida");
                    break;
                }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        }
    }
}
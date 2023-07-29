import javax.swing.JOptionPane;
import java.util.ArrayList;

// TestaConta
public class Questao12 {
    public static String menu(){
        return "Banco AP2\n\n" +
        "1-Criar Conta\n" +
        "2-Depositar Valor\n" +
        "3-Sacar Valor\n" +
        "4-Consultar Saldo\n" +
        "0-Finalizar\n\n" +
       "Digite a opção desejada:";
    }
    
    public static void main(String[] args) {
        ArrayList <Conta> contas = new ArrayList();
        int numContas = 0;
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        
        while (op!=0){
            switch (op){
                case 1:{//criar conta
                    contas.add(new Conta());
                    JOptionPane.showMessageDialog(null,"Conta criada com sucesso! | Numero da Conta: " + contas.get(numContas).getNumero());
                    numContas++;
                    break;
                } // case 1
                case 2:{//depositar
                    if (contas.size() > 0) {
                        boolean teste = true;
                        while (teste == true) {
                            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito:"));
                            try {
                                contas.get(numContas-1).depositar(valor);
                                JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso" );
                                teste = false;
                            }
                            catch (IllegalArgumentException a) {
                                JOptionPane.showMessageDialog(null,a.getMessage());
                            }
                        }
                    }
                    else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta criada."); 
                    }
                    break;
                } // case 2
                case 3: { //sacar
                    if (contas.size() > 0) {
                        boolean teste = true;
                            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
                            try {
                                contas.get(numContas-1).sacar(valor);
                                JOptionPane.showMessageDialog(null, "Saque realizado com sucesso" );
                            }
                            catch (SaldoInsuficienteException a) {
                                JOptionPane.showMessageDialog(null,a.getMessage());
                            }
                        
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Nenhuma conta criada.");  
                    break;
                }
                case 4: {//consultar saldo
                    if (contas.size() > 0) 
                        JOptionPane.showMessageDialog(null,"Seu saldo: " + contas.get(numContas-1).getSaldo());
                    else
                        JOptionPane.showMessageDialog(null,"Nenhuma conta criada.");
                    break;   
                }
            } // switch
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
    }   // main 
} // class

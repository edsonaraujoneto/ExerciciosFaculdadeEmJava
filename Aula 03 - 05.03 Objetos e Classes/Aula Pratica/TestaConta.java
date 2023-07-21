import javax.swing.JOptionPane;

public class TestaConta {
    
    public static String menu(){
        return "Digite:\n" +
        "1 - Criar conta \n"+
        "2 - Depositar \n"+
        "3 - Sacar \n"+
        "4 - Consultar saldo\n"+
        "5 - Imprimir conta\n" +
        "6 - Transferir\n" +
        "7 - Comparar\n"+
        "0 - para sair";
    }

    public static void main(String[] args) {
        
        int contConta=0;
        
        Conta contas[]= new Conta[10]; 
        
        String opc = JOptionPane.showInputDialog(menu());
        int op = Integer.parseInt(opc);
        
        while (op!=0 && contConta<10){
            switch (op){
                case 1:{//Cadastrar conta
                    String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
                    contas[contConta]= new Conta(nome);
                    contConta++;
                    JOptionPane.showMessageDialog(null,"Conta criada com sucesso!");
                    break;
                }
                case 2:{//Depositar
                    String num = JOptionPane.showInputDialog("Digite o numero da conta: ");
                    int numConta = Integer.parseInt(num);
                    String dep = JOptionPane.showInputDialog("Digite o valor do depósito: ");
                    double valor = Double.parseDouble(dep);
                    contas[numConta-1].depositar(valor);
                    break;
                }
                case 3:{//sacar
                    String num = JOptionPane.showInputDialog("Digite o numero da conta: ");
                    int numConta = Integer.parseInt(num);
                    String saq = JOptionPane.showInputDialog("Digite o valor do saque: ");
                    double valor = Double.parseDouble(saq);
                    
                    if(contas[numConta-1].sacar(valor)) {
                        JOptionPane.showMessageDialog(null, "Saque realizado com sucesso! ");
                    } else {
                        JOptionPane.showMessageDialog(null, "SALDO INSUFICIENTE!");
                    } 
                    break;
                }
                case 4: {//Consultar saldo
                   String num = JOptionPane.showInputDialog("Digite o numero da conta: ");
                   int numConta = Integer.parseInt(num);
                   JOptionPane.showMessageDialog(null,"O seu saldo é: " + contas[numConta-1].getSaldo());
                   break;
                }
                case 5: {//Imprimir dados da conta
                   String num = JOptionPane.showInputDialog("Digite o numero da conta: ");
                   int numConta = Integer.parseInt(num);
                   JOptionPane.showMessageDialog(null,contas[numConta-1].imprimir());
                   break;
                }
                case 6: { //transferir
                   String num = JOptionPane.showInputDialog("Digite o numero da conta que vai transferir: ");
                   int numConta = Integer.parseInt(num); 
                   String num2 = JOptionPane.showInputDialog("Digite o numero da conta que vai receber: ");
                   int numConta2 = Integer.parseInt(num2);
                   
                   String transf = JOptionPane.showInputDialog("Digite o valor da transferência");
                   double valor = Double.parseDouble(transf);
                   if(contas[numConta-1].transferir(valor,contas[numConta2-1])) {
                       JOptionPane.showMessageDialog(null,"Transferência realizada com sucesso!");
                   } else {
                       JOptionPane.showMessageDialog(null,"Transferência não realizada, saldo insuficiente!");
                   }
                   break;
                }
                case 7: { //comparar
                   String num = JOptionPane.showInputDialog("Digite o numero da conta? ");
                   int numConta = Integer.parseInt(num); 
                   
                   String num2 = JOptionPane.showInputDialog("Digite o numero da outra conta? ");
                   int numConta2 = Integer.parseInt(num2);
                   
                   if (contas[numConta-1].comparar(contas[numConta2-1])){
                       JOptionPane.showMessageDialog(null,"As contas correntes são iguais");
                   } else {
                       JOptionPane.showMessageDialog(null,"As contas correntes são diferentes");
                   }
                   break;
                   
                }
            }
            opc = JOptionPane.showInputDialog(menu());
            op = Integer.parseInt(opc);
        }
    }  
}

package visao;

import javax.swing.JOptionPane;
import controle.*;
import modelo.*;

public class BancoApp {

    public static String menu(){
        return "Banco AP2\n\n" +
            "1-Criar Conta\n" +
            "2-Depositar Valor\n" +
            "3-Sacar Valor\n" +
            "4-Consultar Saldo\n" +
            "5-Mostrar Histórico\n" +
            "6-Imprimir Contas\n"+
            "7-Cadastrar Cliente\n"+
            "0-Finalizar\n\n" +
           "Digite a opção desejada:";
    }
    
    public static void main(String[] args) {

        ControleConta cConta = new ControleConta();
        ControleCliente cCliente = new ControleCliente();
        
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        
        while (op!=0){
            switch (op){
                case 1:{//criar conta
                    if (cCliente.getNumClientes() != 0) {    // condição para analisar se tem cliente cadastrado
                        int opc = Integer.parseInt(JOptionPane.showInputDialog("Qual tipo de conta você quer criar? \n1.Conta Corrente \n2.Conta Poupança"));
                        long cpf; Cliente c;
                        switch (opc) {
                            case 1: // Conta Corrente
                                cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente:"));
                                c = cCliente.pesquisarCliente(cpf);
                                if (c!=null){
                                    cConta.cadastrarConta(c,0,0.01); // juros de 1%
                                    JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!" );
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "CPF inválido" );
                                }
                                break;
                            case 2: // Conta Poupança
                                cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente:"));
                                c = cCliente.pesquisarCliente(cpf);
                                if (c!=null){
                                    cConta.cadastrarConta(c,0.10); // rendimento de 10%
                                    JOptionPane.showMessageDialog(null, "Conta cadastrada com sucesso!" );
                                }
                                else{
                                    JOptionPane.showMessageDialog(null, "CPF inválido" );
                                }
                                break;  
                        }
                    } else { // condição clientecadastrado
                        JOptionPane.showMessageDialog(null,"Nenhum cliente cadastrado!");
                    }
                    break;
                } // case 1
                case 2:{//depositar
                    if (cConta.getNumContas() != 0) {
                        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta:"));
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do deposito:"));
                        cConta.depositar(numConta, valor);
                        JOptionPane.showMessageDialog(null, "Deposito realizado com sucesso" );
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta cadastrada!");
                    }
                    break;
                }
            
                case 3: { //sacar
                    if (cConta.getNumContas() != 0) {
                        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta:"));
                        double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor do saque:"));
                        if (cConta.sacar(numConta, valor)){
                            JOptionPane.showMessageDialog(null, "Saque realizado com- sucesso" );
                        }
                        else 
                            JOptionPane.showMessageDialog(null, "Valor inválido" );
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta cadastrada!");
                    }
                    break;
                }
                case 4: {//consultar saldo
                    if (cConta.getNumContas() != 0) {
                        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta:"));
                        JOptionPane.showMessageDialog(null, "Conta: "+ numConta+"\nSaldo: "+cConta.consultarSaldo(numConta));
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta cadastrada!");
                    }
                    break;
                }
                case 5: {// mostrar histórico
                    if (cConta.getNumContas() != 0) {
                        int numConta = Integer.parseInt(JOptionPane.showInputDialog("Digite o numero da conta:"));
                        JOptionPane.showMessageDialog(null,cConta.mostrarHistorico(numConta));
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta cadastrada!");
                    }
                    break;
                }
                case 6: { //imprimir contas
                    if (cConta.getNumContas() != 0) {
                        JOptionPane.showMessageDialog(null, cConta.imprimirContas() );
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhuma conta cadastrada!");
                    }
                    break;
                }
                case 7: {//Cadastrar Cliente
                    String nome = JOptionPane.showInputDialog("Digite o nome do cliente:");
                    long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF:"));
                    cCliente.cadastrarCliente(nome, cpf);
                    JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso!");
                }
            } // switch
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
    }   // main 
} // class

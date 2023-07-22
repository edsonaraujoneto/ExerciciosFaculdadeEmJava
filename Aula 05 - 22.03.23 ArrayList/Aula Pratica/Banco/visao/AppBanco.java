package visao;

import java.util.ArrayList;
import javax.swing.JOptionPane;
import modelo.Conta;
import modelo.Cliente;

public class AppBanco {
    public static String menu(){
        return "Digite:\n" +
        "1 - Criar conta \n"+ 
        "2 - Depositar \n"+ 
        "3 - Sacar \n"+ 
        "4 - Consultar saldo\n"+ 
        "5 - Imprimir conta\n" + 
        "6 - Cadastrar cliente\n" + 
        "0 - para sair"; 
    }
    
    public static void main(String[] args) {  
        ArrayList<Conta> contas = new ArrayList<Conta>();
        ArrayList <Cliente> clientes = new ArrayList <Cliente>();
        
        String opc = JOptionPane.showInputDialog(menu());
        int op = Integer.parseInt(opc); 
        
        int contadorCliente=0;
        int contadorConta=0;
    
        while (op!=0){
            switch (op){
                case 1:{//Criar conta
                    if (clientes.size() != 0) { //condição para analisar se tem algum cliente cadastrado
                        
                        Cliente c = (Cliente)clientes.get(contadorCliente-1); // converte o clientes para o tipo Cliente
                        JOptionPane.showMessageDialog(null,"\nNome do cliente cadastrado: " + c.getNome());

                        contas.add(new Conta(c)); // cria uma conta passando um cliente como parametro.
                        
                        Conta d = (Conta)contas.get(contadorConta);
                        
                        JOptionPane.showMessageDialog(null,"\nConta criada com sucesso! \nnúmero da conta: "+ d.getNumeroConta());
                        ++contadorConta;
                        break;
                    } else {
                       JOptionPane.showMessageDialog(null,"\nNenhum cliente cadastrado");
                       break;
                    } 
                }
                case 2:{//Depositar
                    if (clientes.size() != 0) { //condição para analisar se tem algum cliente cadastrado
                        if (contas.size() != 0) { // condição para analisar se tem conta criada
                           
                            String numContas ="";
                            for (int contador = 0; contador < contas.size(); contador++) { // for para mostrar todas as contas criadas
                                Conta c = (Conta)contas.get(contador);    
                                numContas += c.getNumeroConta() + "\n";
                            }                            
                            JOptionPane.showMessageDialog(null,"Suas contas: \n" + numContas);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer depositar?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador < contas.size(); contador++) {
                            Conta c = (Conta)contas.get(contador);
                                if (c.getNumeroConta() == opcao) { // condição para achar a conta escolhida
                                    String valor = JOptionPane.showInputDialog(null,"Digite o valor do depósito: ");
                                    double quantia = Double.parseDouble(valor);
                                    c.depositar(quantia);
                                    JOptionPane.showMessageDialog(null,"DEPOSITO REALIZADO COM SUCESSO");
                                    break;
                                }
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Você ainda não tem nenhuma conta!");
                            break;
                        } 
                    } else {
                       JOptionPane.showMessageDialog(null,"Nenhum cliente cadastrado");
                       break;
                    }
                }
                case 3:{//sacar
                    if (clientes.size() != 0) {
                        if (contas.size()!=0) {
                            
                            String numContas ="";
                            for (int contador = 0; contador < contas.size(); contador++) { // for para mostrar todas as contas criadas
                                Conta c = (Conta)contas.get(contador);    
                                numContas += c.getNumeroConta() + "\n";
                            }                            
                            JOptionPane.showMessageDialog(null,"Suas contas: \n" + numContas);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer sacar?");
                            int opcao = Integer.parseInt(escolha);
                                 
                            for (int cont = 0; cont <= contas.size(); cont++) {
                                Conta c = (Conta)contas.get(cont);
                                if (c.getNumeroConta() == opcao) {
                                    String valorSaque = JOptionPane.showInputDialog(null,"Digite o valor do saque: ");
                                    double quantiaSaque = Double.parseDouble(valorSaque);
                                    if (c.sacar(quantiaSaque)) {
                                        JOptionPane.showMessageDialog(null,"SAQUE REALIZADO COM SUCESSO");
                                        break;
                                    } else {
                                        JOptionPane.showMessageDialog(null,"SALDO INSUFICIENTE");
                                        break;
                                    }
                                }
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Você ainda não tem nenhuma conta!");
                            break;
                        }
                    } else {
                       JOptionPane.showMessageDialog(null,"Nenhum cliente cadastrado");
                       break;                       
                    }
                }
                case 4: {//Consultar saldo
                    if (clientes.size() != 0) {
                        if (contas.size()!=0) {
                            String numContas ="";
                            for (int contador = 0; contador < contas.size(); contador++) { // for para mostrar todas as contas criadas
                                Conta c = (Conta)contas.get(contador);    
                                numContas += c.getNumeroConta() + "\n";
                            }                            
                            JOptionPane.showMessageDialog(null,"Suas contas: \n" + numContas);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer ver o saldo?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador <= contas.size(); contador++) {
                                Conta c = (Conta)contas.get(contador);
                                if (c.getNumeroConta() == opcao) {
                                    JOptionPane.showMessageDialog(null,"Seu saldo é: " + c.getSaldo());
                                    break;
                                }
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Você ainda não tem nenhuma conta!");
                            break;
                        }
                    } else {
                       JOptionPane.showMessageDialog(null,"Nenhum cliente cadastrado");
                       break;                       
                    }
                }
                case 5: {//Imprimir dados da conta
                    if (clientes.size() !=0) {
                        if (contas.size()!=0) {
                            String numContas ="";
                            for (int contador = 0; contador < contas.size(); contador++) { // for para mostrar todas as contas criadas
                                Conta c = (Conta)contas.get(contador);    
                                numContas += c.getNumeroConta() + "\n";
                            }                            
                            JOptionPane.showMessageDialog(null,"Suas contas: \n" + numContas);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer consultar?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador <= contas.size(); contador++) {
                                Conta c = (Conta)contas.get(contador);
                                if (c.getNumeroConta() == opcao) {
                                    JOptionPane.showMessageDialog(null,c.imprimir());
                                    break;
                                }
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Você ainda não tem nenhuma conta!");
                            break;
                        }
                    } else {
                       JOptionPane.showMessageDialog(null,"Nenhum cliente cadastrado");
                       break;                       
                    }
                }
                case 6: { //Cadastrar Cliente
                    String nome = JOptionPane.showInputDialog("Digite o nome do cliente: ");
                    long cpf = Long.parseLong(JOptionPane.showInputDialog("Digite o CPF do cliente: "));
                    clientes.add(new Cliente(nome,cpf));
                    ++contadorCliente;
                    JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso!");
                    break;
                }
            }
            opc = JOptionPane.showInputDialog(menu());
            op = Integer.parseInt(opc);
        }
    }
}

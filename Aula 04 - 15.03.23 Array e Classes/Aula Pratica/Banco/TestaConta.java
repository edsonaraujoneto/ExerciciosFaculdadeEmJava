import javax.swing.JOptionPane;

public class TestaConta {
    
    public static String menu(){
        return "\nDigite:\n" +
        "1 - Criar conta \n"+ 
        "2 - Depositar \n"+ 
        "3 - Sacar \n"+ 
        "4 - Consultar saldo\n"+ 
        "5 - Imprimir dados da conta\n" +
        "6 - Cadastrar cliente\n"+ 
        "0 - para sair"; 
    }

    public static void main(String[] args) {
        
        int contConta=0; 
        Conta contas[]= new Conta[10];
        
        int contCliente = 0;
        Cliente cliente=new Cliente();
        
        String opc = JOptionPane.showInputDialog(menu());
        int op = Integer.parseInt(opc);
        
        while (op!=0){
            switch (op){
                case 1:{//Criar conta
                    if (contCliente !=0) { //condição para analisar se tem algum cliente cadastrado
                        JOptionPane.showMessageDialog(null,"\nNome do cliente cadastrado: " + cliente.getNome());
                        contas[contConta] = new Conta(cliente);
                        contas[contConta].setNumero(contConta);
                        
                        JOptionPane.showMessageDialog(null,"\nConta criada com sucesso! \nnúmero da conta: "+ contas[contConta].getNumero());
                        ++contConta;
                        break;
                    } else {
                       JOptionPane.showMessageDialog(null,"\nNenhum cliente cadastrado");
                       break;
                    } 
                }
                case 2:{//Depositar
                    if (contCliente !=0) { //condição para analisar se tem algum cliente cadastrado
                        if (contConta!=0) {
                            String numContas ="";
                            for (int contador = 0; contador < contConta; contador++) { // for para mostrar todas as contas criadas
                                numContas += contas[contador].getNumero() + "\n";
                            }                            
                            JOptionPane.showMessageDialog(null,"Suas contas: \n" + numContas);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer depositar?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador < contConta; contador++) {
                                if (contas[contador].getNumero() == opcao) {
                                    String valor = JOptionPane.showInputDialog(null,"Digite o valor do depósito: ");
                                    double quantia = Double.parseDouble(valor);
                                    contas[contador].depositar(quantia);
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
                    if (contCliente !=0) {
                        if (contConta!=0) {
                            
                            String numContas2 ="";
                            for (int contador = 0; contador < contConta; contador++) { // for para mostrar todas as contas criadas
                                numContas2 += contas[contador].getNumero() + "\n";
                            }
                        
                            JOptionPane.showMessageDialog(null,"Suas contas: " + numContas2);
                            
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer sacar?");
                            int opcao = Integer.parseInt(escolha);
                                 
                            for (int cont = 0; cont <= contConta; cont++) {
                                if (contas[cont].getNumero() == opcao) {
                                    String valorSaque = JOptionPane.showInputDialog(null,"Digite o valor do saque: ");
                                    double quantiaSaque = Double.parseDouble(valorSaque);
                                    if (contas[cont].sacar(quantiaSaque)) {
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
                    if (contCliente !=0) {
                        if (contConta!=0) {
                            String numContas ="";
                            for (int contador = 0; contador < contConta; contador++) { // for para mostrar todas as contas criadas
                                numContas += contas[contador].getNumero() + "\n";
                            }
                        
                            JOptionPane.showMessageDialog(null,"Suas contas: " + numContas);
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer ver o saldo?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador <= contConta; contador++) {
                                if (contas[contador].getNumero() == opcao) {
                                    JOptionPane.showMessageDialog(null,"Seu saldo é: " + contas[contador].getSaldo());
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
                    if (contCliente !=0) {
                        if (contConta!=0) {
                            String numContas ="";
                            for (int contador = 0; contador < contConta; contador++) { // for para mostrar todas as contas criadas
                                numContas += contas[contador].getNumero() + "\n";
                            }
                        
                            JOptionPane.showMessageDialog(null,"Suas contas: " + numContas);
                            String escolha = JOptionPane.showInputDialog(null,"Qual conta você quer consultar?");
                            int opcao = Integer.parseInt(escolha);
                            
                            for (int contador = 0; contador <= contConta; contador++) {
                                if (contas[contador].getNumero() == opcao) {
                                    JOptionPane.showMessageDialog(null,contas[contador].imprimir());
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
                    cliente = new Cliente (nome,cpf);
                    ++contCliente;
                    JOptionPane.showMessageDialog(null,"Cliente cadastrado com sucesso! \nBEM VINDO: " + cliente.getNome());
                    break;
                }
            }
            opc = JOptionPane.showInputDialog(menu());
            op = Integer.parseInt(opc);
        }
    }  
}

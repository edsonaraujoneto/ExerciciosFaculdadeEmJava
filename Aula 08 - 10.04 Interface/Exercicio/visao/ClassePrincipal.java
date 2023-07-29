package visao;
import javax.swing.JOptionPane;
import controle.*;


public class ClassePrincipal { 
    public static String menu () {
        return "Escolha a opção desejada: "+
        "\n1. Cadastrar Produto"+
        "\n2. Cadastrar Produto Fabricado (CARRO)"+
        "\n3. Inserir componentes no Carro"+
        "\n4. Sair";
    }
    
    public static void main (String [] args) {
        ControleProduto cP = new ControleProduto();
        ControleProdutoFabricado cPFB = new ControleProdutoFabricado();
        
        int opc;
        opc = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        
        while (opc != 4) {
            switch (opc) {
                case 1: // Cadastrar Produto
                    opc = Integer.parseInt(JOptionPane.showInputDialog("Qual o tipo de produto? \n1. Pneu \n2. Motor \n3. Banco"));
                    String marca; double custo; int codigo;
                    switch (opc) {
                        case 1: // pneu
                            marca = JOptionPane.showInputDialog("Digite a marca do pneu: ");
                            custo = Double.parseDouble(JOptionPane.showInputDialog("Digite o custo do pneu: "));
                            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do pneu: "));
                            
                            cP.cadastrarPneu(marca, custo,codigo);
                            JOptionPane.showMessageDialog(null,"Pneu cadastrado com sucesso!");
                            break;
                        case 2: // motor
                            marca = JOptionPane.showInputDialog("Digite a marca do motor: ");
                            custo = Double.parseDouble(JOptionPane.showInputDialog("Digite o custo do motor: "));
                            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do motor: "));

                            cP.cadastrarMotor(marca, custo,codigo);
                            JOptionPane.showMessageDialog(null,"Motor cadastrado com sucesso!");
                            break;
                        case 3: // banco
                            marca = JOptionPane.showInputDialog("Digite a marca do motor: ");
                            custo = Double.parseDouble(JOptionPane.showInputDialog("Digite o custo do motor: "));
                            codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do banco: "));
                           
                            cP.cadastrarBanco(marca, custo,codigo);
                            JOptionPane.showMessageDialog(null,"Banco cadastrado com sucesso!");
                            break;
                    }
                    break;
                case 2: // Cadastrar Produto Fabricado
                    if (cP.getQuantidade() != 0) { // condição para cadastrar produto antes
                        String nome; String marcaCarro; int ano;
                        nome = JOptionPane.showInputDialog("Digite o nome do carro ");
                        marcaCarro = JOptionPane.showInputDialog("Digite a marca do carro ");
                        ano = Integer.parseInt(JOptionPane.showInputDialog("Digite o ano do carro "));
                        cPFB.cadastrar(nome, marcaCarro, ano);
                        JOptionPane.showMessageDialog(null,"Carro criado com sucesso!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum produto cadastrado!");
                        break;
                    }
                case 3: // inserir componentes.
                    if (cP.getQuantidade() != 0 && cPFB.getQuantidade() != 0) {
                        
                        int codigoCar = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do carro: "));
                        
                        if (cPFB.pesquisarProduto(codigoCar) == null) {
                            JOptionPane.showMessageDialog(null,"ERRO! Nenhum carro encontrado!");
                            break;       
                        }
                        
                        int codigoPro = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do produto: "));
                        
                        if (cP.pesquisarProduto(codigoPro) == null) {
                            JOptionPane.showMessageDialog(null,"ERRO! Nenhum produto encontrado!");
                            break;
                        }
                            
                        cPFB.inserirComponentes(cP.pesquisarProduto(codigoPro), codigoCar);
                        JOptionPane.showMessageDialog(null,"Produto inserido com sucesso!");
                        break;
                    } else {
                        JOptionPane.showMessageDialog (null,"Você não cadastrou algum produto.");
                        break;
                    }
            }//switch
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu()));    
        } // while   
    } // main
} // classe principal

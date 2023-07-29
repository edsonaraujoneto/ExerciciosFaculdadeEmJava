
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Exercicio06 {
    
    public static String menu () {
        return "Digite a opção escolhida: "+
                "\n1. Cadastrar Funcionário"+
                "\n2. Cadastrar Professor"+
                "\n3. Sair";
    }
    
    public static void main (String[] args) {
        
        ArrayList <Pessoa> pessoas = new ArrayList(); 
        
        int opc = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        String nome,sobrenome,cpf,disciplina; int matricula; double salario;
        
        while (opc != 3) {
            switch (opc) {
                case 1: // cadastrar funcionário
                    nome = JOptionPane.showInputDialog("Digite o nome do funcionário: ");
                    sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do funcionário: ");
                    cpf = JOptionPane.showInputDialog("Digite o CPF do funcionário: ");
                    matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matrícula do funcionário: "));
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do funcionário: "));
                    pessoas.add(new Funcionario(nome,sobrenome,cpf, matricula,salario));
                    JOptionPane.showMessageDialog(null,"Funcionário cadastrado com sucesso!");
                    break;
                case 2: // cadastrar professor
                    nome = JOptionPane.showInputDialog("Digite o nome do professor: ");
                    sobrenome = JOptionPane.showInputDialog("Digite o sobrenome do professor: ");
                    cpf = JOptionPane.showInputDialog("Digite o CPF do professor: ");
                    matricula = Integer.parseInt(JOptionPane.showInputDialog("Digite a matrícula do professor: "));
                    salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o salário do professor: "));    
                    disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina do professor: ");
                    pessoas.add(new Professor(nome,sobrenome,cpf,matricula,salario,disciplina));
                   JOptionPane.showMessageDialog(null,"Professor cadastrado com sucesso!");
                    break;
            } // switch
            opc = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
        if (pessoas.size()>0) {
            String nomes="";
            for (int i = 0; i < pessoas.size();i++) {
                nomes += pessoas.get(i).toString() + "\n________________________\n";
            }
            JOptionPane.showMessageDialog(null,nomes);
        }  
    } // main
} // classe

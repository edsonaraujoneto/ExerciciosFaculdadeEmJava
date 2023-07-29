package visao;
import controle.ControleDisciplina;
import javax.swing.JOptionPane;
import modelo.Disciplina;
import controle.ControleAluno;
import modelo.Aluno;

public class AcademicoApp {
    public static String menu(){
        return "Digite:\n" +
        "1 - Cadastrar disciplina\n"+
        "2 - Listar disciplinas \n" +
        "3 - Pesquisar disciplina \n"+
        "4 - Cadastrar Aluno\n"+       
        "5 - Listar Alunos\n"+       
        "6 - Pesquisar Aluno\n"+       
        "0 - para sair";
    }
    
    public static void main(String[] args) {
        ControleDisciplina cd = new ControleDisciplina();
        ControleAluno ca = new ControleAluno();
        int op = Integer.parseInt(JOptionPane.showInputDialog(menu()));

        while (op!=0){
            switch (op){
                case 1:{ // Cadastrar Disciplina
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina"));
                    String nome = JOptionPane.showInputDialog("Digite o nome da disciplina");
                    int ch = Integer.parseInt(JOptionPane.showInputDialog("Digite a carga horária da disciplina"));
                    cd.cadastrarDisciplina(nome, codigo, ch);
                    JOptionPane.showMessageDialog(null,"Disciplina cadastrada com sucesso!");
                    break;
                }
                case 2:{ // Listar Disciplina
                    JOptionPane.showMessageDialog(null,cd.imprimir());
                    break;
                }
                case 3:{ // pesquisar disciplina
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código da disciplina"));
                    Disciplina d = cd.pesquisarDisciplina(codigo);
                    if (d != null){
                        JOptionPane.showMessageDialog(null,d.imprimir());
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Código não encontrado");
                    break;
                }
                case 4: { // Cadastrar Aluno
                    
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno");
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno"));
                    String cpf = JOptionPane.showInputDialog("Digite o CPF do aluno");
                    ca.cadastrarAluno(nome, codigo, cpf);
                    JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso!");
                    break;
                }
                case 5:{ // Listar Aluno
                    JOptionPane.showMessageDialog(null,ca.imprimir());
                    break;
                }
                case 6: { // pesquisar Aluno
                    int codigo = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do aluno"));
                    Aluno d = ca.pesquisarAluno(codigo);
                    if (d != null){
                        JOptionPane.showMessageDialog(null,d.imprimir());
                    }
                    else
                        JOptionPane.showMessageDialog(null,"Código não encontrado");
                    break;
                }
            }
            op = Integer.parseInt(JOptionPane.showInputDialog(menu()));
        } // while
    } // main    
} // classe

package visao;

import controle.*;
import modelo.*;
import javax.swing.JOptionPane;

public class Questao04 {
    public static String menu(){
        return "Digite:\n" +
        "1 - Cadastrar aluno \n" + 
        "2 - Cadastrar turma \n"+ 
        "3 - Matricular aluno \n"+ 
        "4 - Listar alunos da turma\n"+
        "0 - para sair";
    }
    
    public static void main (String [] args) {
        ControleTurma cT = new ControleTurma();
        ControleAluno cA = new ControleAluno();
    
        String opc = JOptionPane.showInputDialog(menu());
        int opcao = Integer.parseInt(opc);
        
        while (opcao != 0) {
            switch (opcao) {
                case 1: { // cadastrar aluno
                    String nome = JOptionPane.showInputDialog("Digite o nome do aluno: ");
                    String pegarMatricula = JOptionPane.showInputDialog("Digite a matricula do aluno");
                    int matricula = Integer.parseInt(pegarMatricula);
                    cA.cadastrarAluno(nome, matricula);
                    
                    JOptionPane.showMessageDialog(null,"Aluno cadastrado com sucesso! ");  
                    break;
                }
                case 2: { // cadastrar turma  
                    String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina");
                    String pegarCodigo = JOptionPane.showInputDialog("Digite o código da disciplina escolhida: ");
                    int codigo = Integer.parseInt(pegarCodigo);
                    String pegarMaximoAlunos = JOptionPane.showInputDialog("Digite o número máximo de alunos: ");
                    int maximoAlunos = Integer.parseInt(pegarMaximoAlunos);
                    
                    cT.cadastrarTurma(codigo, disciplina,maximoAlunos);
                    
                    JOptionPane.showMessageDialog(null,"Turma criada com sucesso! ");
                    break;
                }
                case 3: { // matricular aluno na turma
                    if (cA.getQtdAluno() != 0) { // condição para analisar se tem aluno cadastrado
                        if (cT.getQtdTurma() != 0) { // condição para analisar se tem turma criada 
                        
                            String nomeDeAlunos = cA.imprimirAlunos(); // função para imprimir todos os alunos
                            JOptionPane.showMessageDialog(null, "Aluno(s) cadastrado(s): \n MATRÍCULA | NOME \n" + nomeDeAlunos);

                            String pedirMatricula = JOptionPane.showInputDialog("Digite o número de matricula do aluno: ");
                            int matricula = Integer.parseInt(pedirMatricula);

                            for ( int c = 0; c < cA.getQtdAluno(); c++) {
                                if (matricula == cA.pesquisarAluno(matricula).getMatricula()) { // condição para encontrar o aluno escolhido
                                    Aluno alunoEscolhido = cA.pesquisarAluno(matricula); // guardar o aluno escolhido no objeto alunoEscolhido                                
                                    String nomeTurmas = cT.imprimirTurmas();     // função para imprimir todas as turmas
                                    String escolher = JOptionPane.showInputDialog("Qual código da turma que você quer cadastrar o aluno? \nCÓDIGO | DISCIPLINA \n" + nomeTurmas);
                                    int escolheu = Integer.parseInt(escolher);

                                    for (int e = 0; e < cT.getQtdTurma() ; e++) {
                                        if (escolheu == cT.pesquisarTurma(escolheu).getCodigo()) { // condição para achar a turma escolhida através do código
                                            Turma turmaEscolhida = cT.pesquisarTurma(escolheu); // criei uma turma para evitar ficar pesquisando todo momento a turma escolhida
                                            
                                            if (turmaEscolhida.getQtdAluno() < turmaEscolhida.getNumMaxAluno()){
                                                if (turmaEscolhida.matricular(alunoEscolhido)) {
                                                    JOptionPane.showMessageDialog(null,"Aluno matriculado com sucesso!");
                                                    break;
                                                } else {
                                                    JOptionPane.showMessageDialog(null,"O aluno já está matriculado!");
                                                }
                                            } else {
                                                JOptionPane.showMessageDialog(null,"A turma está cheia!");
                                                break;
                                            }
                                        }
                                    }
                                    break;
                                }    
                            }
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null,"Nenhuma turma criada!");
                            break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum aluno cadastrado.");
                        break;
                    }  
                }
                case 4: { // listar alunos da turma
                    if (cT.getQtdTurma() != 0 ) {
                        String nomeTurmas=cT.imprimirTurmas();             
                        String escolher = JOptionPane.showInputDialog("Qual código da turma que você quer ver a lista dos alunos? \n CÓDIGO | DISCIPLINA \n" + nomeTurmas);
                        int escolheu = Integer.parseInt(escolher);           

                        for (int e = 0; e < cT.getQtdTurma() ; e++) {
                            if (escolheu == cT.pesquisarTurma(escolheu).getCodigo()) {
                                JOptionPane.showMessageDialog(null,cT.listarAlunos(escolheu));
                                break;
                            }
                        }
                        break;
                    } else {
                        JOptionPane.showMessageDialog(null,"Nenhum turma criada!");
                        break;
                    }
                }
            }
            opc = JOptionPane.showInputDialog(menu());
            opcao = Integer.parseInt(opc);   
        }
    }  
}
